package stream.intermediate_operations.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterUsageTest {
    private final FilterUsage filterUsage = new FilterUsage();
    private final List<Person> people = List.of(
            new Person(1, "hong", 15, Nation.CHINA, 1),
            new Person(2, "kim", 20, Nation.KOREA, 0),
            new Person(3, "miya", 18, Nation.JAPAN, 1),
            new Person(4, "hong", 30, Nation.USA, 0));

    @Test
    @DisplayName("특정 나이 이상의 사람들 조회")
    void getPeopleByAgeGreaterThanEqualTest() {
        final var result = filterUsage.getPeopleByAgeGreaterThanEqual(people, 20);
        result.forEach(System.out::println);
        assertEquals(2, result.size());
        assertEquals("kim", result.get(0).name());
        assertEquals("hong", result.get(1).name());
    }

    @Test
    @DisplayName("특정 나이 이상의 사람들 조회(필터 결과가 없음)")
    void getPeopleByAgeGreaterThanEqualWithEmptyResultTest() {
        final var result = filterUsage.getPeopleByAgeGreaterThanEqual(people, 40);
        result.forEach(System.out::println);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    @DisplayName("특정 성별이 아닌 사람들 조회")
    void getPeopleByGenderNotTest() {
        // 0: Male, 1: Female
        final var result = filterUsage.getPeopleByGenderNot(people, 0);
        result.forEach(System.out::println);
        assertEquals(2, result.size());
        assertEquals("hong", result.get(0).name());
        assertEquals("miya", result.get(1).name());
    }

    @Test
    @DisplayName("특정 나라에 살고 특정 나이 이상인 사람들 조회")
    void getPeopleByNationAndAgeGreaterThanEqualTest() {
        final var result = filterUsage.getPeopleByNationAndAgeGreaterThanEqual(people, Nation.KOREA, 15);
        result.forEach(System.out::println);
        assertEquals(1, result.size());
        assertEquals("kim", result.get(0).name());
    }
}