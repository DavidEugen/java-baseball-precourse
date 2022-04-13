package baseball.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        //given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인하는 테스트")
    void setSizeTest() {
        //when
        int numberSize = numbers.size();
        //then
        assertThat(numberSize).isEqualTo(3);
    }

    @Test
    @DisplayName("Set 의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인")
    void containsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인 - ParameterizedTest")
    public void parameterizedTest(int input) {
        //when
        boolean contains = numbers.contains(input);

        //then
        assertThat(contains).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("1,2,3 은 테스트가 성공하도록 4, 5일 경우 테스트가 실패하도록 구현")
    public void csvSourceTest(int input, boolean expected) {
        //when
        boolean contains = numbers.contains(input);

        //then
        assertThat(contains).isEqualTo(expected);
    }

}
