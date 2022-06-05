package core.basesyntax;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.service.FruitProcessor;
import core.basesyntax.util.FileUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileUtil.readFruitTransactions().forEach(FruitProcessor::process);

        FileUtil.generateFruitReport();
    }
}
