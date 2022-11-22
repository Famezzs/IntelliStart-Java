package task_5;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constants.Constants.INVALID_STREAM_MESSAGE_TEMPLATE;

public class StreamMixer<T> {
    public static <T> Stream<T> zip(final Stream<T> first, final Stream<T> second)
    throws IllegalArgumentException {

        if (first == null) {
            throw new IllegalArgumentException("First stream" + INVALID_STREAM_MESSAGE_TEMPLATE);
        }

        if (second == null) {
            throw new IllegalArgumentException("Second stream" + INVALID_STREAM_MESSAGE_TEMPLATE);
        }

        final LinkedList<T> firstStreamValues = first.collect(Collectors.toCollection(LinkedList::new));

        final LinkedList<T> secondStreamValues = second.collect(Collectors.toCollection(LinkedList::new));

        final LinkedList<T> result = new LinkedList<>();

        while (!firstStreamValues.isEmpty() &&
                !secondStreamValues.isEmpty()) {

            result.add(firstStreamValues.pop());
            result.add(secondStreamValues.pop());
        }

        return result.stream();
    }
}
