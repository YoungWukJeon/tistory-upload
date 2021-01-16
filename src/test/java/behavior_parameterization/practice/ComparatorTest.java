package behavior_parameterization.practice;

import behavior_parameterization.Apple;
import behavior_parameterization.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTest {
    private final List<Apple> inventory = List.of(
            new Apple(Color.GREEN, 200),
            new Apple(Color.GREEN, 220),
            new Apple(Color.RED, 180),
            new Apple(Color.GREEN, 200),
            new Apple(Color.RED, 190));

    @Test
    @DisplayName("익명 클래스를 이용한 정렬")
    void comparatorUsingAnonymousClassTest() {
        final var inventory = new ArrayList<>(this.inventory);
        final var expected = List.of(
                new Apple(Color.GREEN, 220),
                new Apple(Color.GREEN, 200),
                new Apple(Color.GREEN, 200),
                new Apple(Color.RED, 190),
                new Apple(Color.RED, 180));
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return Integer.compare(a2.weight(), a1.weight());
            }
        });

        assertIterableEquals(expected, inventory);
    }

    @Test
    @DisplayName("람다를 이용한 정렬")
    void comparatorUsingLambdaTest() {
        final var inventory = new ArrayList<>(this.inventory);
        final var expected = List.of(
                new Apple(Color.GREEN, 220),
                new Apple(Color.GREEN, 200),
                new Apple(Color.GREEN, 200),
                new Apple(Color.RED, 190),
                new Apple(Color.RED, 180));
        inventory.sort((a1, a2) -> Integer.compare(a2.weight(), a1.weight()));

        assertIterableEquals(expected, inventory);
    }
}
