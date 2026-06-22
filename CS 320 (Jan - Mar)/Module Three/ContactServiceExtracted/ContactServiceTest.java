// DOCSTRING TIMESTAMP: [1/25/2026]
// Author: Andrew Liem Nguyen + gemini
// Note: Created with AI assistance. I have not done a lot of Java programming in a while. I've been out of school for a while and haven't practiced.
// Desc: Testing the Team Manager (Service). Verifying we can hire, fire, and update players.
// Tests adding, deleting, updating, and getting contacts. Also tests that duplicates and ghosts get rejected.

// package groups all related files together so they can find each other
package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactServiceTest {
    
    private ContactService service;

    @BeforeEach
    void setUp() {
        // Fresh roster before every test game.
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);
        // If no exception is thrown, the hire was successful.
        assertDoesNotThrow(() -> service.deleteContact("12345"));
    }

    @Test
    void testAddDuplicateId() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "Address");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "Address 2");
        
        service.addContact(contact1);
        
        // Manager should refuse to hire someone with a taken badge number.
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);
        
        // Fire the player.
        service.deleteContact("12345");
        
        // Try to fire them again - should fail because they are already gone.
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        // Update stats, Coach changes all the player's info.
        // testing all four updatable fields at once
        // firstName, lastName, phone, address
        service.updateContact("12345", "Jane", "Smith", "0987654321", "New Address");

        // Scout the player to verify the stats actually changed.
        Contact updated = service.getContact("12345");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("New Address", updated.getAddress());
    }

    @Test
    void testUpdateNonExistentContact() {
        // Coach tries to update a player who isn't on the roster. Whistle blows!
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("ghost", "Jane", "Smith", "0987654321", "Address");
        });
    }

    @Test
    void testAddNullContact() {
        // Manager tries to sign a ghost player. Rejected!
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    void testDeleteNonExistentContact() {
        // Manager tries to fire someone who was never hired. Can't fire a ghost!
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("ghost");
        });
    }

    @Test
    void testGetContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        // Scout retrieves the player's info successfully.
        Contact retrieved = service.getContact("12345");
        String firstName = retrieved.getFirstName();
        String lastName = retrieved.getLastName();
        assertEquals("John", firstName);
        assertEquals("Doe", lastName);
    }

    @Test
    void testGetNonExistentContact() {
        // Scout tries to find a player not on the roster. No dice!
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("ghost");
        });
    }
}
