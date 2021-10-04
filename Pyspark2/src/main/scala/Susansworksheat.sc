val namn = Array("Adam", "Berith", "Caesar", "Daniella")
val tuplerr = Array(("Arne",33), ("Sextus",20), ("Svante",12), ("Ulrika",18))
val b = namn.map(x => x.length())
val d = namn.map(x => (x, x.length))
val e = namn.map(x => (x, namn.count(_==x)))
val f = namn.filter(x => x.length == 6)
val g = tuplerr.filter(x => x._1.startsWith("S"))
val h = tuplerr.reduce((x,y) =>("summa", x._2 + y._2))
val nagot = tuplerr.reduce((x,y) => if (x._2 > y._2) x else y )
tuplerr.maxBy(_._2)





