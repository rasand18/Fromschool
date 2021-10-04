def hamming(string1,string2):
    # count = 0
    # for i in range(0,len(string1)):
    #     if string1[i] != string2[i]:
    #         count = count + 1
    
    # print(count)

    return sum(x!=y for (x,y) in zip(string1,string2))

print(hamming("rasmus","rasmis"))

