object Extra_rekursiv{
  def imperativ( x : Int, n: Int): Int = {
    var sum : Int = 1
    for(i <- 1 to n){
      sum = sum * x
    }
    sum
  }
  def rekursiv(x : Int, n: Int, res : Int = 1): Int={
    if(n == 0){
      res
    }
    else{
      rekursiv(x, n-1, x*res)
    }
  }
  def rekursivspar( x: Int, n : Int): Int = {
    if(n == 0) {
      1
    } else {
      x * rekursivspar(x,n - 1)
    }
  }
  //4(4(4(4*1)

def main(args: Array[String]): Unit = {
  //println(imperativ(3,3))
  //println(rekursiv(5,5))
  println(rekursivspar(4,3))
}
}
