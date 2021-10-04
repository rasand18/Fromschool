class person: 

    def __init__(self,name,foodL,foodH):
        self.name = name 
        self.foodL = foodL
        self.foodH = foodH

    def taste(self,foodname):
        text = '{} eats {}'.format(self.name,foodname)
        if foodname in self.foodL:
           return text+" and she loves it!"
        elif foodname in self.foodH:
            return text+' and she hates it!'
        else:
            return text+'!'

rasmus = person("Anna",["bajs","kiss"],["köttfärs","bär"])
print(rasmus.taste("kiss"))

