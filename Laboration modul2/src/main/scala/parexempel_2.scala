import scala.collection.parallel.ParSeq
import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.immutable.ParVector

object parexempel_2 {
  def main(args: Array[String]): Unit = {
    val icecream = Seq("vanilj","jordgubb","choklad","Päron")
    println(s"Elements for icecream immutable sequence = $icecream")

    val icecreampar : ParSeq[String] = icecream.par
    println(s"Elements of icecream parealel = $icecreampar")

    val icecreamParVector = ParVector[Double](1.5,2.0,2.5)
    println(s"Elements of icecream parVector = $icecreamParVector")

    val icecreampricesum = icecreamParVector.fold(0.0)(_+_)
    println(s"Elements of icecream parVector = $icecreampricesum")

    val vs = Vector.range(0,10)
    vs.foreach(print)
    println(" ")
    vs.par.foreach(print)
    println(" ")
    vs.par.foreach{e => print(e); Thread.sleep(50)}

    println("\nSummering : " + vs.sum)
    println("\nSummering : " + vs.min)
    println("\nSummering : " + vs.max)
    println("\nSummering : " + vs.filter(e => e < 5 ))
    println("\nSummering : " + vs.last)
    val list = (1 to 1000).toList.par
    for(i <- 1 to 10) {
      println(s"Subtraktion av listan: ${list.reduce(_ + _)}")
      //Associativ: Addition 4 +3 =7; 3+4 = 7
      // Icke-Associativ Subraktion 4-3 = 1 ; 3-4 =-1
    }

    val strings = List("abc","def","ghi","jk","lmnop","qrs","tuv","wx","yz").par
    val aplhabet = strings.reduce(_++_)
    println(s"Sammanslagning av strängar parallellt: $aplhabet")
  }

}
