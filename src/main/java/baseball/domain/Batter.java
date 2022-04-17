package baseball.domain;

import baseball.domain.ball.BallGenerator;
import baseball.domain.ball.MultipleBalls;
import baseball.domain.picker.ArrayNumberPicker;
import baseball.domain.picker.NumberPicker;

public class Batter {

    private MultipleBalls multipleBalls;

    public void hitBall(int[] balls) {
        NumberPicker numberPicker = new ArrayNumberPicker(balls);
        BallGenerator ballGenerator = new BallGenerator(numberPicker);

        multipleBalls = ballGenerator.generate();
    }

    public MultipleBalls getMultipleBalls() {
        if (multipleBalls == null) {
            throw new IllegalStateException("타자가 아직 준비가 안되었습니다.");
        }
        return multipleBalls;
    }
}
