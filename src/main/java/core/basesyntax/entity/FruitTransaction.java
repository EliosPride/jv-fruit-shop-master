package core.basesyntax.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import core.basesyntax.converter.OperationConverter;

public class FruitTransaction {
    @CsvCustomBindByName(converter = OperationConverter.class)
    private Operation type;
    @CsvBindByName
    private String fruit;
    @CsvBindByName
    private Integer quantity;

    public Operation getType() {
        return type;
    }

    public String getFruit() {
        return fruit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "type=" + type +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
