class one_three_one:
    def __init__(self,n):
        self.numbers = 'nines: {}, three: {}, one {}'.format(n//9,n%9//3,n%9%3)

first = one_three_one(30)
print(first.numbers)