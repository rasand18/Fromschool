import org.w3c.dom.css.Counter

import scala.io.Source
object parexempel_4 {
  def main(args: Array[String]): Unit = {

    //2.3.1 Hur många namn börjar på bokstaven q?

//    val filename = "data/tilltalsnamn_kvinnor.txt"
//    var sum = 0
//    for(line <- Source.fromFile(filename).getLines) {
//     if(line(0) == 'Q'){
//       sum = sum + 1
//     }
//    }
//    println(sum)

    //2.3.2 Hur många namn börjar på Pääivi?

//    val filename = "data/tilltalsnamn_kvinnor.txt"
//    var sum = 0
//    for(line <- Source.fromFile(filename).getLines) {
//      if (line.startsWith("Päivi")) {
//        sum = sum + 1
//      }
//    }
//      println((sum))

//  2.3.3 Hur många har dubbelnamn med bindesteck?

//    val filename = "data/tilltalsnamn_kvinnor.txt"
//    var sum = 0
//    for(line <- Source.fromFile(filename).getLines) {
//      if(line.contains("-")){
//        println(line)
//        sum = sum + 1
//      }
//    }
//    println(sum)

    // 2.3.5Gör en top 50 lista på de namn med flest bärare
    val filename = "data/tilltalsnamn_kvinnor.txt"
    val listan = Map
    var lista: Array[String] = Array()

    for(line<- Source.fromFile(filename).getLines) {
      println(lista.mkString)
    }
    }
}
