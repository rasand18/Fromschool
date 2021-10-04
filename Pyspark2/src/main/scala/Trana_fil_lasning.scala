import org.apache.log4j.{Level, Logger}
import org.apache.log4j._
import org.apache.spark.sql._
import org.sparkproject.guava.collect.Ordering

object Trana_fil_lasning {

  case class kvinnor(name : String, antal : Double)

  def mapper(line : String) : kvinnor = {
    val splittin = line.split(",")
    val name : kvinnor =kvinnor(splittin(0),splittin(1).toDouble)
    name
  }

  def main(args : Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder()
      .appName("Kvinnonamn")
      .master("local[*]")
      .getOrCreate()

    val lines = spark.sparkContext.textFile("data/tilltalsnamn-kvinnor.txt").filter(!_.contains("name"))
    val lang  = lines.map(mapper)


    import spark.implicits._
    val schemaName = lang.toDS()
    schemaName.printSchema()

    schemaName.createOrReplaceTempView("names")

    //val nat = spark.sql("select * from names").show()
    //val nata = schemaName.where("name like 'B%'").show()

    spark.stop()
  }
}
