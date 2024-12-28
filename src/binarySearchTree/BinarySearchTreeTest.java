package binarySearchTree;

import student.TestCase;

/**
 * TestCases to test everything in BinarySearchTree Class
 * @author Navanit Krishna Satish Kumar
 * @version 12.06.2024
 */
public class BinarySearchTreeTest extends TestCase {
    private Lab14BinarySearchTree<Integer> testTree;
    private Lab14BinarySearchTree<Integer> emptyCase;
    
    /**
     * Setup for test cases
     */
    public void setUp() {
        testTree = new Lab14BinarySearchTree<Integer>();
        emptyCase = new Lab14BinarySearchTree<Integer>();
        
        testTree.insert(5);
        testTree.insert(3);
        testTree.insert(7);
        testTree.insert(1);
        testTree.insert(4);
        testTree.insert(6);
        testTree.insert(8);
    }
    
    /**
     * Tests insert method
     */
    public void testInsert() {        
        Exception excep = null;
        try {
            testTree.insert(1);
        }
        catch (Exception e) {
            excep = e;
        }
        assertNotNull(excep);
        
        emptyCase.insert(5);
        assertEquals(emptyCase.toString(), "(5)");
        
        Lab14BinarySearchTree<Integer> multiTree = 
                new Lab14BinarySearchTree<>();
        multiTree.insert(5);
        multiTree.insert(3);
        multiTree.insert(7);
        assertEquals("(3, 5, 7)", multiTree.toString());
    }
    
    /**
     * Tests remove method
     */
    public void testRemove() {
        testTree.remove(1);
        assertNull(testTree.find(1));
        testTree.remove(8);
        assertNull(testTree.find(8));
        
        Lab14BinarySearchTree<Integer> oneChildTree = 
                new Lab14BinarySearchTree<>();
        oneChildTree.insert(5);
        oneChildTree.insert(3);
        oneChildTree.insert(2);
        oneChildTree.remove(3);
        assertEquals(Integer.valueOf(2), oneChildTree.find(2), 0.01);
        
        oneChildTree = new Lab14BinarySearchTree<>();
        oneChildTree.insert(5);
        oneChildTree.insert(7);
        oneChildTree.insert(8);
        oneChildTree.remove(7);
        assertEquals(Integer.valueOf(8), oneChildTree.find(8), 0.01);
        
        Lab14BinarySearchTree<Integer> rootTree = 
                new Lab14BinarySearchTree<>();
        rootTree.insert(5);
        rootTree.insert(3);
        rootTree.insert(7);
        rootTree.remove(5);
        assertNull(rootTree.find(5));
        assertEquals("(3, 7)", rootTree.toString());
        
        Lab14BinarySearchTree<Integer> complexTree = 
                new Lab14BinarySearchTree<>();
        complexTree.insert(10);
        complexTree.insert(5);
        complexTree.insert(15);
        complexTree.insert(3);
        complexTree.insert(7);
        complexTree.insert(12);
        complexTree.insert(17);
        complexTree.insert(13);
        
        complexTree.remove(15);
        assertNull(complexTree.find(15));
        assertEquals(Integer.valueOf(17), complexTree.find(17), 0.01);
        assertEquals("(3, 5, 7, 10, 12, 13, 17)", complexTree.toString());
    }
    
    /**
     * Tests remove method's edge cases
     */
    public void testRemoveEdgeCases() {
        Exception excep = null;
        try {
            emptyCase.remove(1);
        }
        catch (ItemNotFoundException e) {
            excep = e;
        }
        assertNotNull(excep);
        
        excep = null;
        try {
            testTree.remove(100);
        }
        catch (ItemNotFoundException e) {
            excep = e;
        }
        assertNotNull(excep);
        
        testTree.remove(1);
        testTree.remove(3);
        testTree.remove(4);
        testTree.remove(5);
        testTree.remove(6);
        testTree.remove(7);
        testTree.remove(8);
        assertTrue(testTree.isEmpty());
    }
    
    /**
     * Tests findMin method
     */
    public void testFindMin() {
        assertEquals(Integer.valueOf(1), testTree.findMin(), 0.01);
        assertNull(emptyCase.findMin());
        emptyCase.insert(9);
        assertEquals(Integer.valueOf(9), emptyCase.findMin(), 0.01);
    }
    
    /**
     * Tests findMax method
     */
    public void testFindMax() {
        assertEquals(Integer.valueOf(8), testTree.findMax(), 0.01);
        assertNull(emptyCase.findMax());
        emptyCase.insert(9);
        assertEquals(Integer.valueOf(9), emptyCase.findMax(), 0.01);
    }
    
    /**
     * Tests find method
     */
    public void testFind() {
        assertEquals(Integer.valueOf(5), testTree.find(5), 0.01);
        assertEquals(Integer.valueOf(3), testTree.find(3), 0.01);
        assertEquals(Integer.valueOf(7), testTree.find(7), 0.01);
        assertNull(testTree.find(9));
        assertNull(emptyCase.find(10));
    }
    
    /**
     * Tests makeEmpty method
     */
    public void testMakeEmpty() {
        assertFalse(testTree.isEmpty());
        testTree.makeEmpty();
        assertTrue(testTree.isEmpty());
    }
    
    /**
     * Tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(emptyCase.isEmpty());
        assertFalse(testTree.isEmpty());
    }
    
    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals("(1, 3, 4, 5, 6, 7, 8)", testTree.toString());
        assertEquals("()", emptyCase.toString());
    }
}
