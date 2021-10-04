punishment_text = "I will not teach others to fly"
number_of_repetitions = 9

mycounter=(punishment_text.replace("not",'') +"\n")*number_of_repetitions
myword = "will"
print(f"The occurrence of the word 'will' in the original sentence is: {(mycounter).count(myword)}")



