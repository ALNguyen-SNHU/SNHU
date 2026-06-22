import random

# Welcome message
print("Welcome to the higher/lower game, Bella!")

# Input the bounds
while True:
    lower_bound = int(input("Enter the lower bound: "))
    upper_bound = int(input("Enter the upper bound: "))
    if lower_bound >= upper_bound:
        print("The lower bound must be less than the upper bound.")
    else:
        break

# Generate random number within the bounds
random_number = random.randint(lower_bound, upper_bound)

# Start the guessing game
print(f"Great, now guess a number between {lower_bound} and {upper_bound}:")
while True:
    # Input guess
    guess = int(input("Guess a number: "))

    # Input validation
    if guess < lower_bound or guess > upper_bound:
        print("Please enter a number within the bounds.")
    else:
        # Decision branching for the guess
        if guess < random_number:
            print("Nope, too low.")
        elif guess > random_number:
            print("Nope, too high.")
        else:
            print("You got it!")
            break

# Final message
print("Thank you for playing!")
