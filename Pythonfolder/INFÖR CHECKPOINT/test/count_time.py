import time

def timed_function(func):

    def wrapper():
        start = time.time()
        func()
        print("hello")
        end = time.time()
        print(end - start)

    return wrapper


def tid():
    for i in range(1,2):
        print("Hejsan")    

hejsan = timed_function(tid)
hejsan()