my_list=[]
print("""Hi,welcome to the infinite loop!
To end the loop input END or use ctrl+c and to see you current list of names input PRINT!""")
      
while True:
    name=input("""What name would you like to add to your list?:""").upper()
    if name == "PRINT":
        print(my_list)
    elif name == "END":
        print("The loop has been terminated, here are the names in your list: ")
        print(my_list)
        break
    else:
        my_list.append(name)

            
