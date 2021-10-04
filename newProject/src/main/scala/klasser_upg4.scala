import scala.math._
object klasser_upg4 {

  def main(args: Array[String]): Unit = {

    class Point(val x: Double, val y: Double) {
      override def toString(): String = s"Point($x, $y)"
  }
    class Circ(val center : Point, val radius : Double) {
      def area: Double = ((Pi*(radius*radius)))
      override def toString(): String = s"Circ($center,$radius)"
    }
    val circ = new Circ(new Point(0,0),10.0)
    circ.area
    println((circ.area))
  }
}
