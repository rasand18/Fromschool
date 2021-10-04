import scala.math._

object Uppgifter_if_sats_loopar {
  def caesar(n: String): String = {
    val alfabet = "abcdefghijklmnopqrstuvwxyzåäö"
    var text = ""
    for (x <- n) {
      if (alfabet contains(x)) {
        if (alfabet.indexOf(x) + 1 >= alfabet.length) {
          var num = 1 - (alfabet.length - alfabet.indexOf(x))
          text += alfabet(num)
        }
        else text += alfabet(alfabet.indexOf(x) + 1)
      }
      else {
        text += x
      }
    }
    text
  }


  //mfb, kbdub ftu
  def isPalindrome(word: String) : Boolean = {
    var f = ""
    for(i <- word.reverse){
      f+=i
    }
    if(f == word){
      true
    }
    else{
      false
    }
  }

  def dubbelp( t : Double) : String = {
    var hours = t.toInt
    var minutes = ((t*60) %60).toInt
    var sekunds = ((t*3600) % 60).toInt

    s"${hours}:${minutes}:${sekunds}"

  }

  def isPrime(num:Int):Boolean =
    (num > 1) && !(2 to scala.math.sqrt(num).toInt).exists(x =>num % x == 0)

  def factul(n: Long) : Long = {
    var f: Long = 1
    for(i <- 1 to n.toInt)
    {
      f = f * i
    }
    f
  }


  def year(m : Int, d : Int ): Int = {
    val nums: List[Int] = List(31,28,31,30,31,30,31,31,30,31,30,31)
    if(m == 1){
      0+d
    }
    else if(m == 2){
      nums(0)+d
    }
    else if(m == 3){
      nums(0)+nums(1)+d
    }
    else if(m == 4){
      nums(0)+nums(1)+nums(2)+d
    }
    else if(m == 5){
      nums(0)+nums(1)+nums(2)+nums(3)+d
    }
    else {
      nums(0)+nums(1)+nums(2)+nums(3)+nums(4)+d
    }
  }

  def signum(n : Int) : Int ={
    if(n>0){
      1
    }
    else if(n==0){
      0
    }
    else{
      -1
    }
  }


  def vdfunc(n : Int) : String = {
    if(n > -1 && n < 7) {
      if(n == 0){
       "it's sunday"
     }
      else if(n == 1){
       "it's Monday"
     }
      else if(n == 2){
       "it's Thuesday"
     }
      else if(n == 3){
        "it's Wednesday"
      }
      else if( n == 4) {
        "it's Thursday"
      }
      else if(n == 5){
        "it's friday"
      }
      else if(n == 6){
        "It's Saturday"
      }
      else{
        "Nu blev det konstigt"
      }
    }
    else{
      "wrong number"
    }
    }


  def main(args : Array[String]) : Unit = {
    //println(vdfunc(0))
    //println(signum(0))
    //println(year(5,8))
     println(factul(5))
    //println(isPrime(2))
    //println(dubbelp(13.343745))
    //println(isPalindrome("anna"))
    //println(caesar("alea, jactaz est"))


  }

}
