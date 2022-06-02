package core.basesyntax.converter;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.entity.Fruit;
import core.basesyntax.db.FruitStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ConverterObjectToCSV {

    public void writer() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String outputFile = "src/main/resources/fruitReport.csv";
        Writer writer = new FileWriter(outputFile);
        StatefulBeanToCsv<Fruit> sbc = new StatefulBeanToCsvBuilder<Fruit>(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
        sbc.write(FruitStorage.FRUIT_STORAGE);
        writer.close();
    }
}
