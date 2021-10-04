object klasser_upg5 {

  def main(args: Array[String]): Unit = {

    class Point(val n1: Double, val n2: Double){
      override  def toString() : String = s"<$n1,$n2>"
    }
    class Triang(val p1 : Point, val p2: Point, val p3 : Point){
      def area: Double = ((p3.n1 - p1.n1) * (p2.n2-p1.n1))/2
      override def toString() : String = s"Triangel: $p1, $p2, $p3"
    }
    val tri = new Triang(new Point(0,0),new Point(2.0,2.0),new Point(4.0,0.0))
    println(tri)
    println(tri.area)


  }

}
