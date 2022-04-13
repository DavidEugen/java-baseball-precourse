package baseball;

public class Ball {

    int position;
    int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public static boolean isInRangeNumber(int number) {
        return number > 0 && number < 10;
    }

    public String compareBall(Ball oppositeBall) {
        if(oppositeBall.getPosition() == position && oppositeBall.getNumber() == number){
            return "Strike";
        }
        return "ball or nothing";
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}
