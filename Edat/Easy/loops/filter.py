def filterstr(listan):
    new_lista = [x for x in listan if type(x) != str]
    print(new_lista)


filterstr([1, 2, 3, "a", "b", 4])
