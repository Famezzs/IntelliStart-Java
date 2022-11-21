package task_2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static constants.Constants.INVALID_STRING_LIST_MESSAGE;

public class UpperReverseStringSort {
    public static List<String> sort(final List<String> strings)
    throws IllegalArgumentException {

        if (strings == null ||
            strings.isEmpty()) {

            throw new IllegalArgumentException(INVALID_STRING_LIST_MESSAGE);
        }

        return strings.stream()
            .map(String::toUpperCase)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
}
