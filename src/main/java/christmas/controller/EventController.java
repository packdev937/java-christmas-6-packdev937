package christmas.controller;

import christmas.domain.event.Promotion;
import christmas.domain.event.TotalAmount;
import christmas.domain.event.VisitDate;
import christmas.domain.order.OrderItems;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {


    public EventController() {
    }

    public void run() {
        OutputView.printEventStartMessage();
        VisitDate visitDate = InputView.readVisitDate();
        OrderItems orderItems = InputView.readOrderMenu();
        OutputView.printEventAnnouncement(visitDate.getDay());

        OutputView.printOrderItems(orderItems.toResponse());
        TotalAmount totalAmount = TotalAmount.from(orderItems);
        OutputView.printTotalAmountBeforeDiscount(totalAmount.value());

        Promotion promotion = Promotion.from(totalAmount.value());
        OutputView.printPromotionItem(promotion.item());
    }
}
