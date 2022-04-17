package baseball.domain.picker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayNumberPickerTest {

    @DisplayName("ArrayNumberPicker에서 순차적으로 요소를 가져온다.")
    @Test
    public void peek() {
        // given
        int[] arr = {1, 2, 3};
        ArrayNumberPicker picker = new ArrayNumberPicker(arr);
        // when
        int peekFirst = picker.peek();
        int peekSecond = picker.peek();
        int peekThird = picker.peek();
        // then
        assertThat(arr[0]).isEqualTo(peekFirst);
        assertThat(arr[1]).isEqualTo(peekSecond);
        assertThat(arr[2]).isEqualTo(peekThird);
    }

    @DisplayName("인덱스가 넘어가는 값을 가져오면 예외가 발생한다.")
    @Test
    public void peekNotInTheRange() {
        // given
        int[] arr = {1};
        ArrayNumberPicker picker = new ArrayNumberPicker(arr);
        // when

        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> {
            picker.peek();
            picker.peek();
        });
        // then
        assertThat(illegalStateException.getMessage()).isEqualTo("더 이상 뽑을 숫자가 없습니다.");
    }
}