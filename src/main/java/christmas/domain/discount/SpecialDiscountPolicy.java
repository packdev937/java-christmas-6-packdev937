package christmas.domain.discount;

import christmas.domain.event.VisitDate;

public class SpecialDiscountPolicy implements DiscountPolicy {

    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;

    private final String description = "특별 할인";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isApplicable(DiscountContext discountContext) {
        return isSpecialDay(discountContext.getVisitDate());
    }

    @Override
    public int calculateDiscount(DiscountContext discountContext) {
        if (isApplicable(discountContext)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private boolean isSpecialDay(VisitDate date) {
        int day = date.getDay();
        return day == 3 || day == 10 || day == 17 || day == 24 || day == 25 || day == 31;
    }
}