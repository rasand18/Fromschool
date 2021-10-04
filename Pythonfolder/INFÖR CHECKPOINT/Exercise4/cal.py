
f_numb = input("Välj ett nummer: ")
s_numb = input("Välj nu ännu ett nummer: ")
operator = input("Välj operator +,-,* or /: ")
special_tecken ="+-/*"
if(s_numb.isnumeric() and f_numb.isnumeric) and operator in special_tecken:
    if(s_numb == "0" and operator == "/"):
        print("Ge fan i att dela med 0")
    else:
        if operator == "*":
            suM = int(f_numb)*int(s_numb)
            print(suM)
        elif operator == "/":
            suM = float(f_numb)/float(s_numb)
            print(suM)
        elif operator == "-":
            suM = int(f_numb)-int(s_numb)
            print(suM)
        else:
            suM = int(f_numb)+int(s_numb)
            print(suM)       
else:
    print("Nu har du fan ställt till det")
    
    
        