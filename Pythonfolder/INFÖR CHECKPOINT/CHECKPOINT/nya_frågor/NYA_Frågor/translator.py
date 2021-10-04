def blaafjell_storm_translater(sentence):
    sentence = sentence.split()
    newword = ""
    for i in sentence:
        new_sentence = sentence[::-1]
    
    for i in new_sentence:
         newword += i +" "

    print(newword)

blaafjell_storm_translater("world hello")

