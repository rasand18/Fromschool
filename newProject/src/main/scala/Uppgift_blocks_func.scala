import scala.math._

object Uppgift_blocks_func {
  def grandtrunc(n : Int) : Int = {
    if(n > 360) {
      n - 360
    }
    else if(n < 0) {
      360 + n
    }
    else{
      n
    }
  }

  def cot(n : Double) : Double = {
   1/tan(n)
  }

  def triangeltal(n : Int) : Int = {
    n*(n+1)/2
  }

  def dechour( h : Int, m : Int, s : Double) : Double = {
    h+m/60.0+s/(60*60)
  }

  def frac( x : Double) :Double = {
    x-x.toInt
  }

  def main(args : Array[String]) : Unit = {
    //println(frac(.141592653589793))
    //println(dechour(13,26,12.45))
    //println(triangeltal(4))
    //println(cot(0.5))
    println(grandtrunc(359))
  }

}
