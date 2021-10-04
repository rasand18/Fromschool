
import org.apache.log4j._
import org.apache.spark.sql._

object LoadDatasetSchema {
    
    case class Nation(nation: String, cit: Double, area: Double)

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
            .option("sep", ";")
            .option("inferSchema", "true")
            .csv("data/stub-stubbe.csv")
            .as[Nation]
    
        schemaNat.printSchema()
    
        schemaNat.createOrReplaceTempView("nation")
        
        // SQL can be run over DataFrames that have been registered as a table
        val nat = spark.sql("SELECT * FROM nation")
        nat.show()
        
        val results = nat.collect()
        
        results.foreach(println)
        
        spark.stop()
    }
}