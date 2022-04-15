package baseball.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.config.BaseballConfig;
import baseball.domain.BallStatus;
import baseball.domain.Inning;
import baseball.domain.InningStatus;
import baseball.domain.Pitcher;
import baseball.message.ErrorMessage;
import baseball.message.UIMessages;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayGrounds {

    public static List<Integer> convertStringToNumbers(String inputValue) {
        List<Integer> numbers = new ArrayList<>();
        int givenValueLength = inputValue.length();
        for (int i = 0; i < givenValueLength; i++) {
            numbers.add(Integer.parseInt(String.valueOf(inputValue.charAt(i))));
        }
        return numbers;
    }

    public static String validateInputValue(String inputValue) {
        int inputLength = inputValue.length();
        if (inputLength < BaseballConfig.NUMBER_SIZE || inputLength > BaseballConfig.NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.VALIDATE_LENGTH);
        }
        return inputValue;
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
            String inputString = getTypingNumber(inning);
            inningStatus = inning.compareBalls(convertStringToNumbers(inputString));
            System.out.println(getStatusMessage(inningStatus));
        } while (inningStatus.continueInning());

        System.out.println(UIMessages.END_INNING);
    }

    private String getTypingNumber(Inning inning) {
        String inputString;
        try {
            System.out.print(UIMessages.REQUIRE_NUMBERS);
            inputString = validateInputValue(readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException(ErrorMessage.END_GAME);
        }
        return inputString;
    }

    private String getStatusMessage(InningStatus inningStatus) {
        if (inningStatus.getBall() == 0 && inningStatus.getStrike() == 0) {
            return BallStatus.NOTHING.getName();
        }
        return getNotNothingMessage(inningStatus);
    }

    private String getNotNothingMessage(InningStatus inningStatus) {
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
