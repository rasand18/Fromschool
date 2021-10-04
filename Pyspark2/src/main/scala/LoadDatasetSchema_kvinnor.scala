
import org.apache.log4j._
import org.apache.spark.sql.functions.{count, desc, max}
import org.apache.spark.sql._

object LoadDatasetSchema_kvinnor {
    
    case class Nation(name: String, number: Double)

    /** Our main function where the action happens */
    def main(args: Array[String]) {
        
        // Set the log level to only print errors
        Logger.getLogger("org").setLevel(Level.ERROR)
        
        // Use new SparkSession interface in Spark 2.0
        val spark = SparkSession
            .builder
            .appName("Women")
            .master("local[*]")
            .getOrCreate()
    
        // Load each line of the source data into an Dataset
        import spark.implicits._
        val schemaNat = spark.read
            .option("header", "true")
            .option("sep", ",")
            .option("inferSchema", "true")
            .csv("data/tilltalsnamn-kvinnor.txt")
            .as[Nation]
    
        schemaNat.printSchema()
    
        schemaNat.createOrReplaceTempView("nation")
        
        // SQL can be run over DataFrames that have been registered as a table
        //3.2.2.1
        //val nat = spark.sql("SELECT * FROM nation where name like 'Q%'")
        //3.2.2.2
        //val nat = spark.sql("SELECT * FROM nation where name like '%Päivi%'" )
        //3.2.2.3
        //val nat = spark.sql("SELECT count(*) FROM nation where name like '%-%'" )
        //3.2.2.4
        //val nat = spark.sql("SELECT count(*) FROM nation where name like '% %'" )
        //3.2.2.5
        //val nat = spark.sql("SELECT name,number FROM nation order by number desc limit 1 ")
        //3.2.2.6
        //val nat = spark.sql("SELECT name,number FROM nation where number = 1")
        //3.2.2.7
        //val nat = spark.sql("SELECT name,number FROM nation order by number desc limit 50")
        // SPARK - METODER
        //3.2.2.1
        //schemaNames.select("*").filter($"Name" startsWith "Q").show(10)
        println("---- uppgift 3.2.3.1 ----")
       // val nat = spark.sql("SELECT COUNT(*) antal FROM nation WHERE name like 'Q%'")
        //val nat = schemaNat.select("*").filter("Name like 'Q%'").select(count("*").as("antal"))
        println("---- uppgift 3.2.2.2 ----")
        //val nat = schemaNat.select("*").filter("Name like '%Päivi%'").select(count("*").as("antal"))
        println("---- uppgift 3.2.2.3 ----")
        //val nat = schemaNat.select("*").filter("Name like '%-%'").select(count("*").as("antal"))
        println("---- uppgift 3.2.2.5 ----")
        //val nat = schemaNat.select("name","number").orderBy(desc("number")).limit(1)
        //val nat = schemaNat.select("name","number").orderBy(desc("number")).limit(1)
        //val nat = schemaNat.select("*").orderBy($"number".desc)
        //GÖR OM ÖVNINGARNA IGEN
        //val nat = spark.sql("select count(*) from nation where name like 'Q%'")
        //val nat = spark.sql("select count(*) from nation where name like '%Päivi%'" )
        //val nat = spark.sql("select count(*) from nation where name like '%-%'")
        // val nat = spark.sql("select * from nation order by number desc")
        //val nat = schemaNat.select("*").filter("name like 'Q%'").select(count("*"))
        //val nat = schemaNat.select("*").filter("name like '%Päivi'").select("*").orderBy(desc("number")).show(1)
        //val nat = schemaNat.select("*").orderBy(desc("number")).show(1)
        //val nat = schemaNat.select("*").orderBy(desc("number")).show(50)
        //NYA INGEN
        //val nat = spark.sql("select * from nation where name like 'Q%'").show()
        //val nat = spark.sql("select * from nation where name like 'Q%'").show()
        //val nat = spark.sql("select count(*) from nation where name like '%Päivi%'").show()
        //val nat = spark.sql("select count(*) from nation where name like '%-%'").show()
        //val nat = spark.sql("select count(*) from nation where name like '% %'").show()
        //val nat = spark.sql("select * from nation order by number desc").show()
        //val nat = spark.sql("select * from nation where number like 2").show()
        //val nat = schemaNat.select("*").filter("name like 'Q%'").show()
        val dfschema = schemaNat.toDF()
        dfschema.select("*").where("name == 'Anna'").show()


        spark.stop()
    }
}