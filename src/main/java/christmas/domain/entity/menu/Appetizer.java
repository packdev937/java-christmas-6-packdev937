package christmas.domain.entity.menu;

public enum Appetizer implements Item {
    MUSHROOM_SOUP("양송이수프", 6000), TAPAS("타파스", 5500), CAESAR_SALAD("시저샐러드", 8000);

    private final String description;
    private final int price;

    Appetizer(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
