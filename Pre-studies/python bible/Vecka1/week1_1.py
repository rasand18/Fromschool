import random as r

health = 100

attack_1 = r.randint(20,30)
print(attack_1)

health = health - attack_1

print(health)

attack_2 = r.randint(20,30)
print(attack_2)

health = health - attack_2
print(health)

health_potion = r.randint(10,15)+10
print(health_potion)

finalhealth = health + health_potion
print("Your final health is:")
print(finalhealth)

