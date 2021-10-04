def my_calculator(f_number,operator,s_number):
    suM = 0
    if operator == "/" and s_number==0:
        print("You cant devide by 0")
    else:   
        if operator == "*":
            suM = f_number*s_number
            print(suM)
        elif operator == "/":
            suM = f_number/s_number
            print(suM)
        elif operator == "-":
            suM = f_number-s_number
            print(suM)
        elif operator == "+":
            suM = f_number+s_number
            print(suM)
        else:
            print("You have entered a non numeric number or chosen an operator that dosent exist")

f_number = int(input("Enter a number: "))
operator = input("Which operator would you like to use *, / , - or + ?: ")
s_number = int(input("Now enter your second number: "))
my_calculator(f_number,operator,s_number)
