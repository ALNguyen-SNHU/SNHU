// [DOCSTRING]
// Author: Andrew Nguyen + Claude (LIGHT ASSISTANCE)
// NOTE: The MAJORITY of the code was written by me with as apposed to the last assignment. I am more capable of writing Java code at this point. I am able to borrow examples off my last assignment.
// The AI would NOT autofill the examples he gave me. I had to put that information myself, run it, and find out why it broke. AI does all imports.

package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    // Happy path
    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task1 = new Task("1999", "SlimShady", "The real one");
        
        // Add a task
        service.addTask(task1);
        
        // Can't add the same ID again if it worked the first time.
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("1999", "NotSlimShady", "NotTheRealSlimShady"));
        });
    }

    @Test
    void testDelete() {
        TaskService service = new TaskService();
        Task task1 = new Task("1999", "SlimShady", "The real one");
        
        // Task must exist to be deleted
        service.addTask(task1);
        // Test deleting the task
        service.deleteTask(task1);


        // If we can re-add it, it got deleted properly.
        service.addTask(new Task("1999", "Marshal Mathers", "Eminem's REAL name"));
    }

    @Test
    void testModifyName() {
        TaskService service = new TaskService();
        Task task1 = new Task("1999", "SlimShady", "The real one");
        
        // Task must exist to be modified
        service.addTask(task1);
        
        // Rename Slim Shady to Eminem's real name
        service.modifyName("1999", "Marshall Mathers");
        
        // See if his name changed.
        assertEquals("Marshall Mathers", task1.getName());
    }

    @Test
    void testModifyDesc() {
        TaskService service = new TaskService();
        Task task1 = new Task("1999", "RealSlimShady", "The fake one");

        // Add the real slim shady with a "fake" description
        service.addTask(task1);

        // This is the REAL Slim Shady.
        service.modifyDesc("1999", "The real one.");

        // This is the REAL slim shady after all.
        assertEquals("The real one.", task1.getDesc());
    }

    // Sad Path
    @Test
    void testAddDuplicateTask() {                   // AI stubbed out this one.
        TaskService service = new TaskService();
        Task task1 = new Task("1999", "SlimShady", "The real one");
        
        // Should not be able to add another task with the same ID.
        service.addTask(task1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("1999", "Not-So-Slim Shady", "The fat one."));
        });
    }

    @Test
    void testDeleteNonExistent() {
        TaskService service = new TaskService();
        Task task1 = new Task("1999", "SlimShady", "The real one");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask(task1);
        });
    }

    @Test
    void testModifyNameNonExistent() {          // AI stubbed out this test. No autofill.
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.modifyName("9999", "No task to name here.");
        });
    }

    @Test
    void testModifyDescNonExistent() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.modifyDesc("9999", "This should not be here.");
        });
    }
}