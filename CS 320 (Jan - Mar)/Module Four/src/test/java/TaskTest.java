// [DOCSTRING]
// Author: Andrew Nguyen + Claude (LIGHT ASSISTANCE)
// NOTE: The MAJORITY of the code was written by me with as apposed to the last assignment. I am more capable of writing Java code at this point. I am able to borrow examples off my last assignment.
// The AI would NOT autofill the examples he gave me. I had to put that information myself, run it, and find out why it broke. AI does all imports.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {
    Task task = new Task("1999", "SlimShady", "Who's the real one?");
    
    // Happy Path
    @Test
    void testTaskCreation() {
        assertEquals("1999", task.getTaskID());
        assertEquals("SlimShady", task.getName());
        assertEquals("Who's the real one?", task.getDesc());
    }

    @Test
    void testSetNameValid() {
        task.setName("Marshall Mathers");
        assertEquals("Marshall Mathers", task.getName());
    }

    @Test
    void testSetDescValid() {
        task.setDesc("This is an Eminem Song.");
        assertEquals("This is an Eminem Song.", task.getDesc());
    }


    
    // Sad Path
    // Set null
    @Test
    void testSetNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    void testSetDescNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDesc(null);
        });
    }

    @Test
    void testSetNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("ThisNameIsWayTooLongForTheLimit");
        });
    }

    @Test
    void testSetDescTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDesc("This description is way too long and exceeds the fifty character limit");
        });
    }



    @Test
    void testTaskIdExceeds() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("199999999999", "SlimShady", "Who's the real one?");
        });
    }
    
    @Test
    void testNameExceeds() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1999", "HiMyNameIs,What?,MyNameIs,Who?SlimShady", "Who's the real one?");
        });
    }

    @Test
    void testDescExceeds() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1999", "SlimShady", "Eminem's 'The Real Slim Shady' asks who the real one is - 2000 hit");
        });
    }

    @Test
    void testTaskNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "SlimShady", "Who's the real one?");
        });
    }

    @Test
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1999", null, "Who's the real one?");
        });
    }

    @Test
    void testDescNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1999", "SlimShady", null);
        });
    }
}