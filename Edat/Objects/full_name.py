class names:
    def __init__(self,first,last):
        self.first_name = first
        self.last_name = last
        self.full_name = first + " " + last
        self.email = f"{first}.{last}@hotmail.com"


emp1 = names("John","Andersson")
emp2 = names("Anna","Fransson")

