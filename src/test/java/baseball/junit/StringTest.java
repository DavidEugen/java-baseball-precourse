package baseball.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("1,2 를 ,로 Split 했을때 1과 2로 잘 분리 되는지 확인한다.")
    void splitTest1() {
        //given
        String givenValue = "1,2";
        //when
        String[] splitArray = givenValue.split(",");
        //then
        assertThat(splitArray.length).isEqualTo(2);
        assertThat(splitArray).contains("1");
        assertThat(splitArray).contains("2");
        assertThat(splitArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1 을 ,로 Split 했을때 1만 포함된 배열 분리 되는지 확인한다.")
    void splitTest2() {
        //given
        String givenValue = "1";
        //when
        String[] splitArray = givenValue.split(",");
        //then
        assertThat(splitArray.length).isEqualTo(1);
        assertThat(splitArray).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어 졌을때 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하는가")
    void substringTest2() {
        //given
        String givenValue = "(1,2)";
        //when
        String resultString = givenValue.substring(1, givenValue.length() - 1);
        //then
        assertThat(resultString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어 졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void charAtTest() {
        //given
        String givenValue = "abc";
트
        //when //then
        assertThat(givenValue.charAt(0)).isEqualTo('a');
        assertThat(givenValue.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> givenValue.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

}
