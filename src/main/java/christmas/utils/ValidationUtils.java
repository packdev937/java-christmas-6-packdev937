package christmas.utils;

public class ValidationUtils {

    public static void validatePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("최종 금액이 0보다 작습니다.");
        }
    }
}
