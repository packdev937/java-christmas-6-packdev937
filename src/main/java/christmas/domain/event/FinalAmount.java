package christmas.domain.event;

import christmas.domain.discount.TotalDiscount;

public class FinalAmount {

    private final int finalAmount;

    private FinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
    }

    public static FinalAmount of(TotalAmount totalAmount, TotalDiscount totalDiscount) {
        return new FinalAmount(calculateFinalAmount(totalAmount, totalDiscount));
    }


    private static int calculateFinalAmount(TotalAmount totalAmount, TotalDiscount totalDiscount) {
        return totalAmount.getAmount() - totalDiscount.getDiscount();
    }

    public int getAmount() {
        return finalAmount;
    }
}
