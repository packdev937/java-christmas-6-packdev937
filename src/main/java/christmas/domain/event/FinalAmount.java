package christmas.domain.event;

import static christmas.utils.ValidationUtils.*;

public class FinalAmount {

    private final int finalAmount;

    private FinalAmount(int finalAmount) {
        validatePositiveAmount(finalAmount);
        this.finalAmount = finalAmount;
    }

    public static FinalAmount of(int totalAmount, int totalDiscount) {
        return new FinalAmount(calculateFinalAmount(totalAmount, totalDiscount));
    }


    private static int calculateFinalAmount(int totalAmount, int totalDiscount) {
        return totalAmount - totalDiscount;
    }

    public int value() {
        return finalAmount;
    }
}
