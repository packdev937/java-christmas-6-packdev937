package christmas.domain.discount;

import christmas.domain.menu.MenuType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscountPolicy implements DiscountPolicy {

    private static final int DISCOUNT_AMOUNT_PER_MAIN = 2023;

    private final String description = "주말 할인";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isApplicable(DiscountContext discountContext) {
        DayOfWeek dayOfWeek = LocalDate.of(2023, 12, discountContext.getVisitDate().getDay())
            .getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    @Override
    public int calculateDiscount(DiscountContext discountContext) {
        if (!isApplicable(discountContext)) {
            return 0;
        }
        return discountContext.getOrderItems().getItemsByType(MenuType.MAIN)
            .entrySet()
            .stream()
            .mapToInt(entry -> entry.getValue()) // Get the quantity from the Map's value
            .sum() * DISCOUNT_AMOUNT_PER_MAIN;
    }
}