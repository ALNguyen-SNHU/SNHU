// [DOCSTRING]
// Author: Andrew Nguyen + Claude (LIGHT ASSISTANCE)
// NOTE: The MAJORITY of the code was written by me with as apposed to the last assignment. I am more capable of writing Java code at this point. I am able to borrow examples off my last assignment.
// The AI would NOT autofill the examples he gave me. I had to put that information myself, run it, and find out why it broke.
// AI suggested 4 functions/methods. Not to combine update together. Can delete and add whole tasks, can only change desc and name. Suggested to separate update functions for name and desc.

import java.util.Map;       // We are assigning <string> keys to tasks in a dictionary/map
import java.util.HashMap;

// Purposely named it taskStorage. I'm going to get confused if something is named task and tasks. There's a one character difference that can be missed.
class TaskService{                                          // AI created the private map. I replaced the part that says "task storage"
    private Map<String, Task> taskStorage;                  // Although task ID's are unique, there's nothing preventing them from being overwritten. The purpose of the map/dictionary.

    public void addTask(Task task) {
      if (taskStorage.containsKey(task.getTaskID())) {      // If it contains the task, throw the error that it exists.
          throw new IllegalArgumentException("Task ID already exists.");
      }
      taskStorage.put(task.getTaskID(), task);              // .put == add to dictionary
  }

  public void deleteTask(Task task) {
      if (!taskStorage.containsKey(task.getTaskID())) {     // If it DOES NOT contain the task, throw the error that you can't delete what's not there.
          throw new IllegalArgumentException("Task ID non-existent.");
      }
      taskStorage.remove(task.getTaskID());                 // .remove == remove from dictionary. Don't need value. Just key.
  }

  public void modifyName(String taskID, String newName) {   // Must reference task ID and the name that follows it. (Key, new variable referring to the replacement name)
      if (!taskStorage.containsKey(taskID)) {               // If the task storage does not contain this ID... It don't exist.
          throw new IllegalArgumentException("Task ITSELF non-existent. There's no name to change.");
      }
      Task task = taskStorage.get(taskID);           // Find it in storage
      task.setName(newName);                         // Rename it in storage
  }

  public void modifyDesc(String taskID, String newDesc) {   // Must reference task ID and the description that follows it. (Key, new variable replacing the old Description)
      if (!taskStorage.containsKey(taskID)) {               // If the task storage does not contain this ID... It don't exist.
          throw new IllegalArgumentException("Task ITSELF non-existent. There's no description to change.");
      }
      Task task = taskStorage.get(taskID);           // Find it in storage
      task.setDesc(newDesc);                         // Change desc it in storage
  }

    public TaskService() {                           // AI told me I could put this at the top, but only mentioned this at the end.
      taskStorage = new HashMap<>();
  }
}