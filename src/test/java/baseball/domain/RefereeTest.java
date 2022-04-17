package baseball.domain;

import baseball.domain.ball.MultipleBalls;
import baseball.domain.game.Innings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @DisplayName("타자와 투수의 볼을 보고 심판은 각 innings마다 strike와 ball을 판별한다.")
    @MethodSource
    @ParameterizedTest
    public void referee(MultipleBalls batterBalls, Innings innings, int ballCount, int strikeCount) {
        // given
        MultipleBalls pitcherBalls = new MultipleBalls();
        pitcherBalls.addBall(1);
        pitcherBalls.addBall(2);
        pitcherBalls.addBall(3);

        Referee referee = new Referee();
        // when
        referee.referee(pitcherBalls, batterBalls, innings);
        // then
        assertThat(innings.getBallCount()).isEqualTo(ballCount);
        assertThat(innings.getStrikeCount()).isEqualTo(strikeCount);
    }

    private static Stream<Arguments> referee() {
        Batter batter1 = new Batter();
        batter1.hitBall(new int[]{1, 2, 3});

        Batter batter2 = new Batter();
        batter2.hitBall(new int[]{3, 1, 2});

        Batter batter3 = new Batter();
        batter3.hitBall(new int[]{1, 4, 5});

        Batter batter4 = new Batter();
        batter4.hitBall(new int[]{4, 5, 6});

        return Stream.of(
                Arguments.of(
                        batter1.getMultipleBalls(), new Innings(), 0, 3
                ),
                Arguments.of(
                        batter2.getMultipleBalls(), new Innings(), 3, 0
                ),
                Arguments.of(
                        batter3.getMultipleBalls(), new Innings(), 0, 1
                ),
                Arguments.of(
                        batter4.getMultipleBalls(), new Innings(), 0, 0
                )
        );
    }

}