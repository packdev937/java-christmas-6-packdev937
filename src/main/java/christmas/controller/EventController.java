package christmas.controller;

import christmas.domain.discount.DiscountContext;
import christmas.domain.discount.DiscountPolicies;
import christmas.domain.event.Benefits;
import christmas.domain.event.EventBadge;
import christmas.domain.event.Promotion;
import christmas.domain.event.TotalAmount;
import christmas.domain.event.VisitDate;
import christmas.domain.order.OrderItems;
import christmas.service.EventFacadeService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private final EventFacadeService eventFacadeService;
    private final DiscountPolicies discountPolicies;

    public EventController(EventFacadeService eventFacadeService,
        DiscountPolicies discountPolicies) {
        this.eventFacadeService = eventFacadeService;
        this.discountPolicies = discountPolicies;
    }

    public void run() {
        OutputView.printEventStartMessage();
        VisitDate visitDate = InputView.readVisitDate();
        OrderItems orderItems = InputView.readOrderMenu();
        OutputView.printEventAnnouncement(visitDate.getDay());

        OutputView.printOrderItems(orderItems.toResponse());
        TotalAmount totalAmount = eventFacadeService.calculateTotalAmount(orderItems);
        OutputView.printTotalAmountBeforeDiscount(totalAmount.value());

    private Promotion displayPromotion(TotalAmount totalAmount) {
        Promotion promotion = eventFacadeService.evaluatePromotion(totalAmount);
        OutputView.printPromotionItem(promotion.item());
        return promotion;
    }

        DiscountContext discountContext = DiscountContext.of(visitDate, orderItems);
        DiscountPolicies discountPolicies = DiscountPolicies.getInstance();
        Benefits benefits = discountPolicies
            .createBenefits(discountContext, totalAmount, promotion);
        OutputView.printBenefits(benefits.toResponse());
        OutputView.printTotalBenefits(benefits.calculateTotalBenefits());

    private void displayExpectedAmountAfterDiscount(Benefits benefits, TotalAmount totalAmount,
        OrderItems orderItems) {
        OutputView.printExpectedAmountAfterDiscount(
            eventFacadeService.calculateFinalAmount(benefits, totalAmount, orderItems));
    }

        EventBadge badge = EventBadge.getBadgeByAmount(benefits.calculateTotalBenefits());
        OutputView.printEventBadge(badge);
    }
}
