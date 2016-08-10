from parser import parserFile as pf
from classes.particle import Particle
from classes.position import Position

def main():

    input_static = pf.parse_static('./input/static.txt')
    input_dynamic = pf.parse_dynamic('./input/dynamic.txt')

    n = input_static[0]
    l = input_static[1]

    part = Particle(Position(1,2), 0.3)
    print("valor: " + str(part))

main()