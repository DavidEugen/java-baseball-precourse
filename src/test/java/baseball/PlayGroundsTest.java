package baseball;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayGroundsTest {

    private PlayGrounds playGrounds;

    @BeforeEach
    void setUp() {
        //given
        playGrounds = new PlayGrounds();
    }

    @Test
    @DisplayName("입력받은 문자를 IntegerList 로 변환")
    void 입력받은_문자_Integer_List_로_변환() {
        //given
        String givenValue = "123";
        //when
        List<Integer> playerNumber = playGrounds.convertStringToNumbers(givenValue);
        //then
        Assertions.assertThat(playerNumber.equals(Arrays.asList(1, 2, 3))).isTrue();
    }


}
