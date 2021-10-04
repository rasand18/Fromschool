
import org.apache.log4j._
import org.apache.spark.sql._

object LoadDatasetSchema_nations {
    
    case class Nation(nation: String, population: Double,continent: String)

    /** Our main function where the action happens */
    def main(args: Array[String]) {
        
        // Set the log level to only print errors
        Logger.getLogger("org").setLevel(Level.ERROR)
        
        // Use new SparkSession interface in Spark 2.0
        val spark = SparkSession
            .builder
            .appName("Nations")
            .master("local[*]")
            .getOrCreate()
    
        // Load each line of the source data into an Dataset
        import spark.implicits._
        val schemaNat = spark.read
            .option("header", "true")
            .option("sep", ";")
            .option("inferSchema", "true")
            .csv("data/nations.csv")
            .as[Nation]
    
        schemaNat.printSchema()
    
        schemaNat.createOrReplaceTempView("nation")
        
        // SQL can be run over DataFrames that have been registered as a table
        //3.2.2.e1
        //val nat = spark.sql("SELECT * from nation where continent = 'Eu'")
        //3.2.2.e2
        //val nat = spark.sql("SELECT sum(population) from nation where continent = 'Eu'")
        //3.2.2.e3
        //val nat = spark.sql("SELECT sum(population),continent from nation group by continent")
        //SPARK METODER

        //val nat = schemaNat.select("nation","population","continent").filter("Continent = 'Eu'")

        //val nat = schemaNat.select("nation","population","continent").filter("Continent = 'Eu'").agg(functions.sum("population"))

        //val nat = schemaNat.select("nation","population","continent").groupBy("continent").agg(functions.sum("population"))

        //val nat = schemaNat.select("nation","population","continent").agg(functions.sum("population"))

        //val nat = schemaNat.select("nation","population","continent").agg(functions.avg("population"))

        //val nat = schemaNat.select("nation").filter("continent like 'Eu'")

        val nat = schemaNat.select("continent","population").filter("continent like 'Eu'").groupBy("continent").agg(functions.sum("population"))



        nat.show()
        
        val results = nat.collect()
        
        results.foreach(println)
        
        spark.stop()
    }
}