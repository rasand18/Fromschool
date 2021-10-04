def fizz_buzz(num):
    word = ""
    if num%3 == 0 and num%5==0:
        return "Fizzbuzz"
    elif num%3 == 0:
        word += "Fizz"
    elif num%5 == 0:
        word+= "Buzz"
    else:
        return num
    return word
    

print(fizz_buzz(2))
