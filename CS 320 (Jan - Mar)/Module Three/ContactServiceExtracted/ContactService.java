// DOCSTRING TIMESTAMP: [1/25/2026]
// Author: Andrew Liem Nguyen
// Note: Created with AI assistance. I have not done a lot of Java programming in a while. I've been out of school for a while and haven't practiced.
// Desc: The contact service. Handles adding, deleting, and updating contacts.
// This is like the manager that keeps track of all contacts in memory using a HashMap.

// package groups all related files together so they can find each other
package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // using a map so we can look up contacts by ID quickly
    // learned about this in data structures, seemed like the right choice
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        // Check for null and duplicates
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contacts.get(contactId);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    // Updates whichever fields are passed in (non-null ones)
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = getContact(contactId); // this will throw if not found

        // only update fields that were actually provided
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    // NOT REQUIRED BY HOMEWORK - helper method to check if contact exists without throwing an exception
    public boolean hasContact(String contactId) {
        return contacts.containsKey(contactId);
    }
}
