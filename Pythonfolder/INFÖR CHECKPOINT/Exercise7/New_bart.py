def bart_cheat_code(punishment_text,number_of_repetitions=10):

    mycounter=(punishment_text +"\n")*number_of_repetitions
    myword = "will"
    return print(f"The occurrence of the word 'will' in the original sentence is: {(mycounter).count(myword)}")

punishment_text = "I will not teach others to fly"
number_of_repetitions = 9
calle = bart_cheat_code(punishment_text)