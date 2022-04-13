package baseball;

public class InningStatus {

    private int strike = 0;

    public int getStrike() {
        return strike;
    }

    public void record(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE) {
            strike += 1;
        }
    }
}
