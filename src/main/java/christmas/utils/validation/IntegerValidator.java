package christmas.utils.validation;

import christmas.utils.messages.ErrorMessage;

public class IntegerValidator {

    public static void validateNumberInRange(int visitDate, int minimumNumber, int maximumNumber) {
        if (visitDate < minimumNumber || visitDate > maximumNumber) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }
}
