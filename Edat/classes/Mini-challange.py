class programmer:

    def __init__(self,salary,work_hours):
        self.salary = salary
        self.workhours = work_hours
    
    def __del__(self):
        return 'ouff,'+str(self.salary)+''+str(self.workhours)
    
    def other(self,others_s,other_w):
        smallest = min([self.salary,others_s])
        return smallest

rasmus = programmer(2500,160)
print(rasmus.other(2600,170))
        