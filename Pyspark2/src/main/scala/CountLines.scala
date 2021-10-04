import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object CountLines {
    def main(args: Array[String]): Unit = {
        val fileName = "trump-ukraine-scandal.txt"
        Logger.getLogger("org").setLevel(Level.FATAL)
        
        println("------------------------------------------")
        println("Get spark context:")
        val t0 = System.currentTimeMillis()
        val sc = new SparkContext("local[*]", "CountLines")
        val t1 = System.currentTimeMillis()
        println(s"Got the spark context in ${(t1-t0)/1000.0} seconds!")
        
        println("------------------------------------------")
        println("Attach file:")
        val lines = sc.textFile(s"data/$fileName")
        println("Count the number of lines:") // Gör även andra saker!
        val numLines = lines.count()


        
        print(s"The file $fileName has $numLines lines")
    }
}



//val abra = lines.map(x => x.split(" ").length)
//val hok = abra.reduce((x,y)=> (x+y))
//
//val trump = lines.filter(x => x.contains("Trump")).count()
//println(s"$trump")
//
//val zel = lines.filter(x => x.contains("Zelensky")).count()
//println(zel)