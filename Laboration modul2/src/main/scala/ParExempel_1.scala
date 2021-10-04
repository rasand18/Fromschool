import scala.collection.parallel.CollectionConverters._

object ParExempel_1 {
  def main(args: Array[String]): Unit = {
    val list = (1 to 1000).toList.par
    println(list)
    var sum = 0
    //println(list)
    /*
    for(i<-1 to 10){
      var zuul = list.foreach(sum += _ )
      println(s"$sum")
      sum = 0
    }
     */
//    for(i<-1 to 10){
//      var zuul = list.reduce(sum _ + _ )
//      println(s"$zuul")
//    }
    val lastNames = List("smith","Jones", "Frank", "Bach","jackson", "Rodin").par
    val upper = lastNames.map(_.toUpperCase())
    for(name <- upper) {
      println(name)
    }
  }

}
