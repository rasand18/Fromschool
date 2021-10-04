
#Coding Challenge 3 – Re-creating the ‘Counter’ functionality

def my_counter(my_input):
    my_dict = {}

    for i in my_input:
        my_dict[i]=my_dict.get(i,0)+1
    return my_dict

print(my_counter("hello"))
print(my_counter("lallala"))
print(my_counter([1,2,1,3]))

#Expected results
#my_counter(“hello”) returns a dict: {‘h’: 1, ‘e’: 1, ‘l’: 2, ‘o’: 1}
#my_counter(“lallala”) returns a dict: {‘l’: 4, ‘a’: 3}
#my_counter([1, 2, 1, 3]) returns a dict: {1: 2, 2: 1, 3: 1}
        







    
        
