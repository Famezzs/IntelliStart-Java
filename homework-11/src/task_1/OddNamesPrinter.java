package task_1;

import static constants.Constants.INVALID_NAMES_ARRAY_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OddNamesPrinter {
    public static String getOddNames(final String[] names)
    throws IllegalArgumentException {

        if (names == null ||
            names.length < 1) {

            throw new IllegalArgumentException(INVALID_NAMES_ARRAY_MESSAGE);
        }

        final StringBuilder result = new StringBuilder();

        IntStream.range(1, names.length)
            .filter(index -> index % 2 != 0)
            .mapToObj(index ->  {
                StringBuilder name = new StringBuilder();
                name.append(index)
                    .append(". ")
                    .append(names[index]);
                if (index + 2 < names.length) {
                    name.append(", ");
                };
                return name.toString();})
            .forEach(result::append);

        return result.toString();
    }
}
