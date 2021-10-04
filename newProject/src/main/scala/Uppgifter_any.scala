object Uppgifter_any {
  def add(x: Any, y: Any): Any ={
    x match {
      case i: Int => y match {
        case j: Int => s"${i + j}"
        case h: String => s"$i$h"
      }
      case f: String => y match {
        case j: String => s"$f$j"
        case h: Int => s"${f + h}"
      }
    }
  }


  def main(args : Array[String]) : Unit = {
    println(add(2,3))
    println(add("2",3))
    println(add(2,"3"))
    println((add("2","3")))

  }

}
