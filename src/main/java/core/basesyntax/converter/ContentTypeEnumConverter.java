package core.basesyntax.converter;

import com.opencsv.bean.AbstractBeanField;
import core.basesyntax.entity.Operation;

public class ContentTypeEnumConverter extends AbstractBeanField<Operation> {
    @Override
    protected Object convert(String s) {
        return Operation.fromString(s);
    }
}
