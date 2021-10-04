special = ["!",",",";",":","@"]

def clean_str(dirty_str):
    for char in dirty_str:
        if char in special:
            dirty_str = dirty_str.replace(char,"")
    print(dirty_str.lower())

            
clean_str("Hello world!!!!!,;:")