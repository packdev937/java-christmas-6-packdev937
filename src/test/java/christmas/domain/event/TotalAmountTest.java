package christmas.domain.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.MenuItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TotalAmountTest {

    @ParameterizedTest
    @CsvSource({
        "T_BONE_STEAK, 2, CHOCOLATE_CAKE, 1",
        "MUSHROOM_SOUP, 3, TAPAS, 4",
        "BBQ_RIBS, 2, ICE_CREAM, 3"
    })
    public void 주문한_메뉴들의_총_금액을_구한다(MenuItem firstItem, int firstQuantity, MenuItem secondItem,
        int secondQuantity) {
        int expectedAmount =
            firstItem.getPrice() * firstQuantity + firstItem.getPrice() * secondQuantity;
        TotalAmount totalAmount = TotalAmount.from(expectedAmount);
        assertEquals(expectedAmount, totalAmount.value());
    }

}