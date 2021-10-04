
#Create a class called MyCounter (as it is costumery to capitalize class names in Python).
#Make a constructor that takes in one argument for the values to count (apart from “self” of course).
#Create the counter and save it to a field.
#Create a method called get that takes in a key and returns the count for that key.
#Make it such that the method prints a message if the key is not found in the counter dictionary. It is important that you do not throw an error here!
#Define the __str__ method to pretty print the counter dictionary.



class Mycounter:
    
    def __init__(self,myinput):
        
        self.myinput=myinput
        self.mydict = {}
        
        for i in myinput:
            self.mydict[i]= self.mydict.get(i,0)+1
        print("Dictionary created: ")

    def get(self,key):
        self.key=key
        if self.key in self.mydict.keys():
             self.key=self.mydict[self.key]
             print(p)
        else:
             print("This key dosent exist in this dicitionary")
    def __str__(self):
        return 'This is the dictionary {self.mydict} and the value for the key that have you entered is:{self.key}'.format(self=self)

p=input("Type what you would like to put into your dictionary: ")
p=Mycounter(p)
k=input("What key would you like too investigate`?: ")
k=p.get(k)





        
        
