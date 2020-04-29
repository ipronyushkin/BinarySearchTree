package ru.binary_serch_tree;

import org.junit.*;
import ru.binary_search_tree.BinarySearchTree;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();

    @Before
    public void init() throws Exception {
        bst.add(2 ,"2");
        bst.add(1 ,"1");
        bst.add(4 ,"4");
        bst.add(8 ,"8");
        bst.add(9 ,"9");
        bst.add(10 ,"10");
    }

    @Test
    public void testRemoveNode(){
        Assert.assertTrue(bst.containsKey(9));
        Assert.assertEquals("9", bst.getValue(9));
        bst.removeNode(9);
        Assert.assertFalse(bst.containsKey(9));
    }

    @Test(expected = Exception.class)
    public void testUniqueKey() throws Exception {
        bst.add(9, "9");
    }
}
