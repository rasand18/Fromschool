import scala.annotation._


object Uppgift_gcd {

  def imperativ(a : Int, b : Int) : Int = {
    var temp : Int = 0
    var res : Int = 0
    var a_new : Int = a
    var b_new : Int = b
    while(b_new!=0){
      res = a_new%b_new
      a_new = res
      temp = b_new
      b_new = a_new
      a_new = temp
    }
    a_new
  }


  def fact_help_ns(a: Int, b : Int) : Int = {
    if(b == 0 ) a
    else{ fact_help_ns(b,a%b)
    }
  }

  def sum(num : Int) : Int = {
    if(num == 1) 1
    else sum(num-1) + num
  }
@tailrec
  def sum1(num : Int, res : Int) : Int = {
    if (num == 1) res
    else sum1(num - 1, res + num)
  }
  def factorial(n:Int) : Int = if(n<2) 1
  else n * factorial(n-1)

  def main(args: Array[String]): Unit = {
    //println(imperativ(20,15))
    //println((fact_help_ns(48,18)))
    println(sum(99999))
    println(sum1(99999,1))
    //println(factorial(4))

  }
}
