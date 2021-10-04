object Klasser_upg2 {

  def main(args: Array[String]): Unit = {

    class Latlon(lat : Double, long: Double){
      override def toString(): String = s"Latlon:<$lat, $long>"
    }

    class city(name : String, latlon: Latlon) {
      override def toString(): String = s" City:<$name,$latlon>"
    }

    val L1 = new Latlon(59.3293,-18.0686)
    val sthlm = new city("Stockholm",L1)
    println(sthlm)

  }
}
