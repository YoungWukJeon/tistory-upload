package stream.intermediate_operations.map;

import java.time.LocalDate;

public record ProductEntity(Long id, String name, String category, LocalDate createdAt) {
}
