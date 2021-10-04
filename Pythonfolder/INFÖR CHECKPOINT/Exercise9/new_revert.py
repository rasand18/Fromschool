from collections import defaultdict

min_dict =defaultdict(list)
revert_dict = defaultdict(list)
print(min_dict)

while True:
    user_input = input("key;value: ")
    user_input = user_input.split(";")
    
    if len(user_input)==2:
        min_dict[user_input[0]].append(user_input[1])
        print(min_dict)
    elif user_input[0] =='revert':
         for key,value in min_dict.items():
            revert_dict[str(value)].append(key)
            print(revert_dict) 

        




