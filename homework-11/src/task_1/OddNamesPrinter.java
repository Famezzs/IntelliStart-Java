package task_1;

import static constants.Constants.INVALID_NAMES_ARRAY_MESSAGE;

public class OddNamesPrinter {
    public static String getOddNames(final String... names)
    throws IllegalArgumentException {

        if (names == null ||
            names.length < 1) {

            throw new IllegalArgumentException(INVALID_NAMES_ARRAY_MESSAGE);
        }

        final StringBuilder result = new StringBuilder();

        for (int index = 1; index < names.length;index += 2) {
            result.append(index)
                    .append(". ")
                    .append(names[index]);

            if (index + 2 < names.length) {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
