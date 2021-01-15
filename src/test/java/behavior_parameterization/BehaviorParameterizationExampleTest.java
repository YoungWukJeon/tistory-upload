package behavior_parameterization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BehaviorParameterizationExampleTest {
    private final BehaviorParameterizationExample behaviorParameterizationExample = new BehaviorParameterizationExample();
    private final List<Apple> inventory = List.of(
            new Apple(Color.GREEN, 200),
            new Apple(Color.GREEN, 220),
            new Apple(Color.RED, 180),
            new Apple(Color.GREEN, 200),
            new Apple(Color.RED, 190));

    @Test
    @DisplayName("녹색 사과 필터링")
    void filterGreenApplesTest() {
        final var expected = List.of(
                new Apple(Color.GREEN, 200),
                new Apple(Color.GREEN, 220),
                new Apple(Color.GREEN, 200));
        final var result = behaviorParameterizationExample.filterGreenApples(inventory);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("색 별로 사과 필터링(색을 파라미터화)")
    void filterApplesByColorTest() {
        final var greenExpected = List.of(
                new Apple(Color.GREEN, 200),
                new Apple(Color.GREEN, 220),
                new Apple(Color.GREEN, 200));
        final var redExpected = List.of(
                new Apple(Color.RED, 180),
                new Apple(Color.RED, 190));
        final var greenApples = behaviorParameterizationExample.filterApplesByColor(inventory, Color.GREEN);
        final var redApples = behaviorParameterizationExample.filterApplesByColor(inventory, Color.RED);
        assertIterableEquals(greenExpected, greenApples);
        assertIterableEquals(redExpected, redApples);
    }

    @Test
    @DisplayName("무게로 사과 필터링(무게를 파라미터화)")
    void filterApplesByWeightTest() {
        final var expected = List.of(new Apple(Color.GREEN, 220));
        final var result = behaviorParameterizationExample.filterApplesByWeight(inventory, 200);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("가능한 모든 속성으로 필터링")
    void filterApplesTest() {
        final var greenExpected = List.of(
                new Apple(Color.GREEN, 200),
                new Apple(Color.GREEN, 220),
                new Apple(Color.GREEN, 200));
        final var heavyExpected = List.of(new Apple(Color.GREEN, 220));
        final var greenApples = behaviorParameterizationExample.filterApples(inventory, Color.GREEN, 0, true);
        final var heavyApples = behaviorParameterizationExample.filterApples(inventory, null, 200, false);
        assertIterableEquals(greenExpected, greenApples);
        assertIterableEquals(heavyExpected, heavyApples);
    }

    @Test
    @DisplayName("추상적 조건으로 필터링")
    void filterApplesWithApplePredicateTest() {
        final var expected = List.of(new Apple(Color.RED, 190));
        final var result = behaviorParameterizationExample.filterApples(inventory, new AppleRedAndHeavyPredicate());
        assertIterableEquals(expected, result);
    }
}