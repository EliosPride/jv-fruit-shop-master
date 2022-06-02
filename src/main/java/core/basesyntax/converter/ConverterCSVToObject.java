package core.basesyntax.converter;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.entity.FruitTransaction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ConverterCSVToObject {

    public List<FruitTransaction> reader(String inputFileName) throws FileNotFoundException {
        List<FruitTransaction> fruitTransactionList;
        fruitTransactionList = new CsvToBeanBuilder<FruitTransaction>(new FileReader(inputFileName))
                .withType(FruitTransaction.class)
                .build()
                .parse();
        fruitTransactionList.forEach(System.out::println);
        return fruitTransactionList;
    }
}
