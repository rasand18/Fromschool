object Uppgift_2 {
  def main(args: Array[String]): Unit = {


    def isPrimeHelp(siffra: Int, tvåa : Int ): Boolean ={
      if(siffra == 2) true  else isPrimeHelp(siffra,tvåa +1)
    }

    for( i <-2 to 13){
     val is = isPrimeHelp(i,2)
     println(s"$i $is, ")
    }
  }
}
