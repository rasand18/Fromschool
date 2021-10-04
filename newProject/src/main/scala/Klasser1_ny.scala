import scala.math._

object Klasser1_ny {

  def main(args: Array[String]): Unit = {

    class Pixel(X: Int, Y: Int) {
      override def toString(): String = s"<$X,$Y>"

      val area: Double = X * Y
    }
    val p1 = new Pixel(10, 10)
    //println(p1.area)


    class Latlon(X: Double, Y: Double) {
      override def toString: String = s"$X,$Y"
    }
    class city(c: String, latlon: Latlon) {
      override def toString: String = s"$c,$latlon"
    }
    /*
    val L1 = new Latlon(59.3293, -18.0686)
    pr  intln(L1)
    val sthlm = new city("Stockholm",L1)
    println(sthlm)
     */
    class Point(val n1: Int, val n2: Int) {
      override def toString: String = s"$n1,$n2"
    }
    class rect(p1: Point, p2: Point, rot: Double) {
      val area = (p2.n1 - p1.n1) * (p2.n2 - p1.n2)

      override def toString: String = s"(<$p1>,<$p2>,<$rot>)"
    }
    val Rect = new rect(new Point(1, 0), new Point(2, 1), 13.2)
    //println(Rect)
    //println(Rect.area)

    class circ(pn: Point, rad: Double){
      val area = Pi*(rad*rad)
      override def toString: String = s"center:$pn, $rad"
    }
    val circel = new circ(new Point(0,0),rad = 10)
    //println(circel)
    //println(circel.area)

    class tri(pn1: Point,pn2: Point,pn3: Point){
      val area = ((pn3.n1 - pn1.n1) * (pn2.n2-pn1.n2))/2

      override def toString: String = s" pn1: $pn1 pn2: $pn2 pn3: $pn3 "
    }
    val triang = new tri(new Point(0,0),new Point(2,2), new Point(4,0))
    //println(triang)
    //println(triang.area)

    val trig = Array(Rect,circel,triang)

    for(i <- trig){
      i match {
        case r:rect => {
          println(r.toString)
          println(r.area)
        }
        case c:circ => {
          println(c.toString)
          println(c.area)
        }
        case t:tri => {
          println(t.toString)
          println(t.area)
        }
      }
    }

  }

}
