package stream.intermediate_operations.flatmap;

import java.util.List;

public record User(Long no, String id, List<AccessLog> accessLogs) {
}
