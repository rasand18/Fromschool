current_number = 100
total_number = 100
bar_length = 10

num_equals = int((current_number*bar_length)/total_number)
barload = ("="*num_equals + ">" if current_number<total_number else "="*num_equals) 
space = " "*(10-num_equals)
print(f'|{barload}'f'{space}|')
