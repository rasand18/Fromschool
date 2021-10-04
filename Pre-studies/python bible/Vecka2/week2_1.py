

city=""
user_input=""
wait_for_correct_input=True

while True:

    # Wait for user input two words.
    while len(user_input.split(" "))!=2:
        print("The name needs to contain at least two words")
        user_input = input("First and last name?: ").strip().capitalize()

    # Then ask for were the user was born.
    else:
        year = int(input("What year were you born?: "))
        print(year)

        while wait_for_correct_input:    
            city = input("What city do you live in, Norway or US ?: ").upper()

            # Make sure they write Norway or US to continue.
            if ((city=="NORWAY") or (city=="US")):
                wait_for_correct_input=False

        # Check if they are legal to drink
        if((year>2000 and city=="US") or (year>2003 and city=="NORWAY")):
            print("The person is not legal to drink")
            break;
        else:
            print("The person is legal to drink")
            break;
        
