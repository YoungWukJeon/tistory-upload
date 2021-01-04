package stream.intermediate_operations.flatmap;

import java.time.LocalDate;

public record AccessLog(Long no, String ip, LocalDate accessedAt, long responseTime) {
}
