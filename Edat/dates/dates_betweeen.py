import datetime

def days_between(date1,date2):
    between = (date2-date1).days
    print(between)
    date2 = 360 - date2.days

days_between(
  datetime.date(2020, 5, 24),
  datetime.date(2019, 5, 24))
