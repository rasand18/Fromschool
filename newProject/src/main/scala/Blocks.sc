{
    2
}
val  fyra = {var i = 2; i*i}
//Fyra får värdet fyra. Behöver inte använda return
{
    var i = 5;
    var lk = {
        //println(i) om du tar bort i = 12 så tar den 5, så dem är globala
        var i = 12 //Detta blocket har sina egna variabler (i)
        i * i
    }
    println(lk+i)
}

//Functions

def sqr( n : Double) : Double = n*n
sqr(12)


