my_dictionary={}

print("You can always choose to terminate the program by typing end as input or using ctrl+c")
while True:
    
    string=input("Enter a car brand and what color you would like the car to be: ").upper()

    # Split user input by space
    string_array=string.split(' ')

    # End program on END
    if string=="END":
        print("Here is your dictionary: ")
        print(my_dictionary)
        break
    
    # Check for two words
    elif len(string_array)!=2:
        print("You need to enter at least two words, try again")
        
    # Combine previous values with old list order by key
    elif len(string_array)==2:

        # Store values
        key=string_array[0].capitalize()
        car_color=string_array[1].lower()
        
        # Check if key is in dict
        if key in my_dictionary:
            # Store previous values
            my_dictionary[key].append(car_color)
            print(my_dictionary)
        else:
            list_of_colors=[car_color]
            my_dictionary[key] = list_of_colors
            print(my_dictionary)
                                                
        # Expected result
        # {
        #     'Hello': 'you', 'me', 
        #     'Hi': ['you']
        # }
