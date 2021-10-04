Studenterna = ["Rasmus Andreasson","Anna Fransson","Pelle Karlsson","Bo Sture","Eldin Sparkad"]

print(Studenterna[2])

print(Studenterna[2][0])

Studenterna[2]="Ole"

print(Studenterna)

Studenterna[2]+=" Nordmann"

print(Studenterna)

Studenterna.append("Pelle Karlsson")
print(Studenterna)

Studenterna.insert(4,"Monty python")
print(Studenterna)

print(len(Studenterna))

Studenterna.remove("Ole Nordmann")
print(Studenterna)

print(Studenterna[3])

print(Studenterna[:3])

student_reverse = Studenterna[::-1]
print(student_reverse)

