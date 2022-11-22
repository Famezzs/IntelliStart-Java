package task_4;

import java.util.stream.Stream;

public class PseudoRandomStreamGenerator {
    /**
     *
     * @param seed a seed to use for Pseudo RNG
     * @param a any long number, 0 <= a < m
     * @param c any long number, 0 <= c < m
     * @param m any natural number
     * @return an endless stream of Pseudo RNG long values
     */
    public static Stream<Long> generate(final long seed,
                                        final long a,
                                        final long c,
                                        final long m) {

        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    /**
     *
     * @param seed a seed to use for Pseudo RNG
     * @param a any long number, 0 <= a < m
     * @param c any long number, 0 <= c < m
     * @param m any natural number
     * @param limit a limit of long values to be generated
     * @return a limited stream of Pseudo RNG long values
     */
    public static Stream<Long> generate(final long seed,
                                        final long a,
                                        final long c,
                                        final long m,
                                        final long limit) {

        return Stream.iterate(seed, x -> (a * x + c) % m).limit(limit);
    }
}
