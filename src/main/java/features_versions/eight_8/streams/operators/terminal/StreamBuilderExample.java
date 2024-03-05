package features_versions.eight_8.streams.operators.terminal;

import java.util.stream.Stream;

/**
 * Stream.Builder is used to construct a stream by adding elements individually. This is particularly useful
 * in scenarios where the elements are computed or fetched incrementally.
 */
public class StreamBuilderExample {

    public static void main(String[] args) {

        Stream.Builder<String> builder = Stream.builder();

        // It's a flexible way to construct streams, especially when the final set of elements is not known in advance or depends on conditional logic.
        Stream<String> stream = builder.add("Jhon")
                .add("Doe")
                .add("Mary")
                .add("Jesus")
                .build();

        // Displaying the elements in the stream
        stream.forEach(System.out::println);
    }

}
