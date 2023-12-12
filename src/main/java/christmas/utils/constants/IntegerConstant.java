package christmas.utils.constants;

public enum IntegerConstant {

    EVENT_MONTH(12),
    MINIMUM_DATE_RANGE(1),
    MAXIMUM_DATE_RANGE(31);

    private final int value;

    IntegerConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
