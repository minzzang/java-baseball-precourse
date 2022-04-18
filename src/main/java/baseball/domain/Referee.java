package baseball.domain;

import baseball.domain.ball.MultipleBalls;

import static baseball.config.BaseBallConfig.BALL_SIZE;

public class Referee {

    public void referee(MultipleBalls pitcherBalls, MultipleBalls batterBalls, Innings innings) {
        for (int i = 0; i < BALL_SIZE; i++) {
            int pitcherNumber = pitcherBalls.findByIndex(i);
            int batterNumber = batterBalls.findByIndex(i);

            checkStrike(pitcherNumber, batterNumber, innings);
            checkBall(pitcherBalls, pitcherNumber, batterNumber, innings);
        }
    }

    private void checkStrike(int pitcherNumber, int batterNumber, Innings innings) {
        if (pitcherNumber == batterNumber) {
            innings.strike();
        }
    }

    private void checkBall(MultipleBalls pitcherBalls, int pitcherNumber, int batterNumber, Innings innings) {
        if (pitcherNumber == batterNumber) {
            return;
        }
        if (pitcherBalls.contains(batterNumber)) {
            innings.ball();
        }
    }

    public boolean isEnded(Innings innings) {
        if (innings == null) {
            return false;
        }

        return innings.getBallCount() == 0
                && innings.getStrikeCount() == BALL_SIZE;
    }
}
