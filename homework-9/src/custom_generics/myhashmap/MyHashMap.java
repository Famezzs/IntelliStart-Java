package custom_generics.myhashmap;

import custom_generics.mylinkedlist.MyLinkedList;

import java.util.Arrays;

public class MyHashMap<K,V> {
    private final int DEFAULT_SIZE = 10;
    private int currentSize = 0;
    private MyHashMapNode<K,V>[] nodes;

    public MyHashMap() {
        nodes = new MyHashMapNode[DEFAULT_SIZE];
    }

    public MyHashMap(MyHashMap<K,V> copyFrom) {
        nodes = copyFrom.nodes;
        currentSize = copyFrom.currentSize;
    }

    public void put(K key, V value) {
        boolean quarterOrLessArraySpaceLeft = currentSize >= 0.75 * nodes.length;

        if (quarterOrLessArraySpaceLeft) {
            resize();
        }

        int nodeIndex = calculateIndex(key);

        MyHashMapNode<K,V> newNode = new MyHashMapNode<>(key, value);

        MyHashMapNode<K,V> foundNodes = nodes[nodeIndex];

        if (foundNodes != null) {
            while (foundNodes.next != null) {
                foundNodes = foundNodes.next;
            }
            foundNodes.next = newNode;
        } else {
            nodes[nodeIndex] = newNode;
        }

        ++currentSize;
    }

    public MyHashMapNode<K,V> get(K key) {
        int nodeIndex = calculateIndex(key);

        MyHashMapNode<K,V> foundNodes = nodes[nodeIndex];

        while (foundNodes != null) {
            if (foundNodes.key.equals(key)) {
                return foundNodes;
            }
            foundNodes = foundNodes.next;
        }

        return null;
    }

    public int getBucketSize() {
        return nodes.length;
    }

    private int calculateIndex(K key) {
        return Math.abs(key.hashCode() % nodes.length);
    }

    private void resize() {
        MyHashMapNode<K,V>[] oldNodes = nodes;

        nodes = new MyHashMapNode[currentSize * 2];
        currentSize = 0;

        for (MyHashMapNode<K,V> oldNode: oldNodes) {
            while (oldNode != null) {
                put(oldNode.key, oldNode.value);
                oldNode = oldNode.next;
            }
        }
    }
}
