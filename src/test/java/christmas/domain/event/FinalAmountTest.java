package christmas.domain.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FinalAmountTest {

    @Test
    public void 최종_금액을_계산한다() {
        int totalAmount = 20000;
        int totalDiscount = 10000;
        FinalAmount finalAmount = FinalAmount.of(totalAmount, totalDiscount);

        assertEquals(totalAmount - totalDiscount, finalAmount.value());
    }

}