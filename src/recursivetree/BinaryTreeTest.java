package recursivetree;

/**
 * Test class for BinaryTree
 * 
 * @author G.J. Hu
 * @version 2025.08.08
 */

public class BinaryTreeTest extends student.TestCase
{
    private BinaryTree<String> binaryTree1;
    private BinaryTree<String> binaryTree2;
    private BinaryTree<String> binaryTree3;
    private BinaryTree<String> binaryTree4;
    private BinaryTree<String> binaryTree5;
    
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp() {
        binaryTree1 = new BinaryTree<>("A");
        binaryTree2 = new BinaryTree<>("B", null, binaryTree1);
        binaryTree3 = new BinaryTree<>("C", binaryTree1, null);
        binaryTree4 = new BinaryTree<>("D", binaryTree2, binaryTree3);
        binaryTree5 = new BinaryTree<>("E", binaryTree1, binaryTree4);
    }
    
    /**
     * Tests that the getElement() method returns the expected output
     */  
    public void testGetElement() {
        assertEquals("A", binaryTree1.getElement());
        
        assertEquals("C", binaryTree3.getElement());
        
        assertEquals("E", binaryTree5.getElement());
    }
    
    /**
     * Tests that the setElement() method returns the expected output
     */  
    public void testSetElement() {
        BinaryTree<String> bt1 = new BinaryTree<>("A");
        BinaryTree<String> bt2 = new BinaryTree<>("B", null, bt1);
        BinaryTree<String> bt3 = new BinaryTree<>("C", bt1, bt2);
        
        bt1.setElement("F");
        assertEquals("F", bt1.getElement());
        
        bt2.setElement("G");
        assertEquals("G", bt2.getElement());
        
        bt3.setElement("H");
        assertEquals("H", bt3.getElement());
    }
    
    /**
     * Tests that the getLeft() method returns the expected output
     */  
    public void testGetLeft() {
        assertNull(binaryTree2.getLeft());
        
        assertEquals(binaryTree1, binaryTree3.getLeft());
        assertEquals(binaryTree1, binaryTree5.getLeft());
        
        
    }
    
    /**
     * Tests that the setLeft() method returns the expected output
     */  
    public void testSetLeft() {
        BinaryTree<String> bt1 = new BinaryTree<>("A");
        BinaryTree<String> bt2 = new BinaryTree<>("B", null, bt1);
        BinaryTree<String> bt3 = new BinaryTree<>("C", bt1, bt2);
        BinaryTree<String> bt4 = new BinaryTree<>("D");
        BinaryTree<String> bt5 = new BinaryTree<>("E");
        
        bt1.setLeft(bt4);
        assertEquals(bt4, bt1.getLeft());
        
        bt2.setLeft(bt5);
        assertEquals(bt5, bt2.getLeft());
        
        bt3.setLeft(bt4);
        assertEquals(bt4, bt3.getLeft());
        
    }
    
    /**
     * Tests that the getRight() method returns the expected output
     */  
    public void testGetRight() {
        assertNull(binaryTree3.getRight());
        
        assertEquals(binaryTree3, binaryTree4.getRight());
        assertEquals(binaryTree4, binaryTree5.getRight());
    }
    
    /**
     * Tests that the setRight() method returns the expected output
     */  
    public void testSetRight() {
        BinaryTree<String> bt1 = new BinaryTree<>("A");
        BinaryTree<String> bt2 = new BinaryTree<>("B", bt1, null);
        BinaryTree<String> bt3 = new BinaryTree<>("C", bt1, bt2);
        BinaryTree<String> bt4 = new BinaryTree<>("D");
        BinaryTree<String> bt5 = new BinaryTree<>("E");
        
        bt1.setRight(bt4);
        assertEquals(bt4, bt1.getRight());
        
        bt2.setRight(bt5);
        assertEquals(bt5, bt2.getRight());
        
        bt3.setRight(bt4);
        assertEquals(bt4, bt3.getRight());

    }
    
    /**
     * Tests that the size() method returns the expected output
     */  
    public void testSize() {
        assertEquals(1, binaryTree1.size());
        
        assertEquals(2, binaryTree2.size());
        
        assertEquals(2, binaryTree3.size());
        
        assertEquals(5, binaryTree4.size());
        
        assertEquals(7, binaryTree5.size());
        
    }
    
    /**
     * Tests that the height() method returns the expected output
     */  
    public void testHeight() {
        assertEquals(1, binaryTree1.height());
        assertEquals(2, binaryTree2.height());
        assertEquals(2, binaryTree3.height());
        assertEquals(3, binaryTree4.height());
        assertEquals(4, binaryTree5.height());
    }
    
    /**
     * Tests that the toPreOrderString() method returns the expected output
     */  
    public void testToPreOrderString() {
        assertEquals("(A)", binaryTree1.toPreOrderString());
        assertEquals("(B(A))", binaryTree2.toPreOrderString());
        assertEquals("(C(A))", binaryTree3.toPreOrderString());
        assertEquals("(D(B(A))(C(A)))", binaryTree4.toPreOrderString());
        assertEquals("(E(A)(D(B(A))(C(A))))", binaryTree5.toPreOrderString());
        
    }
    
    /**
     * Tests that the toInOrderString() method returns the expected output
     */  
    public void testToInOrderString() {
        assertEquals("(A)", binaryTree1.toInOrderString());
        assertEquals("(B(A))", binaryTree2.toInOrderString());
        assertEquals("((A)C)", binaryTree3.toInOrderString());
        assertEquals("((B(A))D((A)C))", binaryTree4.toInOrderString());
        assertEquals("((A)E((B(A))D((A)C)))", binaryTree5.toInOrderString());
    }
    
    /**
     * Tests that the toPostOrderString() method returns the expected output
     */  
    public void testToPostOrderString() {
        assertEquals("(A)", binaryTree1.toPostOrderString());
        assertEquals("((A)B)", binaryTree2.toPostOrderString());
        assertEquals("((A)C)", binaryTree3.toPostOrderString());
        assertEquals("(((A)B)((A)C)D)", binaryTree4.toPostOrderString());
        assertEquals("((A)(((A)B)((A)C)D)E)", binaryTree5.toPostOrderString());
        
        
    }
    

}
