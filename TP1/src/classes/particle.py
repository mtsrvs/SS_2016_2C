class Particle(object):
    def __init__(self, position, radium):
        self.position = position
        self.radium = radium

    def get_position(self):
        return self.position

    def __str__(self):
        return "PARTICLE: " + str(self.get_position()) + " radium: " + str(self.radium) + "\n"
