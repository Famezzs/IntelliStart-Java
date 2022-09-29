package task_3;

import java.util.*;

import static constants.Constants.INVALID_STRING_LIST_MESSAGE;

public class IntegerExtractorWithSort {

    private final static HashSet<Character> numbers = new HashSet<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    private final static String delimiter = ", ";

    public static String extract(final String... strings)
    throws IllegalArgumentException {

        if (strings == null ||
            strings.length < 1) {

            throw new IllegalArgumentException(INVALID_STRING_LIST_MESSAGE);
        }

        final List<Integer> extractedNumbers = new LinkedList<>();

        for (final String value: strings) {
            final StringTokenizer tokenizer = new StringTokenizer(value, delimiter);

            while (tokenizer.hasMoreTokens()) {
                final String nextToken = tokenizer.nextToken();

                if (isStringNumber(nextToken)) {
                    extractedNumbers.add(Integer.parseInt(nextToken));
                }
            }
        }

        extractedNumbers.sort(Comparator.naturalOrder());

        final StringJoiner result = new StringJoiner(delimiter);

        for (final Integer integer: extractedNumbers) {
            result.add(integer.toString());
        }

        return result.toString();
    }

    private static boolean isStringNumber(final String stringToCheck) {
        for (final char character: stringToCheck.toCharArray()) {
            if (!numbers.contains(character)) {
                return false;
            }
        }
        return true;
    }
}
