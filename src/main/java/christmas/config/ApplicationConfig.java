package christmas.config;

import christmas.controller.EventController;
import christmas.domain.discount.ChristmasDiscountPolicy;
import christmas.domain.discount.DiscountPolicies;
import christmas.domain.discount.SpecialDiscountPolicy;
import christmas.domain.discount.WeekdayDiscountPolicy;
import christmas.domain.discount.WeekendDiscountPolicy;
import christmas.service.EventFacadeService;
import java.util.Arrays;

public class ApplicationConfig {

    public EventController eventController() {
        EventFacadeService eventFacadeService = eventFacadeService();
        DiscountPolicies discountPolicies = discountPolicies();
        return new EventController(eventFacadeService, discountPolicies);
    }

    private EventFacadeService eventFacadeService() {
        return new EventFacadeService();
    }

    private DiscountPolicies discountPolicies() {
        return new DiscountPolicies(
            Arrays.asList(
	new ChristmasDiscountPolicy(),
	new WeekdayDiscountPolicy(),
	new WeekendDiscountPolicy(),
	new SpecialDiscountPolicy()
            )
        );
    }
}
