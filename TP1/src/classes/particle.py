class particle(object):
    def __init__(self, x, y, radium):
        self.x = x
        self.y = y
        self.radium = radium

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def __str__(self):
        return "PARTICLE: (" + str(self.x) + ", " + str(self.y) + " radium: " + str(self.radium) + "\n"
