package stream.intermediate_operations.flatmap;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FlatMapUsage {
    public List<String> getAllDistinctStrings(List<String> strings) {
        return strings.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getIpByAccessedAtAfter(List<User> users, LocalDate accessedAt) {
        return users.stream()
                .map(User::accessLogs)
                .flatMap(l -> l.stream()
                        .filter(a -> a.accessedAt().isAfter(accessedAt))
                        .map(AccessLog::ip))
                .collect(Collectors.toList());
    }

    public OptionalDouble getAverageResponseTime(List<User> users) {
        return users.stream()
                .map(User::accessLogs)
                .flatMapToLong(l -> l.stream()
                        .mapToLong(AccessLog::responseTime))
                .average();
    }
}
