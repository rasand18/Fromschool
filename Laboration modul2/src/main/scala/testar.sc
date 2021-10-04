import scala.collection.parallel.CollectionConverters._
import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel.CollectionConverters._
val list = (1 to 1000).toList.par

val icecreamParVector = ParVector[Double](1.5,2.0,2.5)
val icecreampricesum = icecreamParVector.fold(0.0)(_+_)
println(s"Elements of icecream parVector = $icecreampricesum")





val UC = (Array("Adam","Bertha", "Caesar", "Daniella"))
val nyarr = UC.par

