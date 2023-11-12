package christmas.domain.event;

public class Promotion {

    private static final int PROMOTION_CRITERION = 120000;

    private Promotion() {
    }

    public static Promotion getInstance(){
        return new Promotion();
    }

    public boolean isApplicable(int orderTotalAmount) {
        return orderTotalAmount >= PROMOTION_CRITERION;
    }
}
