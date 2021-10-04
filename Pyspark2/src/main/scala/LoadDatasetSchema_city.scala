
import org.apache.log4j._
import org.apache.spark.sql._


object LoadDatasetSchema_city {
    
    case class Nation(city: String, city_ascii: String, lat: Double,lng: Double,country: String,iso2: String,iso3: String,admin_name: String,capital: String,population: Double,id: Double )

    /** Our main function where the action happens */
    def main(args: Array[String]) {
        
        // Set the log level to only print errors
        Logger.getLogger("org").setLevel(Level.ERROR)
        
        // Use new SparkSession interface in Spark 2.0
        val spark = SparkSession
            .builder
            .appName("Nation")
            .master("local[*]")
            .getOrCreate()
    
        // Load each line of the source data into an Dataset
        import spark.implicits._
        val schemaNat = spark.read
            .option("header", "true")
            .option("sep", ",")
            .option("inferSchema", "true")
            .csv("data/worldcities.csv")
            .as[Nation]
    
        schemaNat.printSchema()
    
        schemaNat.createOrReplaceTempView("nation")
        
        // SQL can be run over DataFrames that have been registered as a table
        //val nat = schemaNat.select("country","city").groupBy("country").agg(functions.count("city")).orderBy($"count(city)".desc)
        //val nat = schemaNat.select("country","city").groupBy("country").agg(functions.count("city")).orderBy($"count(city)".desc)
        //nat.show()
        val nat = schemaNat.select("country","city", "population").orderBy(($"population").desc).show(20)

        
        spark.stop()
    }
}