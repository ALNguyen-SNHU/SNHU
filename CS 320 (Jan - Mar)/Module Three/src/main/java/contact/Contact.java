// DOCSTRING TIMESTAMP: [1/25/2026]
// Author: Andrew Liem Nguyen
// Note: Created with AI assistance. I have not done a lot of Java programming in a while. I've been out of school for a while and haven't practiced.
// Desc: The Contact object itself. Holds the data for one contact - ID, name, phone, address. validates everything on creation.
// the ball (data) gets caught here, the referee checks if its valid, then it gets scored (stored). Getters pass the ball back when asked.

// package groups all related files together so they can find each other
package contact;

public class Contact {
    // made this final because the requirements say ID "shall not be updatable"
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Step 3: The Catch - Constructor catches the ball thrown by the pitcher
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

         // Step 4: The Referee - checks if the ball is valid before play continues
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID"); // "cannot be longer than 10 characters" "shall not be null"
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name"); // "cannot be longer than 10 characters" "shall not be null"
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name"); // "cannot be longer than 10 characters" "shall not be null"
        }

        // phone HAS to be exactly 10, not just max 10 like the others
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits"); // "must be exactly 10 digits" "shall not be null"
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address"); // "no longer than 30 characters" "shall not be null"
        }


        // step 5: The Score - valid ball is stored safely
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Accessors (Getters)
     // Step 6: Pass Request - teammate asks for the ball back
    // Step 7: Pass Complete - ball is thrown back
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }

    public String getAddress() { return address; }

    // Mutators (Setters) - no setter for contactId since it can't be changed

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name"); // "cannot be longer than 10 characters" "shall not be null"
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name"); // "cannot be longer than 10 characters" "shall not be null"
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        // Same validation as constructor
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be 10 digits"); // "must be exactly 10 digits" "shall not be null"
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address"); // "no longer than 30 characters" "shall not be null"
        }
        this.address = address;
    }

    // NOT REQUIRED BY HOMEWORK - added this for debugging, makes it easier to print contact info
    @Override
    public String toString() {
        return "Contact [" + contactId + "]: " + firstName + " " + lastName + ", " + phone + ", " + address;
    }
}
