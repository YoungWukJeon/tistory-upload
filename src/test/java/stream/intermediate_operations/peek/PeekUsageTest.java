package stream.intermediate_operations.peek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeekUsageTest {
    private final PeekUsage peekUsage = new PeekUsage();
    private final List<Address> addresses = List.of(
            new Address(1, "서울시", "관악구", "신림동", null),
            new Address(2, "서울시", "강남구", "논현동", null),
            new Address(3, "서울시", "동작구", "사당동", null),
            new Address(4, "서울시", "서초구", "양재동", null));

    @Test
    @DisplayName("두 수의 공배수 구하기")
    void getCommonMultipleAAndBUntilNTest() {
        final var expected = List.of(6, 12);
        final var result = peekUsage.getCommonMultipleAAndBUntilN(2, 3, 15);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("주소 풀네임 조합하기")
    void getEvenNumbersCountTest() {
        final var expected = List.of(
                new Address(1, "서울시", "관악구", "신림동", "서울시 관악구 신림동"),
                new Address(2, "서울시", "강남구", "논현동", "서울시 강남구 논현동"),
                new Address(3, "서울시", "동작구", "사당동", "서울시 동작구 사당동"),
                new Address(4, "서울시", "서초구", "양재동", "서울시 서초구 양재동"));
        final var result = peekUsage.makeFullNameInAddress(addresses);
        result.forEach(System.out::println);
        assertIterableEquals(expected, result);
    }
}