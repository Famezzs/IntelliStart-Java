package custom_generics.myarraylist;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import static constants.Constants.ILLEGAL_SIZE_MESSAGE;

public class MyArrayList<T> {

    private final static int DEFAULT_ARRAY_SIZE = 10;
    private Class<T> type;
    private T[] elements;
    private int amountOfElements = 0;

    public MyArrayList(final Class<T> type) {
        this.type = type;
        elements = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);
    }

    public MyArrayList(final Class<T> type, final int size)
        throws IllegalArgumentException {

        if (size <= 0) {
            throw new IllegalArgumentException(ILLEGAL_SIZE_MESSAGE);
        }

        this.type = type;
        elements = (T[]) Array.newInstance(type, size);
    }

    public MyArrayList(final MyArrayList<T> toCopy) {
        elements = toCopy.elements;
        amountOfElements = toCopy.amountOfElements;
        type = toCopy.type;
    }

    public void add(final T value) {
        if (amountOfElements >= elements.length) {
            resize();
        }

        elements[amountOfElements] = value;
        ++amountOfElements;
    }

    public void remove(final int index)
        throws IndexOutOfBoundsException {

        Objects.checkIndex(index, amountOfElements);

        T[] newArray = (T[]) Array.newInstance(type,elements.length - 1);

        System.arraycopy(elements, 0, newArray, 0, index);
        System.arraycopy(elements, index + 1, newArray, index, elements.length - index - 1);

        elements = newArray;
        --amountOfElements;
    }

    public T get(final int index)
        throws IndexOutOfBoundsException {
        Objects.checkIndex(index, amountOfElements);
        return elements[index];
    }

    public int size() {
        return amountOfElements;
    }

    public void clear() {
        elements = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);
        amountOfElements = 0;
    }

    public boolean isEmpty() {
        return amountOfElements == 0;
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
