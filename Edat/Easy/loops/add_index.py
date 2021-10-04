def addindx(listan):
    # for i in range(0,len(listan)):
    #     listan[i] = listan[i] + i

    # print(listan)
    return [i+j for i, j in enumerate(listan)]

print(addindx([1, 2, 3, 4, 5]))