// [DOCSTRING]
// Author: Andrew Nguyen + Claude (Minor Assistance)
// Date Started: Sat, 02/07/26
// Date Finished: Wed, 02/11/26
// Global Description: This program was created with the help of minor AI generative assistance. Lines/Blocks of code have been marked with comments explaining areas that AI had influence
// File Description: This file is responsible for creating the appointment object consisting of a unique unchangeable ID, date, and description. An appointment cannot be set in the past.

package appointment;

// To make an appointment, we need a valid date. You can't set one in the past.
import java.util.Date;

public class Appointment {

    private final String appointmentID;             // An appointment ID should not be updatable.
    private Date appointmentDate;                   // Using Date as a class. It is not a string or integer. It is its own value.
    private String appointmentDesc;                 // String appointmentDesc.

    public Appointment(String appointmentID, Date appointmentDate, String appointmentDesc) {
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("ID cannot exceed the length of 10 characters.");
        }

        if (appointmentDate == null || appointmentDate.before(new Date())) {                // AI had to generate this one. Did not understand the concept of .before() provided by importing Date.
            throw new IllegalArgumentException("\"Our time is passed, John... (You cannot pick a date that is already in the past.)\"");
        }

        if (appointmentDesc == null || appointmentDesc.length() > 50) {
            throw new IllegalArgumentException("Description cannot exceed the length of 50 characters.");
        }

        // File local variables (Same practice from last 2 modules)
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentDesc = appointmentDesc;
    }

    // Getter methods. (Same practice from last 2 modules)
    public String getAppointmentID() {
      return appointmentID;
    }

    public Date getAppointmentDate() {
      return appointmentDate;
    }

    public String getAppointmentDesc() {
      return appointmentDesc;
    }

    // NO SETTER FOR APPOINTMENT ID. APPOINTMENT ID REFRAINED FROM CHANGING. FINAL VARIABLE.
    // Setter methods. (Same practice from last 2 modules)
    public void setAppointmentDesc(String appointmentDesc) {
      if (appointmentDesc == null || appointmentDesc.length() > 50) {
          throw new IllegalArgumentException("...");
      }
      this.appointmentDesc = appointmentDesc;
    }

    public void setAppointmentDate(Date appointmentDate) {                  // Fixed by Claude to apply to Date concept, written by me.
      if (appointmentDate == null || appointmentDate.before(new Date())) {
          throw new IllegalArgumentException("...");
      }
      this.appointmentDate = appointmentDate;
    }

}
