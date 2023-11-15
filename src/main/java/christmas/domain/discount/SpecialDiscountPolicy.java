package christmas.domain.discount;

import christmas.domain.event.VisitDate;
import java.util.List;

public class SpecialDiscountPolicy implements DiscountPolicy {

    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private final List<Integer> specialDays = List.of(3, 10, 17, 24, 25, 31);

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
        Integer day = date.getDay();
        return specialDays.contains(day);
    }
}