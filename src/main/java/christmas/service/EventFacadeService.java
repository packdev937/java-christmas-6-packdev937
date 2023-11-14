package christmas.service;

import christmas.domain.event.Benefits;
import christmas.domain.event.Promotion;
import christmas.domain.event.TotalAmount;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderItems;

public class EventFacadeService {

    public TotalAmount calculateTotalAmount(OrderItems orderItems) {
        int amount = orderItems.getOrderItems().entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();
        return TotalAmount.from(amount);
    }

    public int calculateFinalAmount(Benefits benefits, TotalAmount totalAmount,
        OrderItems orderItems) {
        int totalBenefits = benefits.calculateTotalBenefits();
        if (!orderItems.containPromotion()) {
            totalBenefits -= MenuItem.CHAMPAGNE.getPrice();
        }
        return totalAmount.value() - totalBenefits;
    }

}
