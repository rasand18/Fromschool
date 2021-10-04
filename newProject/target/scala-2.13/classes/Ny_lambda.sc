import scala.math._
def accum(x : Int) : Int = x*x+x
accum _

val b: Int => Int = ((x) => x*x+x)
b _
b(3)

//2

val sqrta = (x:Double,y:Double) => sqrt(x*x+y*y)
sqrta _

//3
def grandsum(arr : Array[Double], x: Double => Double) : Double = {
  var sum : Double = 0
  for(i<- 0 until(arr.length)){
    sum += x(arr(i))
  }
  sum
}

grandsum(Array(1,2,3.5), (x:Double) => (x*x))
grandsum(Array(0,2,4.1,6), (x:Double) => (x-1))

//4

val b = Array(1.5, 2.3, 8.3, 5).map(x => x*x)
println(b)
val y = Array(1.5, 2.3, 8.3, 5).reduce((x,y) => x*y)
println(y)

// 5




def zuul1(x: Int) : Int = 2*x
val zuul2 : Int => Int = x => 2*x
(x : Int) => x*2 : Int
((x : Int) => x*2 : Int)(2)
val I = Array(1,2,3,4)
I.map(x=> 2*x)
I.map(zuul1(2))




