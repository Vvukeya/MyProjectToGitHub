/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portfolio.file.poe.part3;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Tasks {
    String status1 = "To Do";
    String status2 = "Doing";
    String status3 = "Done";

    // Check if task description is valid (for simplicity, assume any non-empty description is valid)
    public boolean checkTaskDescription(String description) {
        return description != null && !description.trim().isEmpty();
    }

    // Create a unique task ID based on task number, task name, and developer name
    public String createTaskID(int taskNumber, String taskName, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(0, 2).toUpperCase();
    }

    // Print task details
    public String printTaskDetails(int taskNumber, String status, String developer, String taskName, String description, String taskID, int duration) {
        return String.format("""
                Task Details:
                Task Number: %d
                Task Name: %s
                Developer: %s
                Task ID: %s
                Task Status: %s
                Task Description: %s
                Task Duration: %d hrs
                """, taskNumber, taskName, developer, taskID, status, description, duration);
    }

    // Calculate total hours of all tasks
    public int returnTotalHours(int[] duration) {
        int total = 0;
        for (int d : duration) {
            total += d;
        }
        return total;
    }

    // Generate a report of all tasks
    public void report(int numOfTasks, int[] taskNumber, String[] status, String[] developer, String[] taskName, String[] description, String[] taskID, int[] duration) {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (int i = 0; i < numOfTasks; i++) {
            if (taskName[i] != null) {
                report.append(printTaskDetails(taskNumber[i], status[i], developer[i], taskName[i], description[i], taskID[i], duration[i]));
                report.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    // Show all tasks that are done
    public void doneTasks(int numOfTasks, String[] status, String[] developer, String[] taskName, int[] duration) {
        StringBuilder doneTasks = new StringBuilder("Done Tasks:\n");
        for (int i = 0; i < numOfTasks; i++) {
            if ("Done".equals(status[i])) {
                doneTasks.append(String.format("Task Name: %s, Developer: %s, Duration: %d hrs\n", taskName[i], developer[i], duration[i]));
            }
        }
        JOptionPane.showMessageDialog(null, doneTasks.toString());
    }

    // Find the longest task
    public void longest(int numOfTasks, int[] duration, String[] developer) {
        int maxDuration = 0;
        String developerName = "";
        for (int i = 0; i < numOfTasks; i++) {
            if (duration[i] > maxDuration) {
                maxDuration = duration[i];
                developerName = developer[i];
            }
        }
        JOptionPane.showMessageDialog(null, "The longest task is by " + developerName + " with a duration of " + maxDuration + " hrs");
    }

    // Search for task by task name
    public void searchTask(int numOfTasks, String[] taskName, String[] developer, String[] status) {
        String search = JOptionPane.showInputDialog("Enter the task name to search");
        StringBuilder result = new StringBuilder("Search Results:\n");
        boolean found = false;
        for (int i = 0; i < numOfTasks; i++) {
            if (taskName[i] != null && taskName[i].contains(search)) {
                result.append(String.format("Task Name: %s, Developer: %s, Status: %s\n", taskName[i], developer[i], status[i]));
                found = true;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No task found with the given name");
        } else {
            JOptionPane.showMessageDialog(null, result.toString());
        }
    }

    // Search for task by developer name
    public void searchDev(int numOfTasks, String[] taskName, String[] developer, String[] status) {
        String search = JOptionPane.showInputDialog("Enter the developer name to search");
        StringBuilder result = new StringBuilder("Search Results:\n");
        boolean found = false;
        for (int i = 0; i < numOfTasks; i++) {
            if (developer[i] != null && developer[i].contains(search)) {
                result.append(String.format("Task Name: %s, Developer: %s, Status: %s\n", taskName[i], developer[i], status[i]));
                found = true;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No task found with the given developer name");
        } else {
            JOptionPane.showMessageDialog(null, result.toString());
        }
    }
    
}
