import org.apache.log4j._
import org.apache.spark.sql._

object LoadDataset {
    
    case class Nation(Name: String, milCit: Double, area: Double)
    
    def mapper(line: String): Nation = {
        val fields = line.split(';')
        
        if (fields(0) == "nation")
            Nation("nation", 0, 0)
        else {
            val name: Nation = Nation(fields(0), fields(1).toDouble, fields(2).toDouble)
            name
        }
    }
    
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
        
        val lines = spark.sparkContext.textFile("data/stub-stubbe.csv")
        val lang = lines.map(mapper) //sköter converteringen, går in och tar rad för rad och gör om det till en nation
        
        // Infer the schema, and register the DataSet as a table.
        import spark.implicits._
        val schemaNames = lang.toDS
        
        schemaNames.printSchema()
        
        schemaNames.createOrReplaceTempView("nation")
        
        // SQL can be run over DataFrames that have been registered as a table
        val nat = spark.sql("SELECT * FROM nation")
        nat.show()
        
        spark.stop()
    }
}