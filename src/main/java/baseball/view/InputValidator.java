package baseball.view;

import java.util.HashSet;
import java.util.Set;

import static baseball.config.BaseBallConfig.*;

public class InputValidator {

    public static void validate(String input) {
        if (input.length() != BALL_SIZE) {
            throw new IllegalArgumentException(BALL_SIZE + "자리 숫자만 입력 가능합니다.");
        }

        validateNumber(input);
        validateRange(input);
        validateDuplicate(input);
    }


    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
    }

    private static void validateRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            validateRangeOf(number);
        }
    }

    private static void validateRangeOf(int number) {
        if (number < MIN_NUMBER
                || number > MAX_NUMBER) {
            throw new IllegalArgumentException("각 자리의 숫자가 " + MIN_NUMBER + "과 " + MAX_NUMBER + "사이만 입력 가능합니다.");
        }
    }

    private static void validateDuplicate(String input) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            set.add(number);
        }
        if (set.size() != BALL_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력 불가능합니다.");
        }
    }
}
