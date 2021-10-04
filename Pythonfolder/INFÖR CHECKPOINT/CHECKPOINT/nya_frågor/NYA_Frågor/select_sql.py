import os

path = os.getcwd()

def root():
    ny_lista=(path.split("\\"))
    return(ny_lista[-1])
    

print(root())

    