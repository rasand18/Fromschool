
class Calculator:

    def add(self,*num):
        tot = 0
        for i in range(len(num)):
            tot = tot + num[i]
        return tot


    def sub(self,*num):
        tot = num[0]
        for i in range(1,len(num)):
            tot = tot - num[i]
        return tot

    def div(self,x,y):
        tot = x/y
        return tot
    
    def multi(self,*num):
        tot = num[0]
        for i in range(1,len(num)):
            tot = tot * num[i]
        return tot
    
    
    
    
        

