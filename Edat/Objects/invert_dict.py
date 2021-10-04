from typing_extensions import runtime


def invert(dicta):
    
    new_dict = {y:x for x,y in dicta.items()}
    print(new_dict)

invert({ "z": "q", "w": "f" })
invert({ "a": 1, "b": 2, "c": 3 })