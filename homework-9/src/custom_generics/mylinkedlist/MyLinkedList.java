package custom_generics.mylinkedlist;

import custom_generics.MyNode;

import java.util.Objects;

public class MyLinkedList<T> {

    private MyNode<T> head = null;
    private MyNode<T> tail = null;
    private int size = 0;

    public MyLinkedList() {

    }

    public MyLinkedList(final MyLinkedList<T> toCopy) {
        head = toCopy.head;
        tail = toCopy.tail;
        size = toCopy.size();
    }

    public void add(final T value) {
        MyNode<T> newNode = new MyNode<>(null, null, value);

        if (tail != null) {
            newNode.previous = tail;
            tail.next = newNode;
        } else {
            head = newNode;
        }

        tail = newNode;
        ++size;
    }

    public T get(final int index)
        throws IndexOutOfBoundsException {

        int maxIndex = size - 1;

        Objects.checkIndex(index, maxIndex + 1);

        if (index > maxIndex / 2) {
            return getNodeFromTail(maxIndex - index).value;
        } else {
            return getNodeFromHead(index).value;
        }
    }

    public T remove(final int index)
        throws IndexOutOfBoundsException {

        int maxIndex = size - 1;

        Objects.checkIndex(index, maxIndex + 1);

        if (index > maxIndex / 2) {
            return removeNode(getNodeFromTail(maxIndex - index));
        } else {
            return removeNode(getNodeFromHead(index));
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private MyNode<T> getNodeFromTail(final int index) {
        MyNode<T> copyTail = tail;

        for (int currentIndex = 0;
             currentIndex < index && copyTail.previous != null;
             copyTail = copyTail.previous, ++currentIndex);

        return copyTail;
    }

    private MyNode<T> getNodeFromHead(final int index) {
        MyNode<T> copyHead = head;

        for (int currentIndex = 0;
             currentIndex < index && copyHead.next != null;
             copyHead = copyHead.next, ++currentIndex);

        return copyHead;
    }

    private T removeNode(final MyNode<T> nodeToRemove) {
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
        return nodeToRemove.value;
    }
}
