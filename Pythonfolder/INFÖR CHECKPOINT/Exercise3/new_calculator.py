    
    
first_number = input("Input first number: ")
second_number = input("Input second number: ")
operator = input("Input type of operator (+,-,*,/): ")

def my_calculator(first_number,second_number,operator):
    try:
        if(operator == "+"):
            return float(first_number) + float(second_number)
        elif(operator == "-"):
            return float(first_number) - float(second_number)
        elif(operator == "*"):
            return float(first_number) * float(second_number)
        elif(operator == "/"):
            return float(first_number) / float(second_number)
        else:
            print(f"{operator} is not a valid operator!")
    except Exception as e:
        return(f"Error code: {e}")

print(my_calculator(first_number,second_number,operator))