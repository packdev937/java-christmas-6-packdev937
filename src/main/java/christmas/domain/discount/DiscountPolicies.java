package christmas.domain.discount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static DiscountPolicies getInstance() {
        return new DiscountPolicies();
    }

    public List<DiscountPolicy> asList() {
        return Collections.unmodifiableList(policies);
    }
}

