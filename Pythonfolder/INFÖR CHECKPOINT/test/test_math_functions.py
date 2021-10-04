
from math_functions import fib

def test_fib_basic_initial():
    assert fib(0) == 0 
    assert fib(1) == 1

def test_fib_2():
    assert fib(2) == 1

def test_fib_3():
    assert fib(3) == 2