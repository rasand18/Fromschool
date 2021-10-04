def oddnum(lista):
    new_lista = []
    for i in lista:
        if i%2 == 0:
            pass
        else:
            new_lista.append(i)
    print(len(new_lista))

oddnum([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5])