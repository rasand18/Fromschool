import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.ParSeq
import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.immutable.ParVector
import
object checkpoint_igen_2 {
  def main(args: Array[String]): Unit = {
    val A = Array((1, 2), (2, 3), (3, 5), (4, 7), (5, 11))
    val a = A.map(x => x._1 + x._2)
    println(a.mkString(", "))

    def isPrimeHelp(n: Long, i: Long): Boolean =
    // Lösningsförslag
      if (i == n) true
      else if (n % i == 0) false
      else isPrimeHelp(n, i + 1)

    // Givet i uppgiften
      for (i <- 2 to 13) {
        val is = isPrimeHelp(i, 2)
        print(s"$i $is, ")

      }
    def parupcase(arr : Array[String]):
    }
}