from datetime import date

def first_thue(year, month):
    for i in range(1,8):
        if date(year,month,i).weekday() == 1:
            return f"The first thuesday of the month has the date {date(year,month,i)}"

print(first_thue(2021,2))