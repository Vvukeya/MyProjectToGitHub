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
public class User {
     public String firstName;
    public String surname;
    public String userName;
    public String password;
    public String enteredUserName;
    public String enteredPassword;

    public boolean checkUsername() {
        boolean check = false;
        if (userName.length() <= 5) {
            for (int i = 0; i < userName.length(); i++) {
                if (userName.charAt(i) == '_') {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public boolean checkPasswordComplexity() {
        boolean capitalLetter = false;
        boolean number = false;
        boolean special = false;
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    capitalLetter = true;
                }
                if (Character.isDigit(password.charAt(i))) {
                    number = true;
                }
                if (!Character.isLetterOrDigit(password.charAt(i))) {
                    special = true;
                }
            }
        }
        return capitalLetter && number && special;
    }

    public void registerUser() {
        if (checkUsername()) {
            JOptionPane.showMessageDialog(null, "Username successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your Username contains an underscore and is no more than 5 characters in length.");
        }
        if (checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "Password successfully captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }
        if (checkUsername() && checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "The two above conditions have been met and the user has been registered successfully.");
        }
    }

    public boolean loginUser() {
        return userName.equals(enteredUserName) && password.equals(enteredPassword);
    }

    public void returnLoginStatus() {
        if (loginUser()) {
            JOptionPane.showMessageDialog(null, "Successful login\nWelcome " + firstName + " " + surname + ", it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "A failed login\nUsername or Password incorrect. Please try again.");
        }
    }
    
}
