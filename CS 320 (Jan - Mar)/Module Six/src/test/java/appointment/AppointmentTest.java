// [DOCSTRING]
// Author: Andrew Nguyen + Claude (Minor Assistance)
// Date Started: Sat, 02/07/26
// Date Finished: Wed, 02/11/26
// Global Description: This program was created with the help of minor AI generative assistance. Lines/Blocks of code have been marked with comments explaining areas that AI had influence
// File Description: This file is responsible for testing Appointment.java for appointments that go with or against the parameter requirements of the creation of an appointment, along with the creation of one in itself.
// Tests for null details (id, date, and desc), along with dates that cannot be set in the past, ID's longer than 10 characters, and desc longer than 50.

package appointment;

// Ai does the import packages.
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;                              // For the date class.

public class AppointmentTest {

    // Create a future date.
    private Date getFutureDate() {                   // AI had me make this
        return new Date(System.currentTimeMillis()); // Some time tomorrow
    }

    @Test
      void testAppointmentCreation() {               // AI helped make this first one.
          Appointment appt = new Appointment("01010101", getFutureDate(), "Definitely A  Valid description");
          assertEquals("01010101", appt.getAppointmentID());
    }

    @Test
      void testAppointmentIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
          Appointment appt = new Appointment(null, getFutureDate(), "Definitely A  Valid description");
        });
    }

    @Test
    void testAppointmentIdExceed() {
      assertThrows(IllegalArgumentException.class, () -> {
          new Appointment("67676767676767676767", getFutureDate(), "Definitely A  Valid description");    // 67 really isn't that funny
      });
    }

    @Test
    void testAppointmentDateNull() {
      assertThrows(IllegalArgumentException.class, () -> {
          new Appointment("01010101", null, "Definitely A  Valid description");
      });
    }

    @Test
    void testAppointmentDateInPast() {
      assertThrows(IllegalArgumentException.class, () -> {
          new Appointment("01010101", new Date(0), "Definitely A  Valid description");       // AI fixed logic by adding new Date(0) argument picking a date in the past.
      });
    }

    @Test
    void testAppointmentDescNull() {
      assertThrows(IllegalArgumentException.class, () -> {
          new Appointment("01010101", getFutureDate(), null);
      });
    }

    @Test
    void testAppointmentDescExceed() {
      assertThrows(IllegalArgumentException.class, () -> {
          new Appointment("01010101", getFutureDate(), "This description is far too long. It is around two sentences and over 50 characters. I think.");
      });
    }

}
