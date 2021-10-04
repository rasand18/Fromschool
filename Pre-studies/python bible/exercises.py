first_name = 'Rasmus'
last_name = 'Andreasson'
course = 'Telia data engineer'
students = '12'


print(f'My name is {first_name}, with last name {last_name}. I am participating in the course {course}. There are {students} candidates taking the course ')

print('| |',end='',flush=True)
print(' My name is ' + first_name, end='\n')
time.sleep(1)
