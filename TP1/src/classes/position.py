class Position(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def get_X(self):
        return self.x

    def get_Y(self):
        return self.y

    def __str__(self):
        return "(" + str(self.x) + ", " + str(self.y) + ")"
