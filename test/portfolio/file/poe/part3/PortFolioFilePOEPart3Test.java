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
public class PortFolioFilePOEPart3Test {
    
    public PortFolioFilePOEPart3Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class PortFolioFilePOEPart3.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PortFolioFilePOEPart3.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choices method, of class PortFolioFilePOEPart3.
     */
    @Test
    public void testChoices() {
        System.out.println("choices");
        String choice = "";
        PortFolioFilePOEPart3.choices(choice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTasks method, of class PortFolioFilePOEPart3.
     */
    @Test
    public void testAddTasks() {
        System.out.println("addTasks");
        PortFolioFilePOEPart3.addTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PortFolioFilePOEPart3.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        PortFolioFilePOEPart3.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class PortFolioFilePOEPart3.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        User user = null;
        PortFolioFilePOEPart3.register(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class PortFolioFilePOEPart3.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        User user = null;
        boolean expResult = false;
        boolean result = PortFolioFilePOEPart3.login(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
