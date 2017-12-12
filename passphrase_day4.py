"""
Day 4: passphrases
"""

validphrases = 0

with open("passphrases.txt", "r") as file:
    for line in file:
        linearray = line.split()
        invalidphrase = False
        for i in range(len(linearray)):
            i_sorted = ''.join(sorted(linearray[i]))
            for j in range(len(linearray)):
                j_sorted = ''.join(sorted(linearray[j]))
                if i != j:
                    if i_sorted == j_sorted:
                        invalidphrase = True

        if invalidphrase == False:
            validphrases = validphrases + 1



print("Number of valid phrases: %i" % validphrases)
