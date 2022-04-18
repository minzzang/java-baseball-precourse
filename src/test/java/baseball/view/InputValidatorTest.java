package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.config.BaseBallConfig.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    @DisplayName("String input이 숫자로만 이루어져 있는지 검증한다.")
    @Test
    public void validateNumber() {
        // given
        String numString = "123";
        // when
        int result = InputValidator.validateNumber(numString);
        // then
        assertThat(numString).isEqualTo(result + "");
    }

    @DisplayName("String input이 숫자로만 이루어지지 않을 경우 예외를 발생시킨다.")
    @Test
    public void validateNumberWithStringInput() {
        // given
        String numString = "a12";
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                InputValidator.validateNumber(numString)
        );
        // then
        assertThat(exception.getMessage()).isEqualTo("숫자만 입력 가능합니다.");
    }

    @DisplayName("3자리 숫자가 아닌 입력일 경우 예외를 발생시킨다.")
    @Test
    public void validate3Digit() {
        // given
        String input = "12";
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                InputValidator.validate(input)
        );
        // then
        assertThat(exception.getMessage()).isEqualTo(BALL_SIZE + "자리 숫자만 입력 가능합니다.");
    }

    @DisplayName("각 자리 수는 1 ~ 9사이에 숫자만 가능하다. 0일 경우 예외를 발생시킨다.")
    @Test
    public void validateRange() {
        // given
        String input = "120";
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                InputValidator.validate(input)
        );
        // then
        assertThat(exception.getMessage())
                .isEqualTo("각 자리의 숫자가 " + MIN_NUMBER + "과 " + MAX_NUMBER + "사이만 입력 가능합니다.");
    }

    @DisplayName("각 자리 수는 중복이 없어야한다. 아닐 경우 예외를 발생시킨다.")
    @Test
    public void validateDuplicate() {
        // given
        String input = "112";
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                InputValidator.validate(input)
        );
        // then
        assertThat(exception.getMessage()).isEqualTo("중복된 숫자는 입력 불가능합니다.");
    }

}