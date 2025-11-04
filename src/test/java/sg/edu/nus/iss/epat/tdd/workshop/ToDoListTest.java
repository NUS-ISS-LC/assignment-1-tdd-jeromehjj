package sg.edu.nus.iss.epat.tdd.workshop;

import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.fail;

public class ToDoListTest  {
    // Define Test Fixtures
    private ToDoList toDoList;
    private Task t1, t2;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        t1 = new Task("Test 1", false);
        t2 = new Task("Test 2", false);
        toDoList = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        t1 = null;
        t2 = null;
        toDoList = null;
    }

    @Test
    public void testAddTask() {
        toDoList.addTask(t1);

        // Test that the task list is not empty
        assertFalse(toDoList.getAllTasks().isEmpty());

        // Test that the task in list is same as t1
        assertEquals(toDoList.getTask(t1.getDescription()), t1);
    }

    @Test
    public void testGetStatus() {
        toDoList.addTask(t1);
        toDoList.addTask(t2);

        // Test the status of t1
        assertEquals(t1.isComplete(), toDoList.getStatus(t1.getDescription()));

        // Test if the status of t2 is indeed false
        assertFalse(toDoList.getStatus(t2.getDescription()));
    }

    @Test
    public void testRemoveTask() {
        toDoList.addTask(t2);
        toDoList.removeTask(t2.getDescription());

        // Test that the task list is indeed empty after removing
        assertTrue(toDoList.getAllTasks().isEmpty());
    }

    @Test
    public void testGetCompletedTasks() {
        toDoList.addTask(t1);
        toDoList.addTask(t2);
        toDoList.completeTask("Test 2");

        // Test that number of completed tasks is 1
        assertEquals(1, toDoList.getCompletedTasks().size());

        // Test that the completed task is 2
        assertEquals(t2, toDoList.getCompletedTasks().iterator().next());
    }
}