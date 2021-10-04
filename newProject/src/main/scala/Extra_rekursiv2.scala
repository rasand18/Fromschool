object Extra_rekursiv2 {
  def imperativ(x: Int,n: Int): Int ={
    var sum : Int = 1
    var newn : Int = 0
      if (n%2 == 0 && n!=2){
        sum = x*x
        newn = n/2
        for(i <- 0 until newn) {
          sum = sum * x
        }
        sum
      }
      else if(n%2 != 0 || n == 2){
        for(i<-0 until n){
          sum = sum*x
        }
        sum
      }
      else 1
      }

  def rekursiv(x : Int, n: Int): Int = {
    if (n == 0) 1
    else if (n % 2 == 0) rekursiv(x*x,n/2)
    else x*rekursiv(x,n-1)
  }
  def tail_help(x : Int, n:Int ,res : Int = 1): Int = {
    if(n == 0) res else tail_help(x,n-1,res*x)
  }

  def rekuristail(x : Int, n:Int): Int = {
    if(n%2==0) rekuristail(x*x,n/2) else tail_help(x,n,1)
  }




  def main(args: Array[String]): Unit = {
    //println(imperativ(4,4))
    //println(rekursiv(5,5))
    println(rekuristail(4,4))

  }

}
