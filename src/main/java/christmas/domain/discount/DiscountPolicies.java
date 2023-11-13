package christmas.domain.discount;

import christmas.domain.event.Benefit;
import christmas.domain.event.Benefits;
import christmas.domain.event.Promotion;
import christmas.domain.event.TotalAmount;
import christmas.domain.menu.MenuItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountPolicies {

    private final List<DiscountPolicy> policies;

    private DiscountPolicies() {
        this.policies = Arrays.asList(
            new ChristmasDiscountPolicy(),
            new WeekdayDiscountPolicy(),
            new WeekendDiscountPolicy(),
            new SpecialDiscountPolicy()
        );
    }

    public Benefits createBenefits(DiscountContext discountContext,
        TotalAmount totalAmount, Promotion promotion) {
        if (totalAmount.value() < 10000) {
            return Benefits.from(new ArrayList<>());
        }
        List<Benefit> benefits = policies.stream()
            .filter(policy -> policy.isApplicable(discountContext)).map(policy ->
                Benefit.of(policy.getDescription(), policy.calculateDiscount(discountContext))
            ).collect(Collectors.toList());

        if (promotion.item().equals(MenuItem.CHAMPAGNE)) {
            benefits.add(Benefit.of("증정 이벤트", MenuItem.CHAMPAGNE.getPrice()));
        }
        return Benefits.from(benefits);
    }

    public static DiscountPolicies getInstance() {
        return new DiscountPolicies();
    }

    public List<DiscountPolicy> asList() {
        return Collections.unmodifiableList(policies);
    }
}

