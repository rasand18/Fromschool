object Uppgift_heltalsexponering {
  def imperativ(x : Double, n : Int): Double = {
    var product :Double = x
    for(i <- 1 until n){
      product *= x
    }
    product
  }
  def rekursivimp(x : Double,  n : Int): Double = {
    if(n==0) 1 else x*rekursivimp(x,n-1)
  }

  def recursive_help(x : Double,n : Int, res : Double) : Double = {
    if(n==0) res else recursive_help(x,n-1,x*res)
  }

  def recursive_ns(x : Double, n: Int): Double = {
    recursive_help(x,n,res = 1)
  }


  def main(args: Array[String]): Unit = {
    println(imperativ(5,5))
    println(rekursivimp(5,5))
    println((recursive_ns(5,5)))

  }

}
