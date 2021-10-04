class Point(val x : Double, val y : Double){
  override def toString() : String = s"Point($x, $y)"
}
class Circ(val center : Point, val radius :Double) {
  println("Början av Circ")
  override def toString() : String = s"Circ($center, $radius)"
  var color : (Int,Int,Int) = (0,0,0)
  println(color)
  println("Slutet av Circ")
}

val circ : Circ = new Circ(new Point(0,0), 10.0)

object A {
  def main( args : Array[String]) : Unit = {
    println(("Hello world"))
  }
}
A.main(Array())