
import org.apache.log4j._
import org.apache.spark.ml.recommendation._
import org.apache.spark.rdd.RDD
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object ovningar_3_musik {
  def main(args : Array[String]) : Unit = {
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    println("------------------------------------------------------------------")
    println("Get Spark session")
    // Use new SparkSession interface in Spark 2.0
    val spark = SparkSession
      .builder
      .appName("ovningar_3_musik")
      .master("local[*]")
      .getOrCreate()
    println("Got Spark session")
    println("------------------------------------------------------------------")

    //2 Load play count schema

    val rawplay = spark.sparkContext.textFile("data/user_artist_data_small.txt")
    rawplay.take(5).foreach(println)

    //3 Define the play count table schema

    val playschema = "user_id artist_id playcount"
    val pcfields = playschema.split(" ").map(fieldName => StructField(fieldName, IntegerType, nullable = true))
    val pcschema = StructType(pcfields)
    println(pcschema)

    //4

    val rowRD = rawplay.map {
      _.split(' ')
    }.map { x => Row(x(0).toInt, x(1).toInt, x(2).toInt) }
    val playcounts = spark.createDataFrame(rowRD, pcschema).cache()
    playcounts.createOrReplaceTempView("playcounts")

    //5
    //spark.sql("select * from playcounts").show(50)

    //6
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
    println(artists.count())

    //14

    playcounts.join(artists, playcounts.col("artist_id") === artists.col("id")).
    select("user_id", "artist", "playcount").show(10)

    //9
    spark.sql("""select pc.user_id, a.artist, pc.playcount
          from playcounts pc join artists a on a.id = pc.artist_id
          limit 10""").show

    //15

    spark.sql(
      """select a.artist, sum(pc.playcount) as all_playcounts
         from playcounts pc join artists a on a.id = pc.artist_id
         group by a.artist
         order by all_playcounts desc
         limit 10""").show()


    val Array(training, test) = playcounts.randomSplit(Array(0.8, 0.2))

    val model = new ALS().
      setSeed(42).
      setImplicitPrefs(true).
      setNumBlocks(10).
      setRank(10).
      setMaxIter(5).
      setUserCol("user_id").
      setItemCol("artist_id").
      setRatingCol("playcount").
      setPredictionCol("prediction").
      fit(training)

    model.setColdStartStrategy("drop")
    val predictions = model.transform(test)
    predictions.
      sample(true, 0.10).
      orderBy(desc("user_id")).
      join(artists, col("artist_id") === artists.col("id")).
      select("user_id", "artist", "playcount", "prediction").
      show(10)
  }
}
