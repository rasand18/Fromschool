from numpy import prod
def combinations(*items):
    summa = prod([x for x in items])
    print(summa)
combinations(2,3)