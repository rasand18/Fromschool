object numArgs {
  def main(args : Array[String]) : Unit = {
    println(args.length)
    if(args.length == 0) {
      println("too few arguments")
    }
    else if(args.length == 1) {
      println("Ett är mer än noll")
    }
    else {
      for(a<-args)
      println()
    }
  }
}
