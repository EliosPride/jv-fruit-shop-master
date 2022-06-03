package core.basesyntax.service;

import com.opencsv.bean.CsvBindByName;
import core.basesyntax.db.FruitStorage;

import java.util.List;
import java.util.stream.Collectors;

public class FruitReport {

    @CsvBindByName
    private String fruitName;
    @CsvBindByName
    private Integer fruitAmount;

    public FruitReport(String fruitName, Integer fruitAmount) {
        this.fruitName = fruitName;
        this.fruitAmount = fruitAmount;
    }

    public String getFruitName() {
        return fruitName;
    }

    public Integer getFruitAmount() {
        return fruitAmount;
    }

    @Override
    public String toString() {
        return "FruitReport{" +
                "fruitName='" + fruitName + '\'' +
                ", fruitAmount=" + fruitAmount +
                '}';
    }

    public static List<FruitReport> getFruitReport() {
        return FruitStorage.FRUIT_STORAGE.stream()
                .map(x -> new FruitReport(x.getName(), x.getAmount()))
                .collect(Collectors.toList());
    }
}
