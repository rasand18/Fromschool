object Checkpoint_uppgift3 {
  def sumprod(arr : Array[Double]) : Tuple2[Double,Double]={
    var pro : Double = 1.0
    var sum : Double = 0.0
    for(i <- arr){
      sum = sum + i
    }
    for(i <- arr){
      pro = pro * i
    }
    (sum,pro)
  }

  def main(args: Array[String]): Unit = {
    val t = sumprod(Array(3.7, 8.2 , 9.5, 1.8))
    println(s"summa = ${t._1}")
    println(s"produkt = ${t._2}")

  }

}
