
  /*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

  // scalastyle:off println
  // $example on$
  import org.apache.spark.ml.evaluation.RegressionEvaluator
  import org.apache.spark.ml.recommendation.ALS
  import org.apache.log4j._
  import org.apache.spark.rdd.RDD
  import org.apache.spark.sql.{Dataset, Row}
  import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

  import scala.collection.mutable
  import scala.math._
  // $example off$
  import org.apache.spark.sql.SparkSession

  /**
   * An example demonstrating ALS.
   * Run with
   * {{{
   * bin/run-example ml.ALSExample
   * }}}
   */
  object ALSMusic {

    // $example on$
    case class Rating(userId: Int, artistId: Int, playcounts: Double)
    def parseRating(str: String): Rating = {
      val fields = str.split(" ")
      assert(fields.size == 3)
      Rating(fields(0).toInt, fields(1).toInt, log10(fields(2).toFloat))
    }
    // $example off$

    def main(args: Array[String]): Unit = {

      Logger.getLogger("org").setLevel(Level.ERROR)

      val spark = SparkSession
        .builder
        .appName("ALSMusic")
        .config("spark.master", "local")
        .getOrCreate()
      import spark.implicits._

      // $example on$
      val playcount = spark.read.textFile("data/user_artist_data_small.txt").map(parseRating).toDF()
      val rawArtists = spark.sparkContext.textFile("data/artist_data_small.txt")
      val aSchemaString = "id artist"

      val aSchema = StructType(
        Array(StructField("id", IntegerType, nullable = true),
          StructField("artist", StringType, nullable = true)))

      val rowRDD1 : RDD[Row] = rawArtists.flatMap { line =>
        val (id, artist) = line.span(_ != '\t')
        if (artist.isEmpty) {
          None
        } else {
          try {
            Some(Row(id.toInt, artist.trim))
          } catch {
            case _: Exception => None
          }
        }
      }

      val artists = spark.createDataFrame(rowRDD1: RDD[Row], aSchema : StructType).cache()
      artists.createOrReplaceTempView("artists")
      val Array(training, test) = playcount.randomSplit(Array(0.8, 0.2))

      playcount.join(artists, playcount.col("artistId") === artists.col("id")).
        select("userId", "artist", "playcounts").show(10)

      // Build the recommendation model using ALS on the training data
      val als = new ALS()
        .setMaxIter(5)
        .setRegParam(0.01)
        .setUserCol("userId")
        .setItemCol("artistId")
        .setRatingCol("playcounts")
      val model = als.fit(training)

      // Evaluate the model by computing the RMSE on the test data
      // Note we set cold start strategy to 'drop' to ensure we don't get NaN evaluation metrics
      model.setColdStartStrategy("drop")
      val predictions = model.transform(test)

      val evaluator = new RegressionEvaluator()
        .setMetricName("rmse")
        .setLabelCol("playcounts")
        .setPredictionCol("prediction")
      val rmse = evaluator.evaluate(predictions)
      println(s"Root-mean-square error = $rmse")

      // Generate top 10 movie recommendations for each user
      val userRecs = model.recommendForAllUsers(10)
      // Generate top 10 user recommendations for each movie
      val movieRecs = model.recommendForAllItems(10)

      // Generate top 10 movie recommendations for a specified set of users
      val users = playcount.select(als.getUserCol).distinct().limit(3)
      val userSubsetRecs = model.recommendForUserSubset(users, 10)
      // Generate top 10 user recommendations for a specified set of movies
      val movies = playcount.select(als.getItemCol).distinct().limit(3)
      val movieSubSetRecs = model.recommendForItemSubset(movies, 10)
      // $example off$

      val userCol : Dataset[Row] = userRecs.sort("userId")
      val artistCol : Dataset[Row] = playcount.sort("artistId")
      val r = userCol
      for(user <- r) {
        println(s"Rexommendationz for uzr ${user.getInt(0)}:")
        for(rec <- user.getAs[mutable.WrappedArray[Row]](1)) {
          println(s"  band ${rec.getInt(0)} with ${rec.getFloat(1)} approvacy")
        }
      }

//      userRecs.show()
//      movieRecs.show()
//      userSubsetRecs.show()
//      movieSubSetRecs.show()
      spark.stop()
    }
  // scalastyle:on println
}
