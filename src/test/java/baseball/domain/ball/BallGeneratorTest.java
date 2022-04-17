package baseball.domain.ball;

import baseball.domain.picker.ArrayNumberPicker;
import baseball.domain.picker.NumberPicker;
import baseball.domain.picker.RandomNumberPicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BallGeneratorTest {

    @DisplayName("볼을 생성하면 완성된 MultipleBalls를 리턴한다.")
    @MethodSource
    @ParameterizedTest
    public void generate(NumberPicker numberPicker) {
        // given
        BallGenerator ballGenerator = new BallGenerator(numberPicker);
        // when
        MultipleBalls balls = ballGenerator.generate();
        // then
        assertThat(balls.isCompleted()).isTrue();
    }

    private static Stream<Arguments> generate() {
        return Stream.of(
                Arguments.of(
                    new RandomNumberPicker()
                ),
                Arguments.of(
                    new ArrayNumberPicker(new int[] {1, 2, 3})
                )
        );
    }

}