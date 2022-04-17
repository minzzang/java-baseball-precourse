package baseball.domain.picker;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.config.BaseBallConfig.*;

public class RandomNumberPicker implements NumberPicker {

    @Override
    public int peek() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
