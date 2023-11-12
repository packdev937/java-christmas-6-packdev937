package christmas.domain.discount;

import christmas.domain.event.VisitDate;
import christmas.domain.order.OrderItems;

public class DiscountContext {

    private final VisitDate visitDate;
    private final OrderItems orderItems;

    private DiscountContext(VisitDate visitDate, OrderItems orderItems) {
        this.visitDate = visitDate;
        this.orderItems = orderItems;
    }

    public static DiscountContext of(VisitDate visitDate, OrderItems orderItems) {
        return new DiscountContext(visitDate, orderItems);
    }

    public VisitDate getVisitDate() {
        return visitDate;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }
}
