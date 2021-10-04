
GUEST_LIST = {
"Randy": "Germany",
"Karla": "France",
"Wendy": "Japan",
"Norman": "England",
"Sam": "Argentina"
}



def greetings(name):
    if name in GUEST_LIST:
        print(f"Hi! I'm {name}, and I'm from {GUEST_LIST[name]}.")
    else:
        print("Hi! I'm a guest.")
    

greetings("Randy")
