import java.io.PrintWriter
import scala.io.Source
import java.io.File

object Assessment1_Convertdata {
  def main(args : Array[String]): Unit = {
    val filename = "data/house-votes-84.data"
    val source = Source.fromFile(filename)
    val lines = source.getLines()
    val svm_file = new PrintWriter(new File("data/house-votes.svm"))
    for (line <- lines) {
      val cols = line.split(",")
      var earn = cols(0) match {
        case "republican" => 2
        case "democrat" => 1
      }
      var earn1 = cols(1) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn2 = cols(2) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn3 = cols(3) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn4 = cols(4) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn5 = cols(5) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn6 = cols(6) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn7 = cols(7) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn8 = cols(8) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn9 = cols(9) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn10 = cols(10) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn11 = cols(11) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn12 = cols(12) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn13 = cols(13) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn14 = cols(14) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn15 = cols(15) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      var earn16 = cols(16) match {
        case "y" => 2
        case "n" => 0
        case _ => 1
      }
      svm_file.write(s"${earn} 1:$earn1 2:$earn2 3:$earn3 4:$earn4 5:$earn5 6:$earn6 7:$earn7 8:$earn8 9:$earn9 10:$earn10 11:$earn11 12:$earn12 13:$earn13 14:$earn14 15:$earn15 16:$earn16\n")
    }
    svm_file.close()
  }
}
