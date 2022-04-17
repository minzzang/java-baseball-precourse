package baseball.domain.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.config.BaseBallConfig.BALL_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultipleBallsTest {

    @DisplayName("볼 추가하기")
    @Test
    public void addBall() {
        // given
        MultipleBalls multipleBalls = new MultipleBalls();

        int ball = 3;
        multipleBalls.addBall(ball);
        // when
        int findBall = multipleBalls.findByIndex(0);
        // then
        assertThat(ball).isEqualTo(findBall);
    }

    @DisplayName("중복된 볼은 추가되지 않는다.")
    @Test
    public void addBallWithDuplicate() {
        // given
        MultipleBalls multipleBalls = new MultipleBalls();

        int ball = 3;
        multipleBalls.addBall(ball);
        multipleBalls.addBall(ball);
        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            multipleBalls.findByIndex(1)
        );
        // then
        assertThat(exception.getMessage()).isEqualTo("잘못된 인덱스 범위입니다.");
    }

    @DisplayName("게임에서 지정한 볼 사이즈보다 많은 볼을 추가할 수 없다.")
    @Test
    public void canNotAddBall() {
        // given
        MultipleBalls multipleBalls = new MultipleBalls();
        // when
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
            addMoreBallThanBallSize(multipleBalls)
        );
        // then
        assertThat(exception.getMessage()).isEqualTo(BALL_SIZE + "보다 많은 볼을 추가할 수 없습니다.");
    }

    private void addMoreBallThanBallSize(MultipleBalls multipleBalls) {
        for (int i = 0; i <= BALL_SIZE; i++) {
            multipleBalls.addBall(i);
        }
    }

}