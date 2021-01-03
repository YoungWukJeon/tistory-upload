package stream.intermediate_operations.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapUsageTest {
    private final MapUsage mapUsage = new MapUsage();
    private final List<Sports> sports = List.of(
            new Sports(1, "걷기", 40, false),
            new Sports(2, "스쿼시", 126, true),
            new Sports(3, "런닝머신", 110, true),
            new Sports(4, "등산", 84, false));
    private final List<ProductEntity> productEntities = List.of(
            new ProductEntity(1L, "Aventador", "CAR", LocalDate.of(2018, 3, 28)),
            new ProductEntity(2L, "Ramen", "FOOD", LocalDate.of(2001, 4, 11)),
            new ProductEntity(3L, "Lego", "TOY", LocalDate.of(1980, 11, 5)),
            new ProductEntity(4L, "Veyron", "CAR", LocalDate.of(2009, 12, 9)),
            new ProductEntity(5L, "Modern Java in Action", "BOOK", LocalDate.of(2019, 8, 1)));

    @Test
    @DisplayName("문자열을 문자열 길이로 변환(String -> Integer)")
    void getLengthTest() {
        final var strings = List.of("banana", "apple", "orange");
        final var expected = List.of(6, 5, 6);
        final var result = mapUsage.getLength(strings);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("정수를 문자열로 변환(int -> String)")
    void generateStringsTest() {
        final var expected = List.of("waiting-0", "waiting-1", "waiting-2");
        final var result = mapUsage.generateStrings("waiting-", 3);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("실외 스포츠들의 이름 가져오기(Sports -> String)")
    void getSportsNamesByIndoorTest() {
        final var expected = List.of("걷기", "등산");
        final var result = mapUsage.getSportsNamesByIndoor(sports, false);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("스포츠들의 칼로리 평균 구하기(Sports -> int)")
    void getAverageTest() {
        final var expected = 90.0;
        final var result = mapUsage.getAverage(sports);
        assertTrue(result.isPresent());
        assertEquals(expected, result.getAsDouble());
    }

    @Test
    @DisplayName("문자열 대문자로 변환(String -> String)")
    void getUpperStringsTest() {
        final var strings = List.of("banana", "apple", "orange");
        final var expected = List.of("BANANA", "APPLE", "ORANGE");
        final var result = mapUsage.getUpperStrings(strings);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("상품(Entity)에서 자동차(CAR)를 분류한 후 DTO로 변환(ProductEntity -> Car)")
    void getCarsFromProductEntitiesTest() {
        final var expected = List.of(
                new Car(1L, "Aventador", LocalDate.of(2018, 3, 28)),
                new Car(4L, "Veyron", LocalDate.of(2009, 12, 9)));
        final var result = mapUsage.getCarsFromProductEntities(productEntities);
        assertIterableEquals(expected, result);
    }
}