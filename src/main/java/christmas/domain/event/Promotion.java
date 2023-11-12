package christmas.domain.event;

import christmas.domain.menu.MenuItem;

public class Promotion {

    private static final int PROMOTION_CRITERION = 120000;
    private final MenuItem item;

    private Promotion(MenuItem promotion) {
        this.item = promotion;
    }

    public static Promotion from(int totalAmount) {
        if (isApplicable(totalAmount)) {
            return new Promotion(MenuItem.CHAMPAGNE);
        }
        return new Promotion(MenuItem.NONE);
    }

    private static boolean isApplicable(int orderTotalAmount) {
        return orderTotalAmount >= PROMOTION_CRITERION;
    }

    public MenuItem item() {
        return item;
    }
}
