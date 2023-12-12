package christmas.controller;

import christmas.domain.entity.VisitDate;
import christmas.domain.entity.order.OrderItem;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private final OutputView outputView;
    private final InputView inputView;
    private VisitDate visitDate;
    private OrderItem orderItem;

    public EventController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.displayEventStartMessage();
        initialize();
    }

    private void initialize(){
        visitDate = inputView.readVisitDate();
    }
}
