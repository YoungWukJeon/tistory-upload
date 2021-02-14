package lambda.quiz_3;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class QuizAnswer {
    public void quiz() {
        final ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        final BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        final Predicate<String> startsWithNumber = (String string) -> this.startsWithNumber(string);
    }

    public void answer() {
        final ToIntFunction<String> stringToInt = Integer::parseInt;
        final BiPredicate<List<String>, String> contains = List::contains;
        final Predicate<String> startsWithNumber = this::startsWithNumber;
    }

    public boolean startsWithNumber(String string) {
        return IntStream.range(0, 10)
                .mapToObj(Integer::toString)
                .anyMatch(string::startsWith);
    }
}
