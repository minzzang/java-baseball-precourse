package baseball.domain;

public class Innings {

    private int strikeCount;
    private int ballCount;

    public void strike() {
        strikeCount++;
    }

    public void ball() {
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void init() {
        strikeCount = 0;
        ballCount = 0;
    }
}
