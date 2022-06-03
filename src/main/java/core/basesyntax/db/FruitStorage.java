package core.basesyntax.db;

import core.basesyntax.entity.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FruitStorage {
    public static final List<Fruit> FRUIT_STORAGE = new ArrayList<>();

    public static Optional<Fruit> getByName(String fruitName) {
        return FruitStorage.FRUIT_STORAGE.stream()
                .filter(q -> q.getName().equals(fruitName))
                .findFirst();
    }
}
