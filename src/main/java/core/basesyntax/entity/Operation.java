package core.basesyntax.entity;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation fromString(String operation) {
        for (Operation b : Operation.values()) {
            if (b.operation.equalsIgnoreCase(operation)) {
                return b;
            }
        }
        return null;
    }
}
