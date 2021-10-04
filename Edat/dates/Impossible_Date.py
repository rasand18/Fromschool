from datetime import date
def is_valid_date(d,m,y):

    try:
        newd = date(y,m,d)
        return True
    except:
        return False




print(is_valid_date(45, 2, 2020))