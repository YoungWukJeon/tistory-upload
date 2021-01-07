package stream.intermediate_operations.sorted;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedUsage {
    public List<Integer> getEvenNumbersOrderBy(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getStringsOrderByDesc(List<String> strings) {
        return strings.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsOrderByDesc(List<Student> students) {
        return students.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsOrderByMathScoreDesc(List<Student> students) {
        return students.stream()
                .sorted((a, b) -> b.mathScore() - a.mathScore())
                .collect(Collectors.toList());
    }
}
