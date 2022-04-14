package baseball.domain;

import baseball.config.BaseballConfig;

public class InningStatus {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void record(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike += 1;
        }
        if (ballStatus.isBall()) {
            ball += 1;
        }
    }

    public void applyStatus(InningStatus innerStatus) {
        strike += innerStatus.getStrike();
        ball += innerStatus.getBall();
    }

    public boolean continueInning() {
        return strike != BaseballConfig.NUMBER_SIZE;
    }

}
