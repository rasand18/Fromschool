#Coding Challenge 2 – Format text

s=input("What would like too format?: ").strip()
print(s)

sentence = s.split() #split into list 

newlist=[]

for word in sentence:
    if word.endswith("#") and word.startswith("#"):
        new = word.lower()
        new = new[1:-1]
        newlist.append(new)
        
    elif word.endswith("_") and word.startswith("_"):
        new = word.upper()
        new = new[1:-1]
        newlist.append(new)
    else:
        newlist.append(word)
        
output=" ".join(newlist)

print()
print("==== Formatted result =====")
print(output)     
        
        
#Expected output:       
#Everyone _said_ that it would not work. Then someone came, #UNAWARE# of what everyone said, and just did it becomes this string:
#"Everyone SAID that it would not work. Then someone came, unaware of what everyone said, and just did it.”
