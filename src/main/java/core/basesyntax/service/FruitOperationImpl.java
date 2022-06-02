package core.basesyntax.service;

import core.basesyntax.entity.Fruit;
import core.basesyntax.db.FruitStorage;

public class FruitOperationImpl implements FruitOperation {
    @Override
    public void transaction(Fruit fruit) {
        FruitStorage.FRUIT_STORAGE.add(fruit);
    }
}
