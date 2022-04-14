package baseball.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.ui.PlayGrounds;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayGroundsTest {

    @Test
    @DisplayName("입력받은 문자를 IntegerList 로 변환")
    void 입력받은_문자_Integer_List_로_변환() {
        //given
        String givenValue = "123";
        //when
        List<Integer> playerNumber = PlayGrounds.convertStringToNumbers(givenValue);
        //then
        assertThat(playerNumber.equals(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    @DisplayName("입력받는 값의 유효성을 검증한다 - 자리수 검증")
    void 입력받은_문자_자리수_검증() {
        //given
        String givenValue = "1234";
        //when
        assertThatThrownBy(() -> PlayGrounds.validateInputValue(givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
