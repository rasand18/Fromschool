students = ["Calle Johansson","Pelle Karlsson","Falle Balle","Colle jafan","Balle Kalle"]

print(students[2])

print(students[2][0])

students[2] = "Ole"

students[2]+= " Nordmann"

students.append("balle johnsson")

students.insert(3,"mony")

print(len(students))
students.remove("Ole Nordmann")
print(len(students))

print(students.index("mony"))

print(students[:3])

students_reverse = students[::-1]
print(students_reverse)

students_even = students[::2]
print(students_even)

students_odd = students[1::2]
print(students_odd)

