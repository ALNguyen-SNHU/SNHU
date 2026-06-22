public class Dog {
    // Attributes
    private int dogSpaceNumber; // Boarding space assigned to the dog
    private double dogWeight;  // Weight of the dog in pounds
    private boolean grooming;  // Indicates if grooming is requested

    // Constructor to initialize all attributes
    public Dog(int dogSpaceNumber, double dogWeight, boolean grooming) {
        this.dogSpaceNumber = dogSpaceNumber;
        this.dogWeight = dogWeight;
        this.grooming = grooming;
    }

    // Gets the dog's boarding space number
    public int getDogSpaceNumber() {
        return dogSpaceNumber;
    }

    // Sets the dog's boarding space number
    public void setDogSpaceNumber(int dogSpaceNumber) {
        this.dogSpaceNumber = dogSpaceNumber;
    }

    // Gets the dog's weight
    public double getDogWeight() {
        return dogWeight;
    }

    // Sets the dog's weight
    public void setDogWeight(double dogWeight) {
        this.dogWeight = dogWeight;
    }

    // Gets the grooming status
    public boolean getGrooming() {
        return grooming;
    }

    // Sets the grooming status
    public void setGrooming(boolean grooming) {
        this.grooming = grooming;
    }
}