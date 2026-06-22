# Hours worked
hoursworked = int(input("Hours worked: "))

# Hourly rates
start_rate = 20
overtime_rate = 30

# payment
payment = 0

# calculate
if hoursworked <= 40:
    payment = start_rate * hoursworked
else:
    payment = (start_rate * 40) + (overtime_rate * (hoursworked - 40))

print(payment)