package christmas.controller;

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
    }
}
