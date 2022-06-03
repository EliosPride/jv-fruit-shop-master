package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FruitReport {
    public static List<String[]> fruitReport() {
        return FruitStorage.FRUIT_STORAGE.stream()
                .map(fruit -> new String[]{Objects.toString(fruit, null)})
                .collect(Collectors.toList());
    }
}
