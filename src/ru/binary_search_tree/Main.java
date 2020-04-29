package ru.binary_search_tree;

public class Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(2, 11);
        tree.add(4, 12);
        tree.add(8, 13);
        tree.add(9, 14);
        tree.add(10, 15);
        tree.add(1, 15);
        tree.add(22, "Hello!");
        tree.preorder();
        tree.removeNode(9);
        System.out.println();
        tree.preorder();
        Node test = tree.get(1);
        System.out.println(test.value);
        System.out.println(tree.containsKey("1"));

        TreeMap testTree = new TreeMap();
        System.out.println(testTree.isEmpty());
        testTree.put(1, 12);
        System.out.println(testTree.isEmpty());
        System.out.println(testTree.containsKey(1));
        System.out.println(testTree.containsKey(2));
        System.out.println(testTree.get(2));

    }
}
