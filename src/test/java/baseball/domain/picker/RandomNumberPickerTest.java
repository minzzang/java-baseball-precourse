package baseball.domain.picker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.config.BaseBallConfig.*;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberPickerTest {

    @DisplayName("RandomNumberPicker는 1에서 9사이 값을 가져온다.")
    @Test
    public void peek() {
        // given
        RandomNumberPicker picker = new RandomNumberPicker();
        // when
        int peek = picker.peek();
        // then
        assertThat(peek).isBetween(MIN_NUMBER, MAX_NUMBER);
    }

}