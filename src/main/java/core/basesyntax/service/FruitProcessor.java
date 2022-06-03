package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.entity.Fruit;
import core.basesyntax.entity.FruitTransaction;

public class FruitProcessor {

    public static void process(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getType()) {
            case BALANCE -> FruitStorage.FRUIT_STORAGE.add(new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity()));
            case SUPPLY, RETURN -> FruitStorage.getByName(fruitTransaction.getFruit())
                    .ifPresent(a -> a.setAmount(a.getAmount() + fruitTransaction.getQuantity()));
            case PURCHASE -> FruitStorage.getByName(fruitTransaction.getFruit())
                    .ifPresent(q -> q.setAmount(q.getAmount() - (new Fruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity())).getAmount()));
        }
    }
}
