//1
def accum(x : Int) : Int = x*x+x
accum _
val b : Int => Int = ((x) => x*x+1)
accum(2)
b(2)

//2
import scala.math._

def sqrdist(x : Double, y : Double) : Double = sqrt(x*x+y*y)
val b = (x:Double,y:Double) => sqrt(x*x+y*y)
b(1,2)

//3

def grandSum(x: Array[Double], y : Double => Double): Double ={
  var sum: Double= 0
  for(i <- 0 until x.length ){
    sum = sum + y(x(i))
  }
  sum
}
println(grandSum(Array(1,2,3.5), (x:Double) => (x*x)))
println(grandSum(Array(0,2,4.1,6), (x:Double) => (x-1)))

//4


println(Array(1.5, 2.3, 8.3, 5).map(x=>x*x).mkString(","))
//Array(1.5, 2.3, 8.3, 5).reduce(lambdauttrycket)

//5

def isprime(n : Int) : Boolean ={
  if(n > 1){
    var i = 2
    while (i <= (n/2)){
      if(n % i == 0) return false
      i = i+1
    }
    true
  }
  else false
}
(1 to 20).toArray.filter(isprime)



