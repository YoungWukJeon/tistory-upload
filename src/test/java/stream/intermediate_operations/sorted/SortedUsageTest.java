package stream.intermediate_operations.sorted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedUsageTest {
    private final SortedUsage sortedUsage = new SortedUsage();
    private final List<Student> students = List.of(
            new Student(1, "hong", 75, 90, 80),
            new Student(2, "sujin", 50, 90, 100),
            new Student(3, "kate", 90, 75, 75),
            new Student(4, "tae", 100, 100, 100),
            new Student(5, "lob", 75, 75, 100));

    @Test
    @DisplayName("짝수 오름차순으로 정렬하기")
    void getEvenNumbersOrderByTest() {
        final var numbers = List.of(5, 2, 3, 9, 4);
        final var expected = List.of(2, 4);
        final var result = sortedUsage.getEvenNumbersOrderBy(numbers);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("문자열 내림차순으로 정렬하기")
    void getStringsOrderByDescTest() {
        final var strings = List.of("banana", "orange", "apple");
        final var expected = List.of("orange", "banana", "apple");
        final var result = sortedUsage.getStringsOrderByDesc(strings);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("학생들 총점순으로 내림차순 정렬하기")
    void getStudentsOrderByDescTest() {
        final var expected = List.of(
                new Student(4, "tae", 100, 100, 100),
                new Student(5, "lob", 75, 75, 100),
                new Student(1, "hong", 75, 90, 80),
                new Student(2, "sujin", 50, 90, 100),
                new Student(3, "kate", 90, 75, 75));
        final var result = sortedUsage.getStudentsOrderByDesc(students);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("학생들 수학 점수순으로 내림차순 정렬하기")
    void getStudentsOrderByMathScoreDescTest() {
        final var expected = List.of(
                new Student(4, "tae", 100, 100, 100),
                new Student(1, "hong", 75, 90, 80),
                new Student(2, "sujin", 50, 90, 100),
                new Student(3, "kate", 90, 75, 75),
                new Student(5, "lob", 75, 75, 100));
        final var result = sortedUsage.getStudentsOrderByMathScoreDesc(students);
        assertIterableEquals(expected, result);
    }
}
