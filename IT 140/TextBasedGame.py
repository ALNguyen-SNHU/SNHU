# TextBasedGame.py
# Author: Andrew Nguyen

# Function to display game instructions
def show_instructions():
    print("\nTactical CQB Training Simulation")
    print("Objective: Collect all tactical gear before entering the Hostage Room.")
    print("Move commands: go North, go South, go East, go West")
    print("To collect gear: get [item name]")
    print("Type 'exit' to quit the game.\n")

# Function to display the player's current status
def show_status(current_room, inventory, rooms, items_in_rooms):
    print("\n----------------------")
    print(f"You are in the {current_room}.")
    print(f"Inventory: {inventory}")
    if current_room in items_in_rooms and items_in_rooms[current_room] not in inventory:
        print(f"You see a {items_in_rooms[current_room]}")
    # Display available directions
    directions = rooms[current_room].keys()
    print(f"Available directions: {', '.join(directions)}")
    print("----------------------")

# Main function
def main():
    # Dictionary linking rooms and their directions
    rooms = {
        "Briefing Room": {"North": "Gear Storage", "South": "Locker Room", "East": "Corridor", "West": "Tactical Storage Room"},
        "Locker Room": {"North": "Briefing Room", "East": "Equipment/Tool Storage"},
        "Tactical Storage Room": {"East": "Briefing Room", "North": "Armory"},
        "Gear Storage": {"South": "Briefing Room", "North": "Explosive Ordnance Storage"},
        "Explosive Ordnance Storage": {"South": "Gear Storage", "West": "Staging Area"},
        "Staging Area": {"East": "Explosive Ordnance Storage"},
        "Corridor": {"West": "Briefing Room", "North": "Hostage Room"},
        "Equipment/Tool Storage": {"West": "Locker Room"},
        "Hostage Room": {"South": "Corridor"},
        "Armory": {"South": "Tactical Storage Room"}
    }

    # Dictionary linking items to rooms
    items_in_rooms = {
        "Locker Room": "Plate Carrier",
        "Armory": "Beanbag Shotgun",
        "Gear Storage": "Sling",
        "Explosive Ordnance Storage": "Stinger",
        "Staging Area": "Radio",
        "Corridor": "Tactical Helmet",
        "Equipment/Tool Storage": "Pepper Spray",
        "Tactical Storage Room": "Taser"
    }

    # Initialize game variables
    current_room = "Briefing Room"
    inventory = []
    required_items = len(items_in_rooms)  # Total items to collect

    # Show game instructions
    show_instructions()

    # Gameplay loop
    while True:
        # Display player's status
        show_status(current_room, inventory, rooms, items_in_rooms)

        # Get player input
        command = input("Enter your move: ").strip().lower()

        # Handle 'exit' command
        if command == "exit":
            print("Game Over. Thanks for playing!")
            break

        # Handle movement commands
        if command.startswith("go "):
            direction = command[3:].capitalize()  # Extract direction
            if direction in rooms[current_room]:  # Valid direction
                current_room = rooms[current_room][direction]

                # Check if player enters the Hostage Room
                if current_room == "Hostage Room":
                    if len(inventory) == required_items:
                        print("\nCongratulations! You have collected all items and successfully cleared the Hostage Room!")
                        print("Thanks for playing the game. Hope you enjoyed it.")
                        break
                    else:
                        print("\nMission Failed! You entered the Hostage Room without all the required gear.")
                        print("\"This is TOC (Tactical Operations Center). You've failed your mission. Return to center for debrief.\"")
                        print("Thanks for playing the game. Hope you enjoyed it.")
                        break
            else:
                print("Invalid direction. Please choose a valid direction.")

        # Handle 'get [item]' command
        elif command.startswith("get "):
            item = command[4:]  # Extract item name
            if current_room in items_in_rooms and items_in_rooms[current_room].lower() == item.lower():
                if item not in inventory:
                    inventory.append(item)
                    print(f"{item} has been added to your inventory.")
                    del items_in_rooms[current_room]  # Remove the item from the room
                else:
                    print(f"You already have {item} in your inventory.")
            else:
                print(f"There is no {item} here to get.")

        # Handle invalid commands
        else:
            print("Invalid command. Try again.")

# Run the game
if __name__ == "__main__":
    main()
