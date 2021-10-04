object Checkpoints_igen_1 {

  def main(args: Array[String]): Unit = {
    for(i<-0 to 7){
      println(s"${i} ${i*i} ${(i*(i+1))/2}")
    }
    val A = Array(2,3,5,7,11)
    val arr = A.map(x => x * x)
    println(arr.mkString(", "))

    val t = Array(3.7, 8.2, 9.5, 1.8)
    val sum = t.reduce((x,y)=> x + y)
    val prod = t.reduce((x,y)=> x*y)
    println(s"Summan är ${sum} och produkten är ${prod}")
  }
}


