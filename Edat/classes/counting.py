class countingclass:
    count = 0

    def __init__(self,name,dob,country):
        self.name = name
        self.dob = dob
        self.country = country 

        countingclass.count+=1



rasmus = countingclass("rasmus","anna","sweden")
Fredrik = countingclass("fredrik","alexis","Johan")
print(countingclass.count)