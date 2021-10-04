
import scala.collection.parallel.CollectionConverters._


object Uppgift_3 {
  def main(args: Array[String]): Unit = {

    def parUpcase(arr : Array[String]): Unit = {
      val nyarr = arr.par
      for(i <- nyarr ){
        println(i.toUpperCase())
      }
    }

    val UC = parUpcase(Array("Adam","Bertha", "Caesar", "Daniella"))

  }

}
