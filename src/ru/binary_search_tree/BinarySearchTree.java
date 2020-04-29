package ru.binary_search_tree;

class Node<K extends Comparable<K>, V> {
    Node left;
    Node right;
    V value;
    K key;
    int height;

    Node(K k, V v) {
        right = left = null;
        value = v;
        key = k;
        height = 1;
    }

    public int compareTo(K o) throws ClassCastException{
        return (key).compareTo(o);
    }
}

public class BinarySearchTree<K, V> {
    Node root;

    public BinarySearchTree() { root = null;}

    private int height(Node p) {
        if (p != null) { return p.height; }
        else { return 0; }
    }

    private int balanceFactor(Node p) { return height(p.right) - height(p.left); }

    private void fixHeight(Node p) {
        if (height(p.left) > height(p.right)) {
            p.height = height(p.left) + 1;
        } else {
            p.height = height(p.right) + 1;
        }
    }

    private Node rightRotate(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    private Node leftRotate(Node q) {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    private Node balance(Node p) {
        fixHeight(p);
        if (balanceFactor(p) == 2) {
            if (balanceFactor(p.right) < 0) {
                p.right = rightRotate(p.right);
            }
            return leftRotate(p);
        }
        if (balanceFactor(p) == -2) {
            if (balanceFactor(p.left) > 0) {
                p.left = leftRotate(p.left);
            }
            return rightRotate(p);
        }
        return p;
    }

    public Node add(Node p, Object k, Object o) throws Exception {
        if (p == null) {
            p =  new Node((Comparable) k, o);
        } else {
            int cmp = p.compareTo((Comparable) k);
            if (cmp > 0) {
                p.left = add(p.left, k, o);
            } else if (cmp < 0){
                p.right = add(p.right, k, o);
            } else {
                throw new Exception("This key was already in the tree!");
            }
        }
        return balance(p);
    }

    public void add(K k, Object o) throws Exception {
        root = add(root, k, o);
    }

    private Node findMin(Node p) {
        if (p.left != null) {
            return findMin(p.left);
        } else {
            return p;
        }
    }

    private Node removeMin(Node p) {
        if (p.left == null) {
            return p.right;
        }
        p.left = removeMin(p.left);
        return balance(p);
    }

    private Node removeNode(Node p, K k) {
        if(p == null) { return null; }
        int cmp = p.compareTo((Comparable) k);
        if (cmp > 0){
            p.left = removeNode(p.left, k);
        } else if (cmp < 0) {
            p.right = removeNode(p.right, k);
        } else {
            Node q = p.left;
            Node r = p.right;
            p = null;
            if (r == null) { return q; }
            Node min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(p);
    }

    public void removeNode(K k) {
        root = removeNode(root, k);
    }

   public boolean containsKey(K k) {
        if (get(k) != null) {
            return true;
        } else {
            return false;
        }
    }

    private Node getKey(Node p, K k) {
        if (p == null) { return null; }
        int cmp = p.compareTo((Comparable) k);
        if (cmp > 0) {
            return getKey(p.left, k);
        } else if (cmp < 0) {
            return getKey(p.right, k);
        } else { return p; }
    }

    public Node get(K k) {
        return getKey(root, k);
    }

    public Object getValue(K k) {
        return (get(k)).value;
    }

    private void preorder(Node p) {
        if (p != null) {
            System.out.printf("Key: %d  Object: ", p.key);
            System.out.println(p.value);
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void preorder() {
        preorder(root);
    }
}
