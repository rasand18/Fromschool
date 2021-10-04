#Ask user for name

name = input("What is your name?: ")


#Ask user for age

age = input("What is your age?: ")
 

#Ask user for city

city = input("What city do you live in?: ")


#Ask user what they enjoy

love = input("What do you love?: ")

#Create output text

string = "Your name is {} and you are {} years old. You live in {} and you love {}"
output = string.format(name,age,city,love)

#Print output to screen
print(output)

What is your name?: Rasmus
What is your age?: 27
What city do you live in?: Halmstad
What do you love?: Food
Your name is Rasmus and you are 27 years old. You live in Halmstad and you love Food
>>> .lower(), .upper(), .title(),.capitalize,
SyntaxError: invalid syntax
>>> .islower(),.isupper()
SyntaxError: invalid syntax
>>> .count("a")
SyntaxError: invalid syntax
>>> .isalpha(),.isdigit(),.isalnum()
SyntaxError: invalid syntax
>>> x = "happy birthday"
>>> x.index(birthday)
Traceback (most recent call last):
  File "<pyshell#5>", line 1, in <module>
    x.index(birthday)
NameError: name 'birthday' is not defined
>>> x.index("birthday")
6
>>> y = "00000000happybirthday"
>>> y.strip("0")
'happybirthday'
>>> y.lstrip("0")
'happybirthday'
>>> y.rstrip("happybirthday")
'00000000'
>>> 
