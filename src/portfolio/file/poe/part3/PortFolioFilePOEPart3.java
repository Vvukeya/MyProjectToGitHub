/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package portfolio.file.poe.part3;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class PortFolioFilePOEPart3 {

    /**
     * @param args the command line arguments
     */
    static Tasks t = new Tasks();
    static boolean tasksAdded = false;
    static int numOfTasks;
    static String[] taskName, description, developer, taskID, status;
    static int[] taskNumber, duration;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        User user = new User();
        boolean loggedIn = false;
        boolean registered = false;

        while (true) {
            String initialChoice = JOptionPane.showInputDialog("""
                    Option 1) Register
                    Option 2) Login
                    Option 3) Quit""");

            if (initialChoice.equals("1")) {
                register(user);
                registered = true;
            } else if (initialChoice.equals("2")) {
                if (!registered) {
                    JOptionPane.showMessageDialog(null, "Register first!");
                    continue;
                }
                loggedIn = login(user);
                if (!loggedIn) {
                    continue; // Re-prompt for login if unsuccessful
                }
            } else if (initialChoice.equals("3")) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please select 1, 2, or 3.");
                continue;
            }

            // Once logged in, break out of the initial loop
            if (loggedIn) {
                break;
            }
        }

        // After successful login, proceed to task management loop
        while (true) {
            String choice = JOptionPane.showInputDialog("""
                    Option 1) Add tasks
                    Option 2) Show report
                    Option 3) View all Done tasks
                    Option 4) Longest task
                    Option 5) Search for task by task name
                    Option 6) Search for task by developer name
                    Option 7) Delete a task
                    Option 8) Quit""");

            if (choice.equals("8")) {
                System.exit(0);
            }

            if (!tasksAdded && !choice.equals("1")) {
                JOptionPane.showMessageDialog(null, "Add tasks first!");
                continue;
            }

            if (!choice.equals("1") && tasksAdded) {
                choices(choice);
            }

            if (choice.equals("1") && tasksAdded) {
                String choice2 = JOptionPane.showInputDialog("You have already added tasks!\n" +
                        "Do you want to add different ones?\nOption 1) Yes\nOption 2) No");
                if (choice2.equals("1")) {
                    addTasks();
                }
            } else if (choice.equals("1") && !tasksAdded) {
                addTasks();
            }
        }
    }

    public static void choices(String choice) {
        switch (choice) {
            case "2" -> t.report(numOfTasks, taskNumber, status, developer, taskName, description, taskID, duration);
            case "3" -> t.doneTasks(numOfTasks, status, developer, taskName, duration);
            case "4" -> t.longest(numOfTasks, duration, developer);
            case "5" -> t.searchTask(numOfTasks, taskName, developer, status);
            case "6" -> t.searchDev(numOfTasks, taskName, developer, status);
            case "7" -> delete();
            case "8" -> System.exit(0);
        }
    }

    public static void addTasks() {
        numOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks you wish to enter"));
        taskName = new String[numOfTasks];
        description = new String[numOfTasks];
        developer = new String[numOfTasks];
        taskID = new String[numOfTasks];
        status = new String[numOfTasks];
        taskNumber = new int[numOfTasks];
        duration = new int[numOfTasks];

        for (int i = 0; i < numOfTasks; i++) {
            taskName[i] = JOptionPane.showInputDialog("Enter the name of the " + (i + 1) + " task");
            taskNumber[i] = i;
            String temp;
            do {
                temp = JOptionPane.showInputDialog("Enter task description");
            } while (!t.checkTaskDescription(temp));
            description[i] = temp;
            developer[i] = JOptionPane.showInputDialog("Enter developer name");
            duration[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter duration of task in hours"));
            taskID[i] = t.createTaskID(i, taskName[i], developer[i]);
            temp = JOptionPane.showInputDialog("Option 1) " + t.status1 + "\n" +
                    "Option 2) " + t.status2 + "\n" +
                    "Option 3) " + t.status3 + "\n");
            switch (temp) {
                case "1" -> status[i] = t.status1;
                case "2" -> status[i] = t.status2;
                case "3" -> status[i] = t.status3;
            }
            JOptionPane.showMessageDialog(null, t.printTaskDetails(taskNumber[i], status[i], developer[i], taskName[i], description[i], taskID[i], duration[i]));
        }
        JOptionPane.showMessageDialog(null, "The total number of hours across all tasks is: " + t.returnTotalHours(duration) + "hrs");
        tasksAdded = true;
    }

    public static void delete() {
        String search = JOptionPane.showInputDialog("Enter the name of the task you want to delete");
        boolean flag = false;
        for (int i = 0; i < numOfTasks; i++) {
            if (search.equals(taskName[i])) {
                taskName[i] = null;
                description[i] = null;
                developer[i] = null;
                taskID[i] = null;
                status[i] = null;
                taskNumber[i] = 0;
                duration[i] = 0;
                flag = true;
            }
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null, "The task you entered can't be found!");
        } else {
            JOptionPane.showMessageDialog(null, "Done!");
        }
    }

    // Helper methods for registration and login
    public static void register(User user) {
        JOptionPane.showMessageDialog(null, "*Register*");

        user.firstName = JOptionPane.showInputDialog("Enter First Name:");
        user.surname = JOptionPane.showInputDialog("Enter Last Name:");
        user.userName = JOptionPane.showInputDialog("Enter Username:");
        user.password = JOptionPane.showInputDialog("Enter Password:");

        user.registerUser();

        while (!user.checkUsername() || !user.checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "Try to register again!!");
            user.userName = JOptionPane.showInputDialog("Enter Username:");
            user.password = JOptionPane.showInputDialog("Enter Password:");
            user.registerUser();
        }
    }

    public static boolean login(User user) {
        JOptionPane.showMessageDialog(null, "*Login*");

        user.enteredUserName = JOptionPane.showInputDialog("Enter Username:");
        user.enteredPassword = JOptionPane.showInputDialog("Enter Password:");

        user.returnLoginStatus();

        while (!user.loginUser()) {
            JOptionPane.showMessageDialog(null, "Try to Login again!!!");
            user.enteredUserName = JOptionPane.showInputDialog("Enter Username:");
            user.enteredPassword = JOptionPane.showInputDialog("Enter Password:");
            user.returnLoginStatus();
        }

        return true;
    }
    
}
