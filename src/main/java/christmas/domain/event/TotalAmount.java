package christmas.domain.event;

import static christmas.utils.ValidationUtils.validatePositiveAmount;

public class TotalAmount {

    private final int totalAmount;

    private TotalAmount(int totalAmount) {
        validatePositiveAmount(totalAmount);
        this.totalAmount = totalAmount;
    }

    public static TotalAmount from(int amount) {
        return new TotalAmount(amount);
    }

    public int value() {
        return totalAmount;
    }
}
