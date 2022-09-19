package custom_generics.mystack;

import custom_generics.MyNode;

import java.util.Objects;

import static constants.Constants.COLLECTION_IS_NULL_MESSAGE;

public class MyStack<T> {

    private MyNode<T> head = null;
    private int size = 0;

    public MyStack() {

    }

    public MyStack(final MyStack<T> toCopy) {
        head = toCopy.head;
        size = toCopy.size;
    }

    public void push(final T value) {
        MyNode<T> newNode = new MyNode<>(null, null, value);

        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        }

        head = newNode;
        ++size;
    }

    public T remove(final int index)
            throws IndexOutOfBoundsException {

        Objects.checkIndex(index, size);

        return removeNode(getNode(index));
    }

    public T peek()
            throws IndexOutOfBoundsException {

        if (head == null) {
            throw new IndexOutOfBoundsException(COLLECTION_IS_NULL_MESSAGE);
        }

        return head.value;
    }

    public T pop()
            throws IndexOutOfBoundsException {

        if (head == null) {
            throw new IndexOutOfBoundsException(COLLECTION_IS_NULL_MESSAGE);
        }

        return remove(0);
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private T removeNode(final MyNode<T> nodeToRemove) {
        if (nodeToRemove.previous != null) {
            nodeToRemove.previous.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.previous = nodeToRemove.previous;
        }

        --size;
        return nodeToRemove.value;
    }

    private MyNode<T> getNode(final int index)
            throws IndexOutOfBoundsException {

        Objects.checkIndex(index, size);

        MyNode<T> copyHead = head;

        for (int currentIndex = 0;
             copyHead.next != null && currentIndex < index;
             copyHead = copyHead.next, ++currentIndex);

        return copyHead;
    }
}
