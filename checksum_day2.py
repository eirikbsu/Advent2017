"""
@author: Eirik Bager Sundmark
"""
checksum = 0

with open("day2.txt", "r") as file:
    for line in file:
        lowest = 100000
        highest = 0
        linearray = line.split()

        for i in range(len(linearray)):
            if int(linearray[i]) > highest:
                highest = int(linearray[i])
            if int(linearray[i]) < lowest:
                lowest = int(linearray[i])

        linesum = (highest - lowest)
        checksum += linesum

print("Answer: %i" % checksum)
