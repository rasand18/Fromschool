import scala.io.Source

object parexempel_3 {
  def main(args: Array[String]): Unit = {
    val filename = "data/Text.txt"

    for(line <- Source.fromFile(filename).getLines) {
      println(line)
    }
    val linelist = Source.fromFile(filename).getLines().toList
    println(linelist)

    val lineArray = Source.fromFile(filename).getLines().toArray
    //println(lineArray)
    lineArray.foreach(println)

    val lineContent = Source.fromFile(filename).getLines().mkString
    println(lineContent)

    val bufferedSource = Source.fromFile(filename)
    for(line <- bufferedSource.getLines) {
      println(line.toUpperCase())
    }
    bufferedSource.close()
  }
}
