import LoadDataset_Kvinnor.mapper
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object Uppg_1_CountNames {
  def splitLine(line : String) : (String, Int) = {
    val word = line.split(",")
    if(word(0) == "name")
      ("name", 0)
    else
      (word(0), word(1).toInt)
  }
  def main(args: Array[String]): Unit = {
    val maleNames = "tilltalsnamn-man.txt"

    Logger.getLogger("org").setLevel(Level.FATAL)
    println("------------------------------------------")
    println("Get spark context:")
    val sc = new SparkContext("local[*]", "CountNames (CheckPoint)")
    println("------------------------------------------")

    println("Attach file:")
    val lines = sc.textFile(s"data/$maleNames")


    /** Referenser:
     * https://spark.apache.org/docs/2.0.0/programming-guide.html#transformations
     * https://spark.apache.org/docs/2.0.0/programming-guide.html#actions
     */

    println("==== Uppg 1.a ====")
    /**
     * skapa val commonNames som innehåller alla mansnamn med
     *   frekvens > 150000, och skriv ut dem
     */
    val commonNames = lines.map(splitLine).filter(x => x._2 > 1500)

    println("==== Uppg 1.b ====")

    /**
     * skapa val longNames som innehåller alla mansnamn
     *   längre än 18 tecken, och skriv ut dem
     */

    val longnames = lines.map(splitLine).filter(x => x._1.length>18)


    println("==== Uppg 1.c ====")
    /**
     * skapa val numGru som anger hur många namn som
     *    börjar på "Gru", och skriv ut värdet
     */
    sc.stop()
  }
}
