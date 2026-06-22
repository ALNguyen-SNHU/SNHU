// DOCSTRING TIMESTAMP: [1/25/2026]
// Author: Andrew Liem Nguyen
// Note: Created with AI assistance. I have not done a lot of Java programming in a while. I've been out of school for a while and haven't practiced.
// Desc: Tests for the Contact class requirements
// makes sure the Contact object rejects bad data (null, too long, wrong length) and accepts good data.

// package groups all related files together so they can find each other
package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testValidContact() {
         // Step 1: The Pitcher - we make the ball (data) here
        String id = "1234567890";
        String firstName = "Vito";
        String lastName = "Scaletta";
        String phone = "1234567890";
        String address = "Empire Bay, Highbrook";

        // step 2: The Throw - toss ball to Contact constructor
        Contact contact = new Contact(id, firstName, lastName, phone, address);


        // Step 8: The Goal - check if the ball we got back is same one we threw
        assertEquals(id, contact.getContactId());
        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(phone, contact.getPhone());
        assertEquals(address, contact.getAddress());
    }

    @Test
    void testIDexceed() {
          // 11 characters should fail
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Tommy", "Angelo", "1234567890", "Address");
        });
    }

    @Test
    void testContactIDNotNull() {
        // cant have a null ID, that would break everything
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Tommy", "Angelo", "1234567890", "Address");
        });
    }

    @Test
    void testFirstNameLessThan10() {
        // "VitooooVito" is 11 characters, should get rejected

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "VitooooVito", "Angelo", "1234567890", "Address");
        });
    }

    @Test
    void testFirstNameNull() {
        // no name no entry
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Angelo", "1234567890", "Address");
        });
    }

    @Test
    void testLastnameExceed() {
         // "ScalettaJrr" is 11 chars
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tommy", "ScalettaJrr", "1234567890", "Address");
        });
    }

    @Test
    void testLastNameNull() {
        // last name cant be null either
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tommy", null, "1234567890", "Address");
        });
    }

    @Test
    void testPhone10DigitExact() {
          // 9 digits - should fail because phone needs EXACTLY 10
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tommy", "Angelo", "123456789", "Address");
        });
    }

    @Test
    void testPhoneNull() {
        // need have a phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tommy", "Angelo", null, "Address");
        });
    }

    @Test
    void testAddressexceed() {
        // 31 characters, one over the limit
        // max is 30 according to requirements
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tommy", "Angelo", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    void TestNullAddress() {
        // need an address, even if its fake
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tommy", "Angelo", "1234567890", null);
        });
    }
}
