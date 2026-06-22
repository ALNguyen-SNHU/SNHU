// [DOCSTRING]
// Author: Andrew Nguyen + Claude (LIGHT ASSISTANCE)
// NOTE: The MAJORITY of the code was written by me with as apposed to the last assignment. I am more capable of writing Java code at this point. I am able to borrow examples off my last assignment.
// The AI would NOT autofill the examples he gave me. I had to put that information myself, run it, and find out why it broke. AI does all imports.

// Stub out task parameters. A SINGULAR task must contain an ID, name, and description of the task.
public class Task {
    private String taskID;
    private String name;
    private String description;

    // None of the parameters can be null. 
    public Task(String taskID, String name, String description){    // AI created the first IF statement without autofilling logic.
        if (taskID == null || taskID.length() > 10) {           // A task ID cannot be greater than 10 characters.
            throw new IllegalArgumentException("ID No longer than 10, no less than 0.");
        }
        if (name == null || name.length() > 20) {               // Name cannot be greater than 20.
            throw new IllegalArgumentException("Name(s) no longer than 20, no less than 0.");
        }
        if (description == null || description.length() > 50) { // Description can't be greater than 50.
            throw new IllegalArgumentException("Description no longer than 50, no less than 0.");
        }

        // This is file specific. Referring to the variables within this file and ONLY this file with these names.
        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }
    
    // The Mutators and Accessors use these (this.)variables within this file and only this file.
    // Setter (with validation):
    public void setName(String name) {              // AI created this first setter without autofilling logic.
      if (name == null || name.length() > 20) {
          throw new IllegalArgumentException("Cannot be empty. Cannot be longer than 20.");
      }
      this.name = name;
  }
  
  // Setter (with validation):
    public void setDesc(String desc) {
      if (desc == null || desc.length() > 50) {
          throw new IllegalArgumentException("Cannot be empty. Cannot be longer than 50.");
      }
      this.description = desc;
  }

  // Getter:                // AI created the first getter.
  public String getTaskID() {
      return taskID;
  }

  // Getter:
  public String getName() {
      return name;
  }

  // Getter:
  public String getDesc() {
      return description;
  }
}
