package christmas.domain.event;

import christmas.domain.menu.MenuItem;

public class Promotion {

    private final String description = "증정 이벤트";
    private final MenuItem item;

    private Promotion(MenuItem promotion) {
        this.item = promotion;
    }

    public static Promotion from(TotalAmount totalAmount) {
        if (totalAmount.isPromotionApplicable()) {
            return new Promotion(MenuItem.CHAMPAGNE);
        }
        return new Promotion(MenuItem.NONE);
    }

    public MenuItem item() {
        return item;
    }

    public String getDescription() {
        return description;
    }
}
