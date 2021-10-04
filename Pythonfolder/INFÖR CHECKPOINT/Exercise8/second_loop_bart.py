def bart_cheat_code(punishment_text,number_of_repetitions=5):
    counter = 0
    myword=0
    for i  in range(number_of_repetitions):
        mycounter=(punishment_text +"\n")
        counter = counter+1
        print(mycounter)
        if "will" in mycounter:
            myword=myword+1

    return print(f"The occurrence of the word 'will' in the original sentence is: {(myword)}")

punishment_text = "I will not teach others to fly"
number_of_repetitions = 9
calle = bart_cheat_code(punishment_text)