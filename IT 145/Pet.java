/**
 * Pet class represents a pet's basic details and billing information in the Pet BAG system.
 * This class supports encapsulation with private attributes and accessor/mutator methods.
 */
public class Pet {
    // Attributes
    private String petType;   // Dog or Cat
    private String petName;   // Name of the pet
    private int petAge;       // Age of the pet in years
    private int dogSpaces;    // Number of dog boarding spaces
    private int catSpaces;    // Number of cat boarding spaces
    private int daysStay;     // Number of days the pet is staying
    private double amountDue; // Amount due for the pet's stay

    // Constructor
    /**
     * Default constructor to initialize pet attributes with default values.
     */
    public Pet() {
        this.petType = "";
        this.petName = "";
        this.petAge = 0;
        this.dogSpaces = 0;
        this.catSpaces = 0;
        this.daysStay = 0;
        this.amountDue = 0.0;
    }

    // Accessor and Mutator Methods
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public int getDogSpaces() {
        return dogSpaces;
    }

    public void setDogSpaces(int dogSpaces) {
        this.dogSpaces = dogSpaces;
    }

    public int getCatSpaces() {
        return catSpaces;
    }

    public void setCatSpaces(int catSpaces) {
        this.catSpaces = catSpaces;
    }

    public int getDaysStay() {
        return daysStay;
    }

    public void setDaysStay(int daysStay) {
        this.daysStay = daysStay;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
}
