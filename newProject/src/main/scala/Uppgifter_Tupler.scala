import scala.math._
object Uppgifter_Tupler {
  def sincos(x : Double) : Tuple2[Double,Double] ={
    var sinx = sin(x)
    var cosx = cos(x)
    var tup = (sinx,cosx)
    tup
  }
  def translate(s: Array[String]) : Array[String] = {
    var translate = Map("hej" -> "Hi","hopp"->"jump","i" -> "In","skogen"->"the forest")
    var newarray = s.clone()
    for(i <- 0 to s.length -1) {
      newarray(i) = translate(s(i))
    }
    newarray
  }




  def main(args : Array[String]) : Unit = {
    //var (sinx,cosx) = sincos(Pi/3)
    var T = sincos(Pi/3)
    //println(T._1)
    //println(T._2)
    println(translate(Array("hej","hopp","i","skogen")).mkString(","))

  }

}
