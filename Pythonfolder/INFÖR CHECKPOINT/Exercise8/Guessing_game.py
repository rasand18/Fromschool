


target_number = input("Vilket nummer skulle du vilja ha som target?: ")
print('\033[H\033[J', end='')
allowed_gusses = input("Hur många gissningar vill du ha?: ")




if target_number.isnumeric() and allowed_gusses.isnumeric():
    print(f'Du har {allowed_gusses} gissningar att klura ut numret')
    for i in range(int(allowed_gusses)):
        gissning = input("Välj numret du vill gissa på: ")
        if gissning == target_number:
            print("Satan du hade rätt, du är inte så dum du!")
            break
        else:
            allowed_gusses = int(allowed_gusses)-1
            print(f'Det var fel, du har {allowed_gusses} gissningar kvar.')

else:
    print("Skriv in riktiga tal din jävla idiot!")

