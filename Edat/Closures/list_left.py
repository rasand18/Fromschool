from math import perm


def group(lst,size):
    # groups = [[] for _ in range(round(len(list) / n))]
    # for i in range(len(groups)):
    #     if len(list)<n:
    #         temp = n-len(list)
    #         n = n - temp
    #     for k in range(0,n):
    #         groups[i].append(list[k])
    #     del list[:n]
    # print(groups)  
    n = round(len(lst) / size)
    print(n)
    return [lst[i::n] for i in range(n)]

print(group([1, 2, 3, 4, 5, 6, 7], 4) )