package christmas.domain.discount;

public class TotalDiscount {

    private final int totalDiscount;

    private TotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public static TotalDiscount from(int totalDiscount) {
        return new TotalDiscount(totalDiscount);
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}
