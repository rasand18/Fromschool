from typing import Set


captured = ("pika","pidgey","abra","pidgey","Eve","pidgey")
unique = set(captured)
user = input("Vilken pokemon undrar du om Ash har?: ")
if user in captured:
    print(f"Denna pokemonen finns!\nDet finns totalt {captured.count(user)} och den totala mängden av unika pokemon är {len(unique)}!")





