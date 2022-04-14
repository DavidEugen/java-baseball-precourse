package baseball.domain;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public static boolean isInRangeNumber(int number) {
        return number > 0 && number < 10;
    }

    public BallStatus compareBall(Ball oppositeBall) {
        if(oppositeBall.getPosition() == position && oppositeBall.getNumber() == number){
            return BallStatus.STRIKE;
        }
        if(oppositeBall.getPosition() != position && oppositeBall.getNumber() == number){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

}