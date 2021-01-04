package stream.intermediate_operations.flatmap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatMapUsageTest {
    private final FlatMapUsage flatMapUsage = new FlatMapUsage();
    private final List<User> users = List.of(
            new User(1L, "alpha", List.of(
                    new AccessLog(1L, "192.168.0.1", LocalDate.of(2015, 11, 30), 10),
                    new AccessLog(3L, "192.168.0.2", LocalDate.of(2018, 3, 3), 20),
                    new AccessLog(7L, "192.168.0.3", LocalDate.of(2020, 7, 15), 100))),
            new User(2L, "beta", List.of(
                    new AccessLog(2L, "192.168.0.4", LocalDate.of(2018, 3, 3), 25),
                    new AccessLog(4L, "192.168.0.5", LocalDate.of(2019, 8, 23), 17),
                    new AccessLog(6L, "192.168.0.6", LocalDate.of(2020, 5, 1), 80))),
            new User(3L, "gamma", List.of(
                    new AccessLog(5L, "192.168.0.7", LocalDate.of(2020, 2, 25), 150),
                    new AccessLog(8L, "192.168.0.8", LocalDate.of(2020, 8, 5), 200),
                    new AccessLog(9L, "192.168.0.9", LocalDate.of(2021, 1, 5), 55))));

    @Test
    @DisplayName("문자열 리스트를 한글자씩 분리해서 고유 문자들만 반환")
    void getAllDistinctStringsTest() {
        final var strings = List.of("Happy", "New", "Year");
        final var expected = List.of("H", "a", "p",  "y", "N", "e", "w", "Y", "r");
        final var result = flatMapUsage.getAllDistinctStrings(strings);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("특정 날짜 이후에 접속한 유저의 ip 조회")
    void getIpByAccessedAtAfterTest() {
        final var accessedAt = LocalDate.of(2020, 1, 1);
        final var expected = List.of("192.168.0.3", "192.168.0.6", "192.168.0.7", "192.168.0.8", "192.168.0.9");
        final var result = flatMapUsage.getIpByAccessedAtAfter(users, accessedAt);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("모든 유저의 평균 응답 시간 구하기")
    void getAverageResponseTimeTest() {
        final var expected = 73.0;
        final var result = flatMapUsage.getAverageResponseTime(users);
        assertTrue(result.isPresent());
        assertEquals(expected, result.getAsDouble());
    }
}
