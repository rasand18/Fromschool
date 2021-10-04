object Uppgift_string_stringb {


  def stringb() : String = {

    var s = new StringBuilder("Hej hopp i skogen")
    var text = ""
    for (i <- s.length() - 1 to 0 by -1) {
      text += s(i)
    }
    text
  }
  def stringa(s : Array[String], sepr : String): String = {
    var text = sepr
    for(i <- 0 until s.length) {
    text += s(i)+ " "
    }
    text
  }
  def stringmk(s: Array[String], sepr: String) : String ={
    println(s.mkString(sepr))
    "hej"
  }

  def main(args : Array[String]) : Unit = {
    //println(stringb())
    //println(stringa(Array("hej","hopp","i","skogen"), sepr=" "))
    println(stringmk(Array("hej","hopp","i","skogen"), sepr=" "))
  }
}
