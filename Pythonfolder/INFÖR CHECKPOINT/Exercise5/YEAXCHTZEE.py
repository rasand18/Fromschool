import random
dice = [1,2,3,4,5,6]
n_dice = 5
rand_dice = random.choices(dice,weights=None,cum_weights=None,k=n_dice)

if rand_dice[0]==rand_dice[1]==rand_dice[2]==rand_dice[3]==rand_dice[4]:
    print("yeasaahhhtteee")
else:
    print("NOPE")

print(f'Det minsta värden är {min(rand_dice)} och det högsta värdet är {max(rand_dice)}\noch hela listan såg ut såhär {sorted(rand_dice)}')


