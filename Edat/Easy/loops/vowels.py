def vovels(word):

    return sum(c in "aeiou" for c in word )

    # voels = ['a', 'e', 'i', 'o', 'u']
    # counts = 0
    # for i in word.lower():
    #     if i in voels:
    #         counts=counts+1
    # print(counts)

print(vovels("Celebration"))

    