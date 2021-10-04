value_list = [2,4,6,7,4,2,1,1,4,6,7,]
alpha = 0.5

value_list=sorted(value_list)
print(value_list)

lower_idx = round(len(value_list)*alpha/2)

upper_idx = round(len(value_list)*(1-alpha/2))-1

print(f"The lower idx is {value_list[:lower_idx]} and the upper idx is {value_list[upper_idx:]}")
