package baseball.domain;

import baseball.domain.ball.BallGenerator;
import baseball.domain.ball.MultipleBalls;
import baseball.domain.picker.NumberPicker;
import baseball.domain.picker.RandomNumberPicker;

public class Pitcher {

    private MultipleBalls multipleBalls;

    public void throwBall() {
        NumberPicker numberPicker = new RandomNumberPicker();
        BallGenerator ballGenerator = new BallGenerator(numberPicker);

        multipleBalls = ballGenerator.generate();
    }

    public MultipleBalls getMultipleBalls() {
        if (multipleBalls == null) {
            throw new IllegalStateException("투수가 아직 준비가 안되었습니다.");
        }
        return multipleBalls;
    }
}
