package core.basesyntax.util;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
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

    public static List<FruitTransaction> readFruitTransactions(String inputFileName) {
        try (FileReader fileReader = new FileReader(inputFileName)) {
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
        try (Writer writer = new FileWriter(OUTPUT_FILE); CSVWriter csvWriter = new CSVWriter(writer)) {
            for (String[] list : FruitReport.fruitReport()) {
                csvWriter.writeNext(list);
            }
        } catch (IOException e) {
            System.out.println("error occurred during writing file");
        }
    }
}
