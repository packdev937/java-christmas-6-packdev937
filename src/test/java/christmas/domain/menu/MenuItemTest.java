package christmas.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MenuItem 클래스")
public class MenuItemTest {

    @Test
    void 유효한_MenuItem이_주어졌을_때_이름을_올바르게_반환한다() {
        MenuItem menuItem = MenuItem.MUSHROOM_SOUP;
        String expectedName = "양송이수프";
        String actualName = menuItem.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void 유효한_MenuItem이_주어졌을_때_가격을_올바르게_반환한다() {
        MenuItem menuItem = MenuItem.MUSHROOM_SOUP;
        int expectedPrice = 6000;
        int actualPrice = menuItem.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void 유효한_MenuItem이_주어졌을_때_유형을_올바르게_반환한다() {
        MenuItem menuItem = MenuItem.MUSHROOM_SOUP;
        MenuType expectedType = MenuType.APPETIZER;
        MenuType actualType = menuItem.getType();

        assertEquals(expectedType, actualType);
    }

    @Test
    void 유효한_MenuItem_이름이_주어졌을_때_MenuItem을_올바르게_찾는다() {
        String menuItemName = "양송이수프";
        MenuItem expectedMenuItem = MenuItem.MUSHROOM_SOUP;
        MenuItem actualMenuItem = MenuItem.findMenu(menuItemName);

        assertNotNull(actualMenuItem);
        assertEquals(expectedMenuItem, actualMenuItem);
    }

    @Test
    void 등록되지_않은_MenuItem_이름이_주어졌을_때_null을_반환한다() {
        String unknownMenuItemName = "부채살 스테이크";
        MenuItem menuItem = MenuItem.findMenu(unknownMenuItemName);

        assertNull(menuItem);
    }
}
