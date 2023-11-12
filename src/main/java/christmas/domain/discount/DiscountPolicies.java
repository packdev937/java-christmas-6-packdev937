package christmas.domain.discount;

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

    public TotalDiscount calculateTotalDiscount(DiscountContext discountContext) {

        List<Integer> discounts = policies.stream()
            .filter(policy -> policy.isApplicable(discountContext)).map(policy -> {
                int discount = policy.calculateDiscount(discountContext);
                return discount;
            }).collect(Collectors.toList());

        return TotalDiscount.from(discounts.stream().mapToInt(Integer::intValue).sum());
    }

    public static DiscountPolicies getInstance() {
        return new DiscountPolicies();
    }

    public List<DiscountPolicy> asList() {
        return Collections.unmodifiableList(policies);
    }
}

