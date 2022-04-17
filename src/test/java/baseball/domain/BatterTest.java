package baseball.domain;

import baseball.domain.ball.MultipleBalls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BatterTest {

    @DisplayName("타자가 입력 받은 공을 치면 3개의 공이 세팅된다.")
    @Test
    public void hitBall() {
        // given
        int[] balls = {1, 2, 3};
        Batter batter = new Batter();
        // when
        batter.hitBall(balls);
        // then
        MultipleBalls multipleBalls = batter.getMultipleBalls();
        Assertions.assertThat(multipleBalls.isCompleted()).isTrue();
    }

}