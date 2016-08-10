from random import uniform
from classes.position import Position

# genera n position entre 0.0 a l con 3 decimales
def generator(n,l):
    list_position = []

    i = 0
    while n > i:
        x = float("{0:.3f}".format(uniform(0.0, float(l))))
        y = float("{0:.3f}".format(uniform(0.0, float(l))))
        list_position.append(Position(x, y))
        i += 1

    return list_position

# generator(10, 5)