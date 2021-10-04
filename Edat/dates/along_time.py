def longest_time(h,m,s):
    value = max([(h*60*60,h),(m*60,m),(s,s)])
    return value

print(longest_time(2, 300, 15000))