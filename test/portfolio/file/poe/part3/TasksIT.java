/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package portfolio.file.poe.part3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TasksIT {
     private Tasks instance;
    private String[] developers;
    private String[] taskNames;
    private int[] durations;
    private String[] statuses;
    private int numOfTasks;
    private int[] taskNumbers;
    private String[] descriptions;
    private String[] taskIDs;
    
    public TasksIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Tasks();
        developers = new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        taskNames = new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        durations = new int[]{5, 8, 2, 11};
        statuses = new String[]{"To Do", "Doing", "Done", "To Do"};
        numOfTasks = 4;
        taskNumbers = new int[]{1, 2, 3, 4};
        descriptions = new String[]{"Login module", "Add feature module", "Reports module", "Arrays module"};
        taskIDs = new String[]{"CLS1", "CAF2", "CRP3", "AA4"};
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkTaskDescription method, of class Tasks.
     */
    @Test
    public void testCheckTaskDescription() {
         System.out.println("checkTaskDescription");
        String description = "Valid task description";
        boolean expResult = true;
        boolean result = instance.checkTaskDescription(description);
        assertEquals(expResult, result);

        description = "";
        expResult = false;
        result = instance.checkTaskDescription(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of createTaskID method, of class Tasks.
     */
    @Test
    public void testCreateTaskID() {
       System.out.println("createTaskID");
        int taskNumber = 1;
        String taskName = "Create Login";
        String developer = "Mike Smith";
        String expResult = "CL1S";
        String result = instance.createTaskID(taskNumber, taskName, developer);
        assertEquals(expResult, result);

        taskNumber = 4;
        taskName = "Add Arrays";
        developer = "Glenda Oberholzer";
        expResult = "AA4O";
        result = instance.createTaskID(taskNumber, taskName, developer);
        assertEquals(expResult, result);
    }

    /**
     * Test of printTaskDetails method, of class Tasks.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        int taskNumber = 1;
        String status = "To Do";
        String developer = "Mike Smith";
        String taskName = "Create Login";
        String description = "Login module";
        String taskID = "CLS1";
        int duration = 5;
        String expResult = "Task ID: CLS1\nTask Name: Create Login\nTask Number: 1\nTask Developer: Mike Smith\nTask Duration: 5\nTask Description: Login module\nTask Status: To Do";
        String result = instance.printTaskDetails(taskNumber, status, developer, taskName, description, taskID, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnTotalHours method, of class Tasks.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        int[] duration = {5, 8, 2, 11};
        int expResult = 26;
        int result = instance.returnTotalHours(duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of report method, of class Tasks.
     */
    @Test
    public void testReport() {
         System.out.println("report");
        // Assuming the report method prints the report to the console or logs it
        instance.report(numOfTasks, taskNumbers, statuses, developers, taskNames, descriptions, taskIDs, durations);
        // Add specific assertions based on the actual implementation of report method
        // For example, if the report method returns a String, you can assert its content here
    }

    /**
     * Test of doneTasks method, of class Tasks.
     */
    @Test
    public void testDoneTasks() {
        System.out.println("doneTasks");
        // Assuming doneTasks method processes tasks with status "Done"
        instance.doneTasks(numOfTasks, statuses, developers, taskNames, durations);
        // Add specific assertions based on the actual implementation of doneTasks method
        // For example, verify tasks with "Done" status are processed correctly
    }

    /**
     * Test of longest method, of class Tasks.
     */
    @Test
    public void testLongest() {
       System.out.println("longest");
        // Assuming the longest method identifies the task with the longest duration
        instance.longest(numOfTasks, durations, developers);
        // Add specific assertions based on the actual implementation of longest method
        // For example, verify the correct task and developer are identified as having the longest duration
    }

    /**
     * Test of searchTask method, of class Tasks.
     */
    @Test
    public void testSearchTask() {
        System.out.println("searchTask");
        // Assuming searchTask method searches tasks by name
        instance.searchTask(numOfTasks, taskNames, developers, statuses);
        // Add specific assertions based on the actual implementation of searchTask method
        // For example, verify the correct tasks are found based on the search criteria
    }

    /**
     * Test of searchDev method, of class Tasks.
     */
    @Test
    public void testSearchDev() {
         System.out.println("searchDev");
        // Assuming searchDev method searches tasks by developer
        instance.searchDev(numOfTasks, taskNames, developers, statuses);
        // Add specific assertions based on the actual implementation of searchDev method
        // For example, verify the correct tasks are found based on the search criteria
    }
    
}
