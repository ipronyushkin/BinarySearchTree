package ru.binary_serch_tree;

import org.junit.*;
import ru.binary_search_tree.*;

public class TreeMapTest {
    TreeMap tm = new TreeMap();

    @Test
    public void testEmptyTrue() {
        Assert.assertTrue(tm.isEmpty());
    }

    @Test
    public void testPut() {
        tm.put(1, 12);
        Assert.assertTrue(tm.containsKey(1));
        Assert.assertFalse(tm.containsKey(2));
        Assert.assertFalse(tm.isEmpty());
    }

    @Test
    public void testGetKey() {
        tm.put(10, "15");
        Assert.assertEquals(null, tm.get(15));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedMethod() {
        tm.clear();
    }
}
