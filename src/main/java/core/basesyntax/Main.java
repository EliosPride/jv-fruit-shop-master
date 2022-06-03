package core.basesyntax;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.service.FruitProcessor;
import core.basesyntax.util.FileUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String inputFileName = "src/main/resources/fruitShop.csv";
        FileUtil.readFruitTransactions(inputFileName);

        FruitProcessor fruitOperationGenerator = new FruitProcessor();
        fruitOperationGenerator.process();

        FileUtil.generateFruitReport();
    }
}
