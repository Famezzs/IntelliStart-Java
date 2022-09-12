package utils.interfaces;

public interface MergeSort<T> {
    void sort(T[] array, int left, int right);
    void merge(T[] array, int left, int middle, int right);
}
