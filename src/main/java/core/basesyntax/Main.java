package core.basesyntax;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.converter.ConverterCSVToObject;
import core.basesyntax.converter.ConverterObjectToCSV;
import core.basesyntax.service.FruitOperationGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String inputFileName = "src/main/resources/fruitShop.csv";
        ConverterCSVToObject converterCSVToObject = new ConverterCSVToObject();
        converterCSVToObject.reader(inputFileName);

        FruitOperationGenerator fruitOperationGenerator = new FruitOperationGenerator();
        fruitOperationGenerator.fruitRestReport();

        ConverterObjectToCSV converterObjectToCSV = new ConverterObjectToCSV();
        converterObjectToCSV.writer();
    }
}
