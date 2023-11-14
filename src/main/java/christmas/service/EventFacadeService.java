package christmas.service;

import christmas.domain.event.TotalAmount;
import christmas.domain.order.OrderItems;

public class EventFacadeService {

    public TotalAmount calculateTotalAmount(OrderItems orderItems) {
        int amount = orderItems.getOrderItems().entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();
        return TotalAmount.from(amount);
    }
}
