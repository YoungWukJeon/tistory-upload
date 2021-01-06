package stream.intermediate_operations.peek;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PeekUsage {
    public List<Integer> getCommonMultipleAAndBUntilN(int a, int b, int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> i % a == 0)
                .peek(i -> System.out.println(a + "의 배수: " + i))
                .filter(i -> i % b == 0)
                .peek(i -> System.out.println(a + "와 " + b + "의 공배수: " + i))
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Address> makeFullNameInAddress(List<Address> addresses) {
        return addresses.stream()
                .peek(a -> a.setFullName(a.getSi() + " " + a.getGu() + " " + a.getDong()))
                .collect(Collectors.toList());
    }
}
