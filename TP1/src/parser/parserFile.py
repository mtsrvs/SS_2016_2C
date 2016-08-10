from random import randint

def parse_static(file):
    values = []
    i = 0

    with open(file,'r') as f:
        lines = f.readlines()
    f.close()

    while len(lines) > i:

        line = lines[i].replace('\n','')

        if i <= 1:
            values.append(int(line))
        else:
            values.append(float(line))

        i += 1

    return values

def parse_dynamic(file):
    positions = []
    i = 0

    with open(file,'r') as f:
        lines = f.readlines()
    f.close()

    while len(lines) > i:

        line = lines[i].replace('\n','')
        line.split('\t',2)

        if i > 0:
            positions.append(float(line))

        i += 1

    return positions
