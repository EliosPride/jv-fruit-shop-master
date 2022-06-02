package core.basesyntax.service;

import core.basesyntax.entity.Fruit;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.converter.ConverterCSVToObject;

import java.io.FileNotFoundException;
import java.util.List;

public class FruitOperationGenerator {

    public void fruitRestReport() throws FileNotFoundException {
        String inputFile = "src/main/resources/fruitShop.csv";
        ConverterCSVToObject converterCSVToObject = new ConverterCSVToObject();
        List<FruitTransaction> fruitTransactionList = converterCSVToObject.reader(inputFile);
        FruitOperationImpl fruitOperation = new FruitOperationImpl();
        fruitTransactionList.forEach(x -> {
            switch (x.getType()) {
                case BALANCE -> {
                    Fruit fruit = new Fruit(x.getFruit(), x.getQuantity());
                    fruitOperation.transaction(fruit);
                }
                case SUPPLY, RETURN -> {
                    Fruit fruit = new Fruit(x.getFruit(), x.getQuantity());
                    FruitStorage.FRUIT_STORAGE.stream()
                            .filter(a -> a.getName().equals(fruit.getName()))
                            .findFirst()
                            .ifPresent(a -> a.setAmount(a.getAmount() + fruit.getAmount()));
                }
                case PURCHASE -> {
                    Fruit fruit = new Fruit(x.getFruit(), x.getQuantity());
                    FruitStorage.FRUIT_STORAGE.stream()
                            .filter(q -> q.getName().equals(fruit.getName()))
                            .findFirst()
                            .ifPresent(q -> q.setAmount(q.getAmount() - fruit.getAmount()));
                }
            }
        });
    }
}
