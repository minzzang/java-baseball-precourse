package baseball.domain.ball;

import baseball.domain.picker.NumberPicker;

public class BallGenerator {

    private NumberPicker numberPicker;

    public BallGenerator(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public MultipleBalls generate() {
        MultipleBalls balls = new MultipleBalls();

        while (!balls.isCompleted()) {
            int ball = numberPicker.peek();
            balls.addBall(ball);
        }
        return balls;
    }

}
