package christmas.domain.event;

import christmas.domain.order.OrderItems;

public class TotalAmount {

    private final int totalAmount;

    private TotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static TotalAmount from(OrderItems orderItems) {
        int amount = calculateTotalAmount(orderItems);
        return new TotalAmount(amount);
    }

    public int getAmount() {
        return totalAmount;
    }

    public static int calculateTotalAmount(OrderItems orderItems) {
        return orderItems.getOrderItems().entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();
    }
}
