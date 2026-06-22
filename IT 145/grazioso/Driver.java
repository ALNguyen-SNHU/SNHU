/*
 * Upon rereading the instructions, it doesn't look like I had to change much. However, I did add my monkeys to the test.
 * NOTE: This is the same code being reused from assignment 5-4. You stated in the email I'm allowed to reuse code from that previous assignment.
 * 
 * I'm also keeping all the stubbed out comments. If I'm required to clean it up, I will do it upon revision.
 * This is a late submission. I apologize for the inconvenience. If I didn't mention this earlier, I was at a funeral on the 22nd.
 * 
 * Author: Andrew Nguyen
 * Date Started: 02/21/2025
 * Time Started: 10:00 PM
 */
package grazioso;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    // create the list (array) of monkeys
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        Scanner scanner = new Scanner(System.in);
        String menuSelection = "";
        while (!menuSelection.equalsIgnoreCase("q")) {
            displayMenu();
            menuSelection = scanner.nextLine();
            switch (menuSelection) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        // "name", "species", "gender", "age", "weight", "acquisitionDate", "acquisitionCountry", "trainingStatus", "reserved", "inServiceCountry", "tailLength", "height", "bodyLength"
        // These are all strings, except for tailLength, height, and bodyLength
        monkeyList.add(new Monkey("Curious George", "Capuchin", "male", "3", "12", "05-10-2021", "Democratic Republic of Congo", "in service", false, "United States", 0.5, 55.5, 30.0));
        monkeyList.add(new Monkey("Skips", "Macaque", "male", "unknown/immortal", "400", "11-17-19XX", "United States", "in service", false, "United States", 3.5, 150.5, 60.0));
        monkeyList.add(new Monkey("Wu Kong", "Macaque", "male", "unknown/immortal", "132", "04-08-0600", "China", "not in service", true, "China", 4.2, 120.0, 50.0));
        monkeyList.add(new Monkey("Monkey", "Tamarin", "male", "22", "68", "06-18-2002", "China", "in service", false, "China", 16.0, 80.0, 45.0));
        monkeyList.add(new Monkey("Diddy Kong", "Squirrel monkey", "male", "12", "35", "06-22-2012", "Kongo Jungle", "in service", false, "Japan", 15.5, 55.5, 40.0));

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // adding dog attributes
        System.out.println("input breed: ");
        String breed = scanner.nextLine();
        
        System.out.println("input gender: ");
        String gender = scanner.nextLine();
        
        System.out.println("input age: ");
        String age = scanner.nextLine();
        
        System.out.println("input weight: ");
        String weight = scanner.nextLine();
        
        System.out.println("input acquisition date | Format = (MM-DD-YYYY): ");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("input acquisition country: ");
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("input training status: ");
        String trainingStatus = scanner.nextLine();
        
        System.out.println("Rescue animal (dog) reserved? Type \"true\" or \"false\": ");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        
        System.out.println("input in-service country: ");
        String inServiceCountry = scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("New dog successfully added.");
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            // System.out.println("The method intakeNewMonkey needs to be implemented");
            System.out.println("input monkey's name?");
            String name = scanner.nextLine();
            /*
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(scanner.nextLine())) {
                    System.out.println("Rescue animal already exists");
                    return;
                }
            }
            */
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("Rescue animal already exists");
                    return;
                }
            }

            System.out.println("Enter species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin):");
            String species = scanner.nextLine();
            if (!species.equals("Capuchin") && !species.equals("Guenon") && !species.equals("Macaque") &&
                !species.equals("Marmoset") && !species.equals("Squirrel monkey") && !species.equals("Tamarin")) {
                System.out.println("Invalid species. Only trained species are allowed.");
                return;
            }
    
            System.out.println("Input gender: ");
            String gender = scanner.nextLine();
            
            System.out.println("Input age: ");
            String age = scanner.nextLine();
            
            System.out.println("Input weight: ");
            String weight = scanner.nextLine();
            
            System.out.println("Input acquisition date | Format = (MM-DD-YYYY): ");
            String acquisitionDate = scanner.nextLine();
            
            System.out.println("Input acquisition country: ");
            String acquisitionCountry = scanner.nextLine();
            
            System.out.println("Input training status: ");
            String trainingStatus = scanner.nextLine();
            
            System.out.println("Rescue animal (monkey) reserved? Type \"true\" or \"false\": ");
            boolean reserved = Boolean.parseBoolean(scanner.nextLine());
            
            System.out.println("Input in-service country: ");
            String inServiceCountry = scanner.nextLine();
            
            // Monkey exclusive attributes
            System.out.println("Input tail length: ");
            double tailLength = Double.parseDouble(scanner.nextLine());
            
            System.out.println("Input height: ");
            double height = Double.parseDouble(scanner.nextLine());
            
            System.out.println("Input body length: ");
            double bodyLength = Double.parseDouble(scanner.nextLine());
    
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
            monkeyList.add(newMonkey);
            System.out.println("New rescue animal (monkey) added.");
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            // System.out.println("The method reserveAnimal needs to be implemented");
            System.out.println("Enter rescue animal type (dog or monkey): ");
            String animalType = scanner.nextLine();
            System.out.println("Enter in-service country: ");
            String country = scanner.nextLine();

            if (animalType.equalsIgnoreCase("dog")) {
                for (Dog dog : dogList) {
                    if (dog.getInServiceCountry().equalsIgnoreCase(country) && !dog.getReserved()) {
                        dog.setReserved(true);
                        System.out.println("Dog reserved.");
                        return;
                    }
                }
            } 
            else if (animalType.equalsIgnoreCase("monkey")) { // fix checking monkeys when you come back
                for (Monkey monkey : monkeyList) {
                    if (monkey.getInServiceCountry().equalsIgnoreCase(country) && !monkey.getReserved()) {
                        monkey.setReserved(true);
                        System.out.println("Monkey reserved.");
                        return;
                    }
                }
            } 
            else {
                System.out.println("Invalid animal type.");
            }
        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listType) {
            // System.out.println("The method printAnimals needs to be implemented");
            // for (Dog dog : dogList) {
            //     System.out.println("Dog name: " + dog.getName());
            //     System.out.println("Dog status: " + dog.getTrainingStatus());
            //     System.out.println("Dog acquisition country: " + dog.getAcquisitionCountry());
            //     System.out.println("Dog reserved: " + dog.isReserved());
            //     System.out.println();
            // }

            // for (Monkey monkey : monkeyList) {
            //     System.out.println("Monkey name: " + monkey.getName());
            //     System.out.println("Monkey status: " + monkey.getTrainingStatus());
            //     System.out.println("Monkey acquisition country: " + monkey.getAcquisitionCountry());
            //     System.out.println("Monkey reserved: " + monkey.isReserved());
            //     System.out.println();
            // }
            
            if (listType.equalsIgnoreCase("dog")) {
                System.out.println("\nList of Dogs:");
                for (Dog dog : dogList) {
                    System.out.println(dog.getName() + " - " + dog.getTrainingStatus() + " - "
                        + dog.getAcquisitionCountry() + " - Reserved: " + dog.getReserved());
                }
            } 
            else if (listType.equalsIgnoreCase("monkey")) {
                System.out.println("\nList of Monkeys:");
                for (Monkey monkey : monkeyList) {
                    System.out.println(monkey.getName() + " - " + monkey.getTrainingStatus() + " - "
                        + monkey.getAcquisitionCountry() + " - Reserved: " + monkey.getReserved());
                }
            } 
            else if (listType.equalsIgnoreCase("available")) {
                System.out.println("\nAvailable Animals (In Service and Not Reserved):");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                        System.out.println(dog.getName() + " - " + dog.getAcquisitionCountry());
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                        System.out.println(monkey.getName() + " - " + monkey.getAcquisitionCountry());
                    }
                }
            } 
            else {
                System.out.println("Invalid list type.");

        }
    }
}

