package christmas.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("OrderParser 클래스")
public class OrderParserTest {

    @Test
    public void 문자열을_올바르게_파싱한다() {
        String input = "양송이수프-2, 샴페인-3";

        Map<String, Integer> result = OrderParser.parseInput(input);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result).containsEntry("양송이수프", 2);
        assertThat(result).containsEntry("샴페인", 3);
    }

    @Test
    public void 문자열이_비었다면_예외를_발생한다() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> OrderParser.parseInput(input));
    }

    @ParameterizedTest
    @CsvSource({
        "양송이수프--3",
        "양송이수프-문자, ",
        "-양송이수프-3,",
        "' ,",
        "'양송이수프-3,수프,"
    })
    void 유효하지_않은_형식의_문자열에_예외를_발생한다(String input) {
        assertThatThrownBy(() -> OrderParser.parseInput(input))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 중복된_문자열의_메뉴를_추가할_때_예외를_발생한다() {
        String input = "양송이수프-1, 양송이수프-2";

        assertThrows(IllegalArgumentException.class,
            () -> OrderParser.parseInput(input));
    }
}
