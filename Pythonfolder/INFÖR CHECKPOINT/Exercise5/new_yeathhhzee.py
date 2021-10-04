import random

dice = [1,2,3,4,5,6]
n_dice = 5

rand_dices = random.choices(dice,cum_weights=None,weights=None,k=n_dice)
print(rand_dices)

if (rand_dices[0] == rand_dices[1] == rand_dices[2] == rand_dices[3] == rand_dices[4] == rand_dices[5]):
    print("YAHTZEEEEE ")
else:
    print("No yahtzee for you!")

print(f'The min value is {min(rand_dices)}')
print(f'The max value is {max(rand_dices)}')
print(f'Here you have the numbers sorted {sorted(rand_dices)}')