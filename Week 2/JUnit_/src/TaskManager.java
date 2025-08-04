// File: src/TaskManager.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple class to manage a list of tasks.
 * This is the class we are going to test.
 */
public class TaskManager {
    private List<String> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public boolean removeTask(String task) {
        return tasks.remove(task);
    }

    public List<String> getTasks() {
        // Return an unmodifiable list to prevent external changes.
        return Collections.unmodifiableList(tasks);
    }

    public void clear() {
        tasks.clear();
    }
}
