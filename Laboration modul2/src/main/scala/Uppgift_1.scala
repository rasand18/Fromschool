object Uppgift_1 {
  def main(args: Array[String]): Unit = {
    val A = Array((1,2), (2,3), (3,5), (4,7), (5,11))
    val B = A.map(x => x._1 + x._2)
    println(B.mkString(", "))

  }
}
