
object Checkpoint_upp1 {
  def sqr(x : Int): Int = {
    var i = x*x
    i
  }
  def triangeltal(n : Int) : Int = {
    n*(n+1)/2
  }

  def main(args : Array[String]) : Unit = {
    for(i <- 1 to 7){
      println(s"${i} ${sqr(i)} ${triangeltal(i)}")
    }
    }
}
