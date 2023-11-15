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
        VisitDate visitDate = getInputVisitDate();
        OrderItems orderItems = getInputOrderItem();
        displayEventAnnouncement(visitDate);

        TotalAmount totalAmount = calculateAndDisplayTotalOrder(orderItems);
        Promotion promotion = displayPromotion(totalAmount);

        displayBenefits(visitDate, orderItems, totalAmount, promotion);
    }

    private VisitDate getInputVisitDate() {
        OutputView.printEventStartMessage();
        return InputView.readVisitDate();
    }

    private OrderItems getInputOrderItem() {
        return InputView.readOrderMenu();
    }

    private void displayEventAnnouncement(VisitDate visitDate) {
        OutputView.printEventAnnouncement(visitDate.getDay());
    }

    private TotalAmount calculateAndDisplayTotalOrder(OrderItems orderItems) {
        OutputView.printOrderItems(orderItems.toResponse());
        TotalAmount totalAmount = eventFacadeService.calculateTotalAmountBeforeDiscount(orderItems);
        OutputView.printTotalAmountBeforeDiscount(totalAmount.value());
        return totalAmount;
    }

    private Promotion displayPromotion(TotalAmount totalAmount) {
        Promotion promotion = eventFacadeService.evaluatePromotion(totalAmount);
        OutputView.printPromotionItem(promotion.item());
        return promotion;
    }

    private void displayBenefits(VisitDate visitDate, OrderItems orderItems,
        TotalAmount totalAmount,
        Promotion promotion) {
        DiscountContext discountContext = DiscountContext.of(visitDate, orderItems);
        Benefits benefits = calculateBenefits(discountContext, totalAmount, promotion);

        displayBenefits(benefits);
        displayTotalBenefits(benefits);
        displayExpectedAmountAfterDiscount(benefits, totalAmount, orderItems);
        printEventBadge(benefits);
    }


    private Benefits calculateBenefits(DiscountContext discountContext, TotalAmount totalAmount,
        Promotion promotion) {
        return discountPolicies.createBenefits(discountContext, totalAmount, promotion);
    }

    private void displayBenefits(Benefits benefits) {
        OutputView.printBenefits(benefits.toResponse());
    }

    private void displayTotalBenefits(Benefits benefits) {
        OutputView.printTotalBenefits(benefits.calculateTotalBenefits());
    }

    private void displayExpectedAmountAfterDiscount(Benefits benefits, TotalAmount totalAmount,
        OrderItems orderItems) {
        OutputView.printExpectedAmountAfterDiscount(
            eventFacadeService.calculateFinalAmount(benefits, totalAmount, orderItems));
    }

    private void printEventBadge(Benefits benefits) {
        EventBadge badge = EventBadge.getBadgeByAmount(benefits.calculateTotalBenefits());
        OutputView.printEventBadge(badge);
    }
}
