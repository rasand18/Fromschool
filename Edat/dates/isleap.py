from calendar import isleap

def number_of_leap(number):
    start, end = map(int,number.split('-'))
    count = 0
    for i in range(start,end+1):
       return sum(isleap(i) == True)
    
print(number_of_leap("1980-1984"))