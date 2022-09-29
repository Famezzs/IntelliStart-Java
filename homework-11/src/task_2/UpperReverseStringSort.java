package task_2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static constants.Constants.INVALID_STRING_LIST_MESSAGE;

public class UpperReverseStringSort {
    public static List<String> sort(final List<String> strings)
    throws IllegalArgumentException {

        if (strings == null ||
            strings.isEmpty()) {

            throw new IllegalArgumentException(INVALID_STRING_LIST_MESSAGE);
        }

        final List<String> result = new LinkedList<>();

        for (final String value: strings) {
            result.add(value.toUpperCase());
        }

        result.sort(Comparator.reverseOrder());

        return result;
    }
}
