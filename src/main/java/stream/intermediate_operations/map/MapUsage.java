package stream.intermediate_operations.map;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapUsage {
    public List<Integer> getLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public List<String> generateStrings(String prefix, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> prefix + i)
                .collect(Collectors.toList());
    }

    public List<String> getSportsNamesByIndoor(List<Sports> sports, boolean isIndoor) {
        return sports.stream()
                .filter(s -> s.isIndoor() == isIndoor)
                .map(Sports::name)
                .collect(Collectors.toList());
    }

    public OptionalDouble getAverage(List<Sports> sports) {
        return sports.stream()
                .mapToInt(Sports::burnedCalories)
                .average();
    }

    public List<String> getUpperStrings(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsFromProductEntities(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .filter(p -> "CAR".equals(p.category()))
                .map(p -> new Car(p.id(), p.name(), p.createdAt()))
                .collect(Collectors.toList());
    }
}
