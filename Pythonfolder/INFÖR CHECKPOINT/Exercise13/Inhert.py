import datetime

class Person(object):


    def __init__(self,first_name,last_name,birthyear,domain=None):
        self.first_name = first_name
        self.last_name = last_name
        self.birthyear = birthyear
        self.domain = domain

        if self.domain == None:
            self.email = self.first_name+"."+self.last_name+"@"+"online.com"
        else:
            self.email = self.first_name+"."+self.last_name+"@"+self.domain

    @property
    def full_name(self):
        return (f"{self.first_name} : {self.last_name} ")
    @property
    def age(self):
        return 2021 - int(self.birthyear)

class Customer(Person):
    
    def __init__(self,first_name,last_name,birthyear,full_price,domain=None):
        super().__init__(first_name,last_name,birthyear,domain)
        self.full_price = full_price
        self.payed_price=0
    
    def discout_price(self):
        self.payed_price = self.full_price-self.age
        return self.payed_price

class Employee(Person):
    
    def __init__(self, first_name, last_name,birthyear, salary, defualt_domain=None):
        super().__init__(first_name,last_name,birthyear)
        self.salary = salary
        self.default_domain = defualt_domain
        self.customers = []

        if self.default_domain == None:
            self.email = self.first_name+"."+self.last_name+"@"+"Academy.com"
        else:
            self.email = self.first_name+"."+self.last_name+"@"+self.default_domain

    def add_customer(self,customer):
        self.customers.append(customer)
        print(self.customers)

    def drop_customer(self):
        self.customers=[]
        print(self.customers)
    
    def print_earnings(self):
        self.cumulativ = self.pa
        print(self.first_name,self.last_name,self.cumulative)


first_cust = Customer("Rasmus","Andreasson",1993,2000)
second_cust = Customer("Johan","Karlsson",2000,3000)
third_cust = Employee("Johan","Karlssson",1993,2000)



