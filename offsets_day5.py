"""
Day 5 - offsets
"""

instructions = []

with open("day5_input.txt", "r") as file:
    for line in file:
        line_int = int(line)
        instructions.append(line_int)

numberofsteps = 0
escaped = False
currentposition = 0
instructionlistlength = len(instructions)

while escaped == False:
    if currentposition >= instructionlistlength:
        escaped = True
    else:
        temp_position = currentposition
        currentposition = currentposition + instructions[currentposition]
        if instructions[temp_position] >= 3:
            instructions[temp_position] = instructions[temp_position] - 1
        else:
            instructions[temp_position] = instructions[temp_position] + 1
        numberofsteps = numberofsteps + 1

print("Number of steps used to escape: %i" % numberofsteps)
