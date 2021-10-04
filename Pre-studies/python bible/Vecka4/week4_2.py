

import math

class Shape:
    
    def area(self):
        return(-1)

    def perimeter(self):
        return(-1)

class Circle(Shape):
    def __init__(self, radius):
        self.radius =radius

    def area(self):
        return self.radius*math.pi
        

    def circumfernce(self):
        return self.radius*math.pi*2

class Rectangle(Shape):

    def __init__(self,length,width):
        self.length = length
        self.width = width

    def area(self):
        return self.length*self.width

    def circumfernce(self):
        return 2 * (self.length + self.width)

class Square(Rectangle):
     def __init__(self,length,width):
         super().__init__(length, width)

p = Circle(5)
print(p.circumfernce())
         



        
        
        
        
    

    
    
