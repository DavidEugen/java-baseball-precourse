package baseball.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.BallStatus;
import baseball.domain.Inning;
import baseball.domain.InningStatus;
import baseball.domain.Pitcher;
import baseball.message.UIMessages;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayGrounds {

    public static List<Integer> convertStringToNumbers(String givenValue) {
        List<Integer> numbers = new ArrayList<>();
        int givenValueLength = givenValue.length();
        for (int i = 0; i < givenValueLength; i++) {
            numbers.add(Integer.parseInt(String.valueOf(givenValue.charAt(i))));
        }
        return numbers;
    }

    public void playGame() {
        String inputValue;
        do {
            playInning();
            System.out.print(UIMessages.IS_RETRY_INNING);
            inputValue = Console.readLine();
        } while (!inputValue.equals("2"));

        System.out.println(UIMessages.END_GAME);

    }

    private void playInning() {
        Inning inning = new Inning(Pitcher.generateNumbers());
        InningStatus inningStatus;
        do {
            System.out.print(UIMessages.REQUIRE_NUMBERS);
            inningStatus = inningProcess(inning);
        } while (inningStatus.continueInning());

        System.out.println(UIMessages.END_INNING);

    }

    private InningStatus inningProcess(Inning inning) {
        InningStatus inningStatus;
        inningStatus = inning.compareBalls(convertStringToNumbers(readLine()));
        System.out.println(getStatusMessage(inningStatus));
        return inningStatus;
    }

    private String getStatusMessage(InningStatus inningStatus) {
        if (inningStatus.getBall() == 0 && inningStatus.getStrike() == 0) {
            return BallStatus.NOTHING.getName();
        }

        StringBuilder statusMessage = new StringBuilder();
        if (inningStatus.getBall() != 0) {
            statusMessage.append(inningStatus.getBall()).append(BallStatus.BALL.getName()).append(" ");
        }
        if (inningStatus.getStrike() != 0) {
            statusMessage.append(inningStatus.getStrike()).append(BallStatus.STRIKE.getName());
        }

        return statusMessage.toString();
    }
}
