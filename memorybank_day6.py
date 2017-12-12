"""
Memory banks configurations
"""

memorybank = []

with open("day6_input.txt", "r") as file:
    for line in file:
        linenumbers = line.split("\t")
        for i in range(len(linenumbers)):
            memorybank.append(int(linenumbers[i]))

numberofcycles = 0
configurations = []
repeatedconfiguration = False
loopcycles = 0

while repeatedconfiguration == False:
    currentconfig = str(memorybank)
    if len(configurations) > 0:
        for i in range(len(configurations)):
            if configurations[i] == currentconfig:
                repeatedconfiguration = True
                loopcycles = len(configurations) - i
                break

    configurations.append(currentconfig)

    mostblocks = 0
    highestnumberofblocks = 0

    for i in range(len(memorybank)):
        if memorybank[i] > highestnumberofblocks:
            mostblocks = i
            highestnumberofblocks = memorybank[i]

    memorybank[mostblocks] = 0
    addto = 0
    if mostblocks == len(memorybank) - 1:
        addto = 0
    else:
        addto = mostblocks + 1

    if repeatedconfiguration == False:
        while (highestnumberofblocks > 0):
            memorybank[addto] = memorybank[addto] + 1
            highestnumberofblocks = highestnumberofblocks - 1
            if addto == 15:
                addto = 0
            else:
                addto = addto + 1

    if repeatedconfiguration == False:
        numberofcycles = numberofcycles + 1

print("Number of cycles necessary before a configuration is repeated: %i" % numberofcycles)
print("Number of cycles in the actual loop: %i" % loopcycles)
