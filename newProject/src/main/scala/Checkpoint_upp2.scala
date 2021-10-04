object Checkpoint_upp2 {
  def squares(arr: Array[Int]): Array[Int] = {
    var x = 0
    var newarray = arr.clone()
    for( i <- 0 until arr.length ){
      x = 0
      x = arr(i)*arr(i)
      newarray(i) = x
    }
    newarray
  }


  def main(args: Array[String]): Unit = {
    val A = Array(2, 3, 5, 7, 11)
    println(squares(A).mkString(", "))
  }
}
