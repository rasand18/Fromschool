object Klasser_upg3 {
  def main(args: Array[String]): Unit = {

    class Point(val n1: Double, val n2: Double){
      override  def toString() : String = s"<$n1,$n2>"
    }
    class Rect(p1: Point, p2: Point, num: Double){
      def area: Double = (p1.n1 - p2.n1) * (p1.n2-p2.n2)
      override def toString() : String = s"Rect: $p1, $p2, $num"
    }
    val rect = new Rect(new Point(1,0), new Point(2,1), 13.2)
    println(rect)
    println(rect.area)

  }

}
