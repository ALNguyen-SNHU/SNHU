/*
 * Docstring used to combat plagiarism providing name, date, and time started.
 * I keep adding the trainingStatus attribute to the Monkey class, but it's already in the RescueAnimal class. So it's commented out.
 * Name: Andrew Nguyen
 * Date Started: 02/08/2025
 * Time Started: 3:00 PM
 */
// To access other files within the same directory, package must be declared at the top of the file.
package grazioso;

// Inherit animal attributes from rescue animal. (trainingStatus?)
public class Monkey extends RescueAnimal {
    private String species;
    // private String trainingStatus;   // Training status is in RescueAnimal
    private double height;
    private double tailLength;
    private double bodyLength;


    // Dummyhead monki
    public Monkey() {
        super();    // Call your mommy (parent constructor)
        this.species = "";
        // this.trainingStatus = "";
        this.height = 0.0;
        this.tailLength = 0.0;
        this.bodyLength = 0.0;
    }

    // Constructor monki
    public Monkey(String name, String species, String gender, String age, String weight, String acquisitionDate, 
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry,
                  double tailLength, double height, double bodyLength) {
        // Call your mom again (call RescueAnimal constructor)
        super(name, "Monkey", gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        // Add Monkey exclusive attributes
        this.species = species;
        // this.trainingStatus = trainingStatus;
        this.height = height;
        this.tailLength = tailLength;
        this.bodyLength = bodyLength;
        setTrainingStatus(trainingStatus);
    }

    // Mutator methods (Setters)
    public String setSpecies(String species) {
        // These species of monkeys are eligible for training:
        // (This list is very long and will probably need to be broken down on separate lines)
        if (species.equals("Capuchin") || species.equals("Guenon") || species.equals("Macaque") || species.equals("Marmoset") || species.equals("Squirrel monkey") || species.equals("Tamarin")) {
            this.species = species;
        } else {
            System.out.println("This species is not eligible for training.");
        }
    }

    // public String setTrainingStatus(String trainingStatus) {
    //     this.trainingStatus = trainingStatus;

    public double setHeight(double height) {
        this.height = height;
    }

    public double setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    // Accessor methods (Getters)

    public String getSpecies() {
        return species;
    }

    // public String getTrainingStatus() {
    //     return trainingStatus;

    public double getHeight() {
        return height;
    }

    public double getTailLength() {
        return tailLength;
    }

    public double getBodyLength() {
        return bodyLength;
    }
}

