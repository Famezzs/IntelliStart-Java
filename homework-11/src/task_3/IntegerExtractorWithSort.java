package task_3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constants.Constants.INVALID_STRING_LIST_MESSAGE;

public class IntegerExtractorWithSort {

    private final static HashSet<Character> numbers = new HashSet<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    private final static String delimiter = ", ";

    public static String extract(final List<String> strings)
    throws IllegalArgumentException {

        if (strings == null ||
            strings.size() < 1) {

            throw new IllegalArgumentException(INVALID_STRING_LIST_MESSAGE);
        }

        final StringJoiner result = new StringJoiner(delimiter);

        strings.stream()
                .map(string -> {
                    final StringTokenizer tokenizer = new StringTokenizer(string, delimiter);
                    final List<Integer> extractedNumbers = new LinkedList<>();
                    while (tokenizer.hasMoreTokens()) {
                        final String nextToken = tokenizer.nextToken();
                        if (isStringNumber(nextToken)) {
                            extractedNumbers.add(Integer.parseInt(nextToken));
                        }
                    }
                    return extractedNumbers.toArray();})
                    .flatMap(Stream::of)
                        .sorted()
                            .forEach(number -> result.add(number.toString()));

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
