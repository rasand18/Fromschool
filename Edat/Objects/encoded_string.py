import re

def parse_code(encode):
    if "0" in encode:
        first,second,id = encode.replace("0"," ").split()
        dicta = {"first_name": first, "last_name": second, "id": id}
    return dicta


    

print(parse_code("michael0smith004331"))