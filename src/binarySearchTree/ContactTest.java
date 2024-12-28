package binarySearchTree;

import student.TestCase;

/**
 * Test Class to test methods of Contact Class
 * @author Navanit Krishna Satish Kumar
 * @version 12.06.2024
 */
public class ContactTest extends TestCase {
    private Contact contact;
    private Contact contactAFirst;
    private Contact contactCFirst;
    private Contact contactALast;
    private Contact contactCLast;
    private Contact contactLowerNum;
    private Contact contactHigherNum;
    private Contact identical;
    private Contact nullContact;
    
    /**
     * Setup for running tests
     */
    public void setUp() {
        contact = new Contact("b", "b", 50);
        contactAFirst = new Contact("a", "b", 50);
        contactCFirst = new Contact("c", "b", 50);
        contactALast = new Contact("b", "a", 50);
        contactCLast = new Contact("b", "c", 50);
        contactLowerNum = new Contact("b", "b", 25);
        contactHigherNum = new Contact("b", "b", 75);
        identical = new Contact("b", "b", 50);
        nullContact = null;
    }
    
    /**
     * testing CompareTo method
     */
    public void testCompareTo() {
        assertEquals(contact.compareTo(contact), 0, 0.01);
        assertEquals(contact.compareTo(identical), 0, 0.01);
        assertTrue(contact.compareTo(contactAFirst) > 0);
        assertTrue(contact.compareTo(contactALast) > 0);
        assertTrue(contact.compareTo(contactLowerNum) > 0);
        assertTrue(contact.compareTo(contactCFirst) < 0);
        assertTrue(contact.compareTo(contactCLast) < 0);
        assertTrue(contact.compareTo(contactHigherNum) < 0);
        assertTrue(contact.compareTo(nullContact) > 0);
    }
}


