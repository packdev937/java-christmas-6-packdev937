package christmas.domain.event;

public class Benefit {

    private final String description;
    private final int discountAmount;

    private Benefit(String description, int discountAmount) {
        this.description = description;
        this.discountAmount = discountAmount;
    }

    public static Benefit of(String description, int discountAmount) {
        return new Benefit(description, discountAmount);
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
