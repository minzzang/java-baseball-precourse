package baseball.domain;

import baseball.domain.ball.MultipleBalls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PitcherTest {

    @DisplayName("투수가 공을 던지면 3개의 공이 세팅된다.")
    @Test
    public void throwBall() {
        // given
        Pitcher pitcher = new Pitcher();
        // when
        pitcher.throwBall();
        // then
        MultipleBalls multipleBalls = pitcher.getMultipleBalls();
        Assertions.assertThat(multipleBalls.isCompleted()).isTrue();
    }

}