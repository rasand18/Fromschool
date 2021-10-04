import json

min_dict = {}
revert_dict={}
while True:    
        user_input = input("Skriv ett ord som innefattar en key och ett value och separera dem genom att ha ett ';' mellan dem")
        user_input = user_input.split(';')

        if len(user_input) == 2:
            if user_input[0] not in min_dict:    
                min_dict[user_input[0]]=user_input[1]
                print(min_dict)

        elif user_input[0] == 'revert':
            for key,value in min_dict.items():
                revert_dict[value]=key
            print(revert_dict) 

        elif user_input[0]== 'save':
            with open ('ny_text.txt','w')as f:
                data = str(min_dict)
                f.write(data)
                f.close()
        
        elif user_input[0]=='load':
            with open("ny_text.txt","r") as f:
                min_dict = eval(f.read())
                f.close()
            
            
        
