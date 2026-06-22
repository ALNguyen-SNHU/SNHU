// [DOCSTRING]
// Author: Andrew Nguyen + Claude (Minor Assistance)
// Date Started: Sat, 02/07/26
// Date Finished: Wed, 02/11/26
// Global Description: This program was created with the help of minor AI generative assistance. Lines/Blocks of code have been marked with comments explaining areas that AI had influence
// File Description: This file is responsible for testing the AppointmentService.java file for adding (appointments in map), adding duplicates, deleting, and deleting nonexisting events using the service.

package appointment;

// Imports done by AI
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    // Helper to create a future date
    private Date getFutureDate() {
        return new Date(System.currentTimeMillis() + 86400000); // tomorrow
    }

    @Test
    void testAddEvent() {
        AppointmentService service = new AppointmentService();                      // Call the service file
        Appointment event = new Appointment("12345", getFutureDate(), "Definitely A Valid description");         // Create the appointment
        service.addAppointment(event);                                               // Add the appointment

    }

    @Test
    void testAddDuplicateEvent() {
        AppointmentService service = new AppointmentService();                      // Call the service file
        Appointment event = new Appointment("12345", getFutureDate(), "Definitely A Valid description");         // Create the appointment
        service.addAppointment(event);                                               // Add the appointment just like the function above.

        assertThrows(IllegalArgumentException.class, () -> {          // Assertion Throws Error when...
            Appointment event2 = new Appointment("12345", getFutureDate(), "Second one");                        // Creating another appointment with the same ID
            service.addAppointment(event2);                                          // Attempting to add the appointment with the duplicate ID
        });
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();                      // Call the service file
        Appointment event = new Appointment("12345", getFutureDate(), "Definitely A Valid description");         // Create the appointment
        service.addAppointment(event);                                               // Add the appointment
          service.deleteAppointment("12345");                         // Delete via the appointment ID. It's the reliable source of truth separating any other appointment with same dates or descriptions.

    }

    @Test
    void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();                      // Call the service file
        // Appointment event = new Appointment("12345", getFutureDate(), "Definitely A Valid description");         // Don't even make one at all.

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("Idon'tExist");                      // Appointment was never made, should fail.
        });
    }
}
