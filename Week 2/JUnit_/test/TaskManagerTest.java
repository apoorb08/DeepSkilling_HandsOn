package JUnit_.test;

// File: test/TaskManagerTest.java
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the TaskManager.
 * It demonstrates the Arrange-Act-Assert pattern, along with @Before and @After.
 */
public class TaskManagerTest {

    // This is the "Test Fixture". It's the common object we'll use in all our tests.
    private TaskManagerTest taskManager;

    /**
     * The @Before annotation tells JUnit to run this method before each and every @Test method.
     * It's perfect for setting up a clean state for each test.
     */
    @Before
    public void setUp() {
        System.out.println("--- Setting up for a new test ---");
        // We create a fresh TaskManager instance here to ensure tests are independent.
        taskManager = new TaskManagerTest();
    }

    /**
     * The @After annotation tells JUnit to run this method after each and every @Test method.
     * It's used for cleaning up resources, like closing files or database connections.
     */
    @After
    public void tearDown() {
        System.out.println("--- Tearing down the test ---");
        // Clean up to be tidy.
        taskManager.clear();
        taskManager = null;
    }

    private void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Test
    public void testAddTask() {
        System.out.println("Running test: testAddTask");

        // 1. Arrange: Set up the specific conditions for this test.
        // The taskManager is already created by setUp(). We just need a task name.
        String newTask = "Write unit tests";

        // 2. Act: Perform the action we want to test.
        taskManager.addTask(newTask);

        // 3. Assert: Verify that the outcome is what we expected.
        assertEquals("The task list should contain 1 task.", 1, taskManager.getTasks().size());
        assertTrue("The task list should contain the new task.", taskManager.getTasks().contains(newTask));
    }

    private void addTask(String newTask) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTask'");
    }

    @Test
    public void testRemoveTask() {
        System.out.println("Running test: testRemoveTask");

        // 1. Arrange: Add a task first so we have something to remove.
        String taskToRemove = "A task to be removed";
        taskManager.addTask(taskToRemove);
        // Quick check to make sure our arrangement is correct.
        assertEquals("Arrange failed: Task was not added.", 1, taskManager.getTasks().size());

        // 2. Act: Perform the removal.
        boolean result = taskManager.removeTask(taskToRemove);

        // 3. Assert: Check if the removal was successful and the list is empty.
        assertTrue("removeTask should return true for a successful removal.", result);
        assertEquals("The task list should be empty after removal.", 0, ((List<String>) taskManager.getTasks()).size());
    }

    private java.util.List<String> getTasks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTasks'");
    }

    private boolean removeTask(String taskToRemove) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTask'");
    }
}
