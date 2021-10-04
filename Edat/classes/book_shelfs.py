class book_shelf:

    def __init__(self,title1,author1):
        self.title = title1
        self.author = author1
    
    def get_title(self):
        return 'Title: ' + self.title
    
    def get_author(self):
        return 'Author: ' + self.author


first = book_shelf("Rasmus","Anna")
Second = book_shelf("Book of love", "Anna Fransson")
print(Second.get_title(),Second.get_author())