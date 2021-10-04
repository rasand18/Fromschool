import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object CountNames {
    def splitLine(line : String) : (String, Int) = {
        val word = line.split(",")
        if(word(0) == "name")
            ("name", 0)
        else
            (word(0), word(1).toInt)
    }
    def main(args: Array[String]): Unit = {
        val maleNames = "tilltalsnamn-man.txt"
        val femaleNames = "tilltalsnamn-kvinnor.txt"
        
        Logger.getLogger("org").setLevel(Level.FATAL)
        
        println("------------------------------------------")
        println("Get spark context:")
        val t0 = System.currentTimeMillis()
        val sc = new SparkContext("local[*]", "HelloWorld")
        val t1 = System.currentTimeMillis()
        println(s"Got the spark context in ${(t1 - t0) / 1000.0} seconds!")
        
        println("------------------------------------------")
        println("Attach file:")
        val lines = sc.textFile(s"data/$femaleNames")
        val qwomen = lines.map(splitLine)
            .filter(s => s._1(0) == 'Q')
            .filter(s => s._2 > 40)
        val qnum = qwomen.count()
        //println(s"$qnum women personal names found starting with 'Q' and having a frequency > 40")
//        for(qw <- qwomen)
//           println(s"${qw._1} ~ ${qw._2}")

        //1
        val qwomens = lines.filter(_.startsWith("Q")).count()
        println(s"$qwomens")

        val powmens = lines.filter(_.contains("Päivi")).count()
        println(powmens)

        val dubble = lines.map(splitLine).filter(x => x._1.contains("-")).count()
        println(dubble)

        val mellanslag = lines.map(splitLine).filter(x => x._1.contains(" ")).count()
        println(mellanslag)

        val vanligaste = lines.map(splitLine).reduce((x,y) => if (x._2>y._2) x else y)
        println(vanligaste)

        val sallsynta = lines.map(splitLine).filter(x => x._2 == 1)
        println(sallsynta)



        sc.stop()
        val t2 = System.currentTimeMillis()
        println(s"Accomplished all the stuff in ${(t2 - t0) / 1000.0} seconds!")
    }
}
