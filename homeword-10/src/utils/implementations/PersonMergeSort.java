package utils.implementations;

import models.Person;
import utils.interfaces.MergeSort;

import java.util.Comparator;

public class PersonMergeSort implements MergeSort<Person> {

    private final Comparator<Person> comparator;

    public PersonMergeSort(Comparator<Person> comparator) {
        this.comparator = comparator;
    }

    public void sort(Person[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            sort(array, left, middle);
            sort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public void merge(Person[] array, int left, int middle, int right) {
        int leftSubArraySize = middle - left + 1;
        int rightSubArraySize = right - middle;

        Person[] leftSubArray = createSubArray(array, leftSubArraySize, left);
        Person[] rightSubArray = createSubArray(array, rightSubArraySize, middle + 1);

        mergeSubArrays(array, leftSubArray, rightSubArray, left);
    }

    private Person[] createSubArray(final Person[] array, final int subArraySize, final int sourcePosition) {
        Person[] subArray = new Person[subArraySize];
        System.arraycopy(array, sourcePosition, subArray, 0, subArraySize);

        return subArray;
    }

    private void mergeSubArrays(Person[] array, Person[] leftSubArray, Person[] rightSubArray, int indexMerge) {
        int indexLeftSubArray = 0;
        int indexRightSubArray = 0;

        for (; indexLeftSubArray < leftSubArray.length &&
                indexRightSubArray < rightSubArray.length;
             ++indexMerge) {

            if (comparator.compare(leftSubArray[indexLeftSubArray],
                    rightSubArray[indexRightSubArray]) <= 0) {

                array[indexMerge] = leftSubArray[indexLeftSubArray];
                ++indexLeftSubArray;

            } else {

                array[indexMerge] = rightSubArray[indexRightSubArray];
                ++indexRightSubArray;
            }
        }

        for (; indexLeftSubArray < leftSubArray.length; ++indexLeftSubArray, ++indexMerge) {
            array[indexMerge] = leftSubArray[indexLeftSubArray];
        }

        for (; indexRightSubArray < rightSubArray.length; ++indexRightSubArray, ++indexMerge) {
            array[indexMerge] = rightSubArray[indexRightSubArray];
        }
    }
}
