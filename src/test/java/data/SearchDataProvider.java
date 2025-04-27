package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class SearchDataProvider {

    public static Stream<Arguments> searchQueries() {
        return SearchDataRegistry.validSearchQueries().stream()
                .map(Arguments::of);
    }
}
