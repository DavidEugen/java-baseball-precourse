package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    @ParameterizedTest
    @DisplayName("1~9까지 유효 범위 내의 숫자 인지 테스트")
    @CsvSource(value = {"-1,false", "0,false", "1,true", "9,true", "10,false"})
    void 숫자_생성_검증(int inputNumber, boolean expected) {
        boolean rightNumber = Ball.isInRangeNumber(inputNumber);
        assertThat(rightNumber).isEqualTo(expected);
    }

}
