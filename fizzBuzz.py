def fizzBuzz():
    output = ""
    for num in range(1, 101):
        fzbz = True
        if num %3 == 0:
            output = output + "Fizz"
            fzbz = False
        if num %5 == 0:
            output = output + "Buzz"
            fzbz = False
        if fzbz:
            output = output + str(num)
        if num != 100:
            output = output + ","
    print(output)

fizzBuzz()
