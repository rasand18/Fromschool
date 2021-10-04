import Uppg_1_CountNames.splitLine
import org.apache.log4j._
import org.apache.spark.sql._

object Uppg_2_Nations {
  // case class Language(CountryID: String, LangID: String, LangStatus: String, Name: String)
  case class Nation(nation: String, population: Long, continent: String)

  /** Our main function where the action happens */
  def main(args: Array[String]) {

    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Use SparkSession interface
    println("------------------------------------------")
    println("Get spark session:")
    val spark = SparkSession
      .builder
      .appName("SparkSQL")
      .master("local[*]")
      .getOrCreate()
    println("------------------------------------------")

    // Load each line of the source data into an Dataset
    import spark.implicits._
    val schemaNation = spark.read
      .option("header", "true")
      .option("sep", ";")
      .option("inferSchema", "true")
      .csv("data/nations.csv")
      .as[Nation]

    schemaNation.printSchema()

    schemaNation.createOrReplaceTempView("nation")

    println("==== Uppg 2.a ====")
    /**
     * skapa val oceania som MED metoden spark.sql listar alla
     *    länder i Oceanien "Oc", som har mer än en miljon invånare,
     *    och skriv ut dem
     */
    val oceania = spark.sql("select nation from nation where continent like 'Oc'")



    println("==== Uppg 2.b ====")
    /**
     * skapa val america som MED metoden schemaNation.select
     *    listar alla länder i Sydamerika och Nordamerica med
     *    invånarantal större än 10 miljoner
     */


    println("==== Uppg 2.c ====")


    /**
     * skapa val biggest som MED metoden schemaNation.select
     *    som listar alla länder med mer än 100 miljoner invånare
     *    sortera på namn, filtrera bort fejk-länder!
     *
     */


    val america = schemaNation.where("population > 10000000").filter("continent = 'Na' or continent = 'Sa'").show()

    val biggesta = schemaNation.where("population > 100000000").filter("nation != '@'").orderBy("nation").show()



    spark.stop()
  }
}