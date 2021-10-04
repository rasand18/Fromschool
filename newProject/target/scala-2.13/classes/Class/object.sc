//klass
class City(name : String, lat : Double, long : Double){
  var invantal : Int = 0;
  var areaKm2 : Double = 0.0;
  def numInnhabPerKm2 = invantal/areaKm2
}

//objekt
val lkpg = new City(name = "linköping", lat = 58.36, long = -15.37)
lkpg.invantal = 150000
lkpg.areaKm2 = 42.16
lkpg.numInnhabPerKm2



