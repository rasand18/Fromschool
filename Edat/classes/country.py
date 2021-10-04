class country:

    def __init__(self,name,population,area):
        self.name = name
        self.population = population
        self.area = area
        if population > 250 or area > 300:
            self.isbig = True
        else:
            self.isbig = False
        self.popdensity = self.population/self.area
    
    def compare(self,country):
        
        return '{} has a {} population density than {}'.format(self.name,("smaller" if self.popdensity > country.popdensity else "bigger"),\
            country.name)

australia = country("Australia", 235, 769)
andorra = country("Andorra", 20, 30)
print(andorra.compare(australia))