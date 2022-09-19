package custom_generics.myhashmap;

import custom_generics.MyNode;

public class MyHashMap<K,V> {

    private MyHashMapNode<K,V> head = null;
    private MyHashMapNode<K,V> tail = null;
    private int size = 0;

    public MyHashMap() {

    }

    public MyHashMap(final MyHashMap<K,V> toCopy) {
        head = toCopy.head;
        tail = toCopy.tail;
        size = toCopy.size;
    }

    public void put(final K key, final V value) {
        MyHashMapNode<K,V> existingNode = getNode(key);

        if (existingNode != null) {
            existingNode.value = value;
        } else {
            putNode(key, value);
        }
    }

    public V get(final K key) {
        MyHashMapNode<K,V> headCopy = head;

        for (; headCopy != null; headCopy = headCopy.next) {
            if (headCopy.key.equals(key)) {
                return headCopy.value;
            }
        }

        return null;
    }


    public boolean remove(final K key) {
        MyHashMapNode<K,V> nodeToRemove = getNode(key);

        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove.previous != null) {
            nodeToRemove.previous.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = nodeToRemove.previous;
        } else {
            tail = nodeToRemove.previous;
        }

        --size;
        return true;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private MyHashMapNode<K,V> getNode(final K key) {
        MyHashMapNode<K,V> headCopy = head;

        for (; headCopy != null; headCopy = headCopy.next) {
            if (headCopy.key.equals(key)) {
                return headCopy;
            }
        }

        return null;
    }

    private void putNode(final K key, final V value) {
        MyHashMapNode<K,V> newNode = new MyHashMapNode<>(null, null, key, value);

        if (tail != null) {
            newNode.previous = tail;
            tail.next = newNode;
        } else {
            head = newNode;
        }

        tail = newNode;
        ++size;
    }
}
