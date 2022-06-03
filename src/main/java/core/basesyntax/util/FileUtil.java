package core.basesyntax.util;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.FruitReport;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.List;

public class FileUtil {
    private static final String OUTPUT_FILE = "src/main/resources/fruitReport.csv";
    private static final String INPUT_FILE = "src/main/resources/fruitShop.csv";

    public static List<FruitTransaction> readFruitTransactions() {
        try (FileReader fileReader = new FileReader(INPUT_FILE)) {
            return new CsvToBeanBuilder<FruitTransaction>(fileReader)
                    .withType(FruitTransaction.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            System.out.println("error occurred during reading file");
        }
        return Collections.emptyList();
    }

    public static void generateFruitReport() {
        try (Writer writer = new FileWriter(OUTPUT_FILE)) {
            StatefulBeanToCsv<FruitReport> sbc = new StatefulBeanToCsvBuilder<FruitReport>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            sbc.write(FruitReport.getFruitReport());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("error occurred during writing file");
        }
    }
}
