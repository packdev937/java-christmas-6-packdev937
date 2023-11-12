package christmas.domain.event;

import static christmas.utils.ValidationUtils.validatePositiveAmount;

import christmas.domain.order.OrderItems;

public class TotalAmount {

    private final int totalAmount;

    private TotalAmount(int totalAmount) {
        validatePositiveAmount(totalAmount);
        this.totalAmount = totalAmount;
    }

    public static TotalAmount from(OrderItems orderItems) {
        int amount = calculateTotalAmount(orderItems);
        return new TotalAmount(amount);
    }

    public int getAmount() {
        return totalAmount;
    }

    private static int calculateTotalAmount(OrderItems orderItems) {
        return orderItems.getOrderItems().entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();
    }
}
