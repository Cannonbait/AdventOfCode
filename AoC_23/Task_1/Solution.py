import re
f = open("Input", "r")
lines = f.readlines()

reFirst = re.compile('\d')
reLast = re.compile('(\d)(?!.*\d)')

numbersInLetters = {"one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6, "seven": 7, "eight": 8, "nine": 9}



sum = 0
for line in lines:
    print
    transLine = line
    for (text, number) in numbersInLetters.items():
        i = transLine.find(text)
        while (i != -1):
            transLine = transLine[:i+1] + str(number) + transLine[i+1:]
            i = transLine.find(text)
    print(transLine)
    firstDigit = reFirst.findall(transLine)[0]
    lastDigit = reLast.findall(transLine)[0]
    print(int(firstDigit+lastDigit))
    sum = sum + int(firstDigit+lastDigit)

print(sum)