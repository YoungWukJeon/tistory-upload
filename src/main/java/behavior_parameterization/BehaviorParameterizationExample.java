package behavior_parameterization;

import java.util.ArrayList;
import java.util.List;

import static behavior_parameterization.Color.GREEN;

public class BehaviorParameterizationExample {
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        final var result = new ArrayList<Apple>();
        for (final var apple : inventory) {
            if (GREEN.equals(apple.color())) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        final var result = new ArrayList<Apple>();
        for (final var apple : inventory) {
            if (color.equals(apple.color())) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        final var result = new ArrayList<Apple>();
        for (final var apple : inventory) {
            if (apple.weight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        final var result = new ArrayList<Apple>();
        for (final var apple : inventory) {
            if ((flag && apple.color().equals(color)) ||
                    (!flag && apple.weight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        final var result = new ArrayList<Apple>();
        for (final var apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
