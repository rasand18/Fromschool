val A = Array("Adam", "Berith", "Caesar", "Daniella")
val b = A.map(x=> x.length())
val c = A.map(x => (x,x.length))
val d = A.map(x => (x,A.count(_==x)))
val e = A.filter(x => x.length()==6)
val f = Array(("Arne",33), ("Sextus",20), ("Svante",12), ("Ulrika",18))
val g = f.filter(x => x._1(0) == 'S')
val h = f.reduce((x,y) => ("Summa",x._2+y._2))
val i = f.reduce((x,y) => if (x._2 > y._2) x else y)
val i = f.reduce((x,y) => if (x._2 > y._2) y else x)





