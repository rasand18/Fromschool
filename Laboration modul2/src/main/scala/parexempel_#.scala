import scala.io.Source
object parexempel_# {
  def main(args: Array[String]): Unit = {
    val filename = "data/Text.txt"

    for(line <- Source.fromFile(filename).getLines) {
      println(line)
    }
  }
}
