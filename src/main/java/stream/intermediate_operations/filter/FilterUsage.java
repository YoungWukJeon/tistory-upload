package stream.intermediate_operations.filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterUsage {
    public List<Person> getPeopleByAgeGreaterThanEqual(List<Person> people, int age) {
        return people.stream()
                .filter(p -> p.age() >= age)
                .collect(Collectors.toList());
    }

    public List<Person> getPeopleByGenderNot(List<Person> people, int gender) {
        return people.stream()
                .filter(Predicate.not(p -> p.gender() == gender))
                .collect(Collectors.toList());
    }

    public List<Person> getPeopleByNationAndAgeGreaterThanEqual(List<Person> people, Nation nation, int age) {
        return people.stream()
                .filter(p -> p.nation() == nation)
                .filter(p -> p.age() >= age)
                .collect(Collectors.toList());
    }
}
