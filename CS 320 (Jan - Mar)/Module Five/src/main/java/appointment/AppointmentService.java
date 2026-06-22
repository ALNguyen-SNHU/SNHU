// [DOCSTRING]
// Author: Andrew Nguyen + Claude (Minor Assistance)
// Date Started: Sat, 02/07/26
// Date Finished: Wed, 02/11/26
// Global Description: This program was created with the help of minor AI generative assistance. Lines/Blocks of code have been marked with comments explaining areas that AI had influence
// File Description: This file is responsible for the service that deletes and adds appointments to a map/dictionary. 

package appointment;

// Imports copied over from previous modules.
import java.util.Map;
import java.util.HashMap;

public class AppointmentService {

    private Map<String, Appointment> events = new HashMap<>();

    // Add appointment with unique ID
    public void addAppointment(Appointment appointment) {
      if (events.containsKey(appointment.getAppointmentID())) {                                                   // If the event/appointment already exists
          throw new IllegalArgumentException("This appointment slot has already been selected.");             // Throw an error message
      }
        events.put(appointment.getAppointmentID(), appointment);                                                 // If NOT, add the appointment to the event map.
    }

    // Delete appointment by ID
    public void deleteAppointment(String appointmentId) {
        if (!events.containsKey(appointmentId)) {                                                                // If the ID is not in the event list (appointment not made),
            throw new IllegalArgumentException("The appointment does not exist. Feel free to make one.");    // Throw an error message
        }
        events.remove(appointmentId);                                                                            // If it does exist, remove it.
    }
}
