object Uppgift_heltalsexponering2 {
  def fact_iter_imp(tal: Double, n: Int): Double = {
    if (n == 0) return 1
    var summa: Double = if (n % 2 == 0) tal * tal; else tal
    var tal2: Double = if (n % 2 == 0) tal * tal; else tal
    val n2: Int = if (n % 2 == 0) n / 2; else n
    for (_ <- 1 until n2) {
      summa *= tal2
    }
    summa
  }

  def rekursivimp(x: Double, n: Int): Double = {
      if (n == 0) 1
      else if (n % 2 == 0) rekursivimp(x * x, n / 2)
      else x * rekursivimp(x, n - 1)
  }

  def fact_help_ns(tal: Double, n: Int, res: Double): Double =
    if (n == 0) res else fact_help_ns(tal, n - 1, res * tal)

  def fact_rek_ns(tal: Double, n: Int): Double = {
    if (n % 2 == 0) fact_help_ns(tal * tal, n / 2, 1)
    else fact_help_ns(tal, n, 1)
  }


  def main(args: Array[String]): Unit = {
    //println(imperativ(10,6))
    println(rekursivimp(5, 5))


  }
}
