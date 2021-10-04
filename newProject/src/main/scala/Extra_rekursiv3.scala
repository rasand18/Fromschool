object Extra_rekursiv3 {
  def imperativ(x : Int): Int = {
    var sum : Int = 1
    var newsum : Int = 0
    if(x == 0) 0 else if(x == 1) 1 else {
      for (i <- 1 until x) {
        sum = newsum + sum
        newsum = sum - newsum
      }
      sum
    }
  }

  def rekursiv(x: Int,sum: Int = 0,newsum: Int = 1): Int = {
    if(x == 0) 0
    else if(x == 1) 1
    else sum + rekursiv(x-1,newsum,sum + newsum)
  }

  def tail_rekursiv(x: Int, sum: Int, newsum: Int): Int = {
    if(x == 0) sum else tail_rekursiv(x-1,newsum,sum+newsum)
  }
  def tail_rekurv(x : Int, sum: Int = 0, newsum: Int = 1): Int = {
    if(x == 0) 0
    else if(x == 1) 1
    else tail_rekursiv(x  ,sum,newsum)
  }
  def main(args: Array[String]): Unit = {
    //println(imperativ(3))
    //println(rekursiv(4))
    println(tail_rekurv(8))

  }


}

//import scala.collection.parallel.ParSeq
//object Uppg3 {
//def main(args: Array[String]): Unit = {
//  def parUpcase(a:Array[String]): ParSeq[String] = {
//    val namePar : ParSeq[String] = a.par
//    namePar.map(_.toUpperCase)
//  }
//  val UC = parUpcase(Array("Adam", "Bertha", "Caesar", "Daniella"))
//  for(u<-UC)
//    println(u)
//  }
//}
