package ru.binary_search_tree;

import java.util.*;

public class TreeMap extends BinarySearchTree implements Map {
    @Override
    public int size() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public boolean isEmpty() {
        if (root == null) { return true; }
        else{ return false; }
    }

    @Override
    public boolean containsValue(Object value) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public Object put(Object key, Object value) {
        try {
            root = add(root, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public Object remove(Object key) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public void putAll(Map m) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public void clear() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public Set keySet() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public Collection values() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }

    @Override
    public Set<Entry> entrySet() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Данный метод не поддерживается!");
    }
}
