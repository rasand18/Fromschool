import scala.util.Sorting.quickSort
import scala.util.Random

object Uppgifter_arrayer {
  def functi(prime : Array[Double]) : Double = {
    var sum : Double = 0
    for(i <- prime){
      sum = sum + i
    }
    sum
  }
  def ackluf(prime : Array[Double]) : Array[Double] = {
    var ack = prime.clone()
    for( i <- prime.indices){
      ack(i) = 0
      for(x <- 0 to i ){
        ack(i) += prime(x)
      }
    }
   ack
  }

  def sortedarr(arr : Array[Double]) : Array[Double] = {
    scala.util.Sorting.quickSort(arr)
    arr
  }

  def tarning() : Int = {
    var sum = 0
    sum = Random.nextInt(6)
    sum
  }
  def tarning3() : Int = {
    var sum = 0
    for(i <- 0 to 3){
      var varde = Random.nextInt(6)
      sum = sum + varde
    }
    sum
  }

  def tarningS() : Array[Int] = {
    var prime  = new Array[Int](18)
    var sum = 0
    for(i <- 0 to 999) {
      for (k <- 0 to 2) {
        var varde = Random.between(1,7)
        sum = sum + varde
      }
      prime(sum-1) += 1
      sum = 0
    }
    prime
    }




  def main(args : Array[String]) : Unit = {
    //var prime  = Array(1.23,32.2,5.25)
    //println(functi(prime))
   //println(ackluf(Array(10.5,8,12)).mkString(","))
    //println(sortedarr(Array(10,5,8,12)).mkString(","))
    //println(tarning())
    //println(tarning3())
    println(tarningS().mkString(","))
  }

}
