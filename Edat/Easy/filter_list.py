def filter_list(listan):
    new_lista = [I for I in listan if type(I) is int]
    print(new_lista)

filter_list([1,2,3,4,"hej"])

