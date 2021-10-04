
def date_format(date_f):
   d,m,y = date_f.split("/")
   return "".join((y+"-",m+"-",d))





print(date_format("11/12/2019"))