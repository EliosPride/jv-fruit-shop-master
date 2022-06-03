package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.entity.Fruit;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.util.FileUtil;

import java.util.List;

public class FruitProcessor {

    public void process() {
        String inputFile = "src/main/resources/fruitShop.csv";
        List<FruitTransaction> fruitTransactionList = FileUtil.readFruitTransactions(inputFile);
        fruitTransactionList.forEach(x -> {
            switch (x.getType()) {
                case BALANCE -> FruitStorage.FRUIT_STORAGE.add(new Fruit(x.getFruit(), x.getQuantity()));
                case SUPPLY, RETURN -> FruitStorage.getByName(x.getFruit())
                        .ifPresent(a -> a.setAmount(a.getAmount() + x.getQuantity()));
                case PURCHASE -> FruitStorage.getByName(x.getFruit())
                        .ifPresent(q -> q.setAmount(q.getAmount() - (new Fruit(x.getFruit(), x.getQuantity())).getAmount()));
            }
        });
    }
}
