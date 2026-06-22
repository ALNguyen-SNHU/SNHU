# ModuleSixMilestone.py

# Initialize game variables
current_room = "Briefing Room"
rooms = {
    "Briefing Room": {"North": "Gear Storage", "South": "Locker Room", "East": "Corridor", "West": "Tactical Storage Room"},
    "Locker Room": {"North": "Briefing Room", "East": "Equipment/Tool Storage"},
    "Tactical Storage Room": {"East": "Briefing Room", "North": "Armory"},
    "Gear Storage": {"South": "Briefing Room", "North": "Explosive Ordnance Storage"},
    "Explosive Ordnance Storage": {"South": "Gear Storage", "West": "Staging Area"},
    "Staging Area": {"East": "Explosive Ordnance Storage"},
    "Corridor": {"West": "Briefing Room", "North": "Hostage Room"},  # Removed East connection
    "Equipment/Tool Storage": {"West": "Locker Room"},
    "Hostage Room": {"South": "Corridor"},
    "Armory": {"South": "Tactical Storage Room"}
}

# Display game intro
print("Welcome to the Tactical CQB Training Mission!")
print("Your objective: Collect all necessary gear and clear the final room.")
print("Type 'exit' at any time to quit the game.\n")

# Gameplay loop
while current_room != "exit":
    # Display the current room and available directions
    print(f"You are currently in the {current_room}.")
    print("Available directions:", ", ".join(rooms[current_room].keys()))

    # Get player input
    direction = input("Enter a direction (North, South, East, West) or 'exit': ").capitalize()

    # Handle player commands
    if direction == "Exit":
        current_room = "exit"  # End the game
    elif direction in rooms[current_room]:  # Valid direction
        current_room = rooms[current_room][direction]
        print(f"You moved to the {current_room}.\n")
    else:  # Invalid direction
        print("Invalid direction. Please choose a valid direction.\n")

# End of the game
print("Game Over. Thanks for playing!")
