import scala.math._
object calc {
  def main(args : Array[String]) : Unit = {
    if(args.length == 3 && args(0) == "pow") {
      println(pow(args(1).toDouble,args(2).toDouble))
    }
    else if(args.length == 2){
      if(args(0) == "sqrt") {
        println(sqrt(args(1).toDouble))
      }
      else if(args(0) == "cos") {
        println(cos(args(1).toDouble))
      }
      else if(args(0) == "sin") {
        println(sin(args(1).toDouble))
      }
      else{
        println("Nu har du allt strulat till det!")
      }
    }
  }
}
