class Menu:
    def __init__ (self,lst):
        self.lst = lst
        self.pos = 0
        self.len =len(lst)

    def to_the_right(self):
        self.pos = (self.pos + 1) % self.len
        
    def display(self):
        tmp_lst = self.lst.copy()
        tmp_lst[self.pos] = [tmp_lst[self.pos]]
        return str(tmp_lst)

menu = Menu([1,2,3])
menu.to_the_right()
menu.to_the_right()
menu.to_the_right()
print(menu.display())
