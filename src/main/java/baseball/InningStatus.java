package baseball;

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
        if (ballStatus == BallStatus.STRIKE) {
            strike += 1;
        }
        if (ballStatus == BallStatus.BALL) {
            ball += 1;
        }
    }

    public void applyStatus(InningStatus innerStatus) {
        strike += innerStatus.getStrike();
        ball += innerStatus.getBall();
    }
}
