import org.apache.log4j._
import org.apache.spark.sql._

object LoadDataset_Kvinnor {
    
    case class Nation(Name: String, number: Double)
    
    def mapper(line: String): Nation = {
        val fields = line.split(',')
        
        if (fields(0) == "name")
            Nation("name", 0)
        else {
            val name: Nation = Nation(fields(0), fields(1).toDouble)
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
            .appName("FemaleName")
            .master("local[*]")
            .getOrCreate()
        
        val lines = spark.sparkContext.textFile("data/tilltalsnamn-man.txt")
        val lang = lines.map(mapper) //sköter converteringen, går in och tar rad för rad och gör om det till en nation
        
        // Infer the schema, and register the DataSet as a table.
        import spark.implicits._
        val schemaNames = lang.toDS
        
        schemaNames.printSchema()
        
        schemaNames.createOrReplaceTempView("namelist")
        
        // SQL can be run over DataFrames that have been registered as a table
        val nat = spark.sql("SELECT * FROM namelist")

        println("==== Uppg 1.a ====")
        /**
         * skapa val commonNames som innehåller alla mansnamn med
         *   frekvens > 150000, och skriv ut dem
         */
        val commonNames = spark.sql("select name,number from name where number > 1500").show()


        nat.show()
        
        spark.stop()
    }
}