package data;

import java.util.List;

public class SearchDataRegistry {

    public static List<String> validSearchQueries() {
        return List.of(
                "Тестовый запрос",
                "Тест".repeat(100),
                " "
        );
    }
}
