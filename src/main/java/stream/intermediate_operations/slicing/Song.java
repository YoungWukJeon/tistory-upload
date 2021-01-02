package stream.intermediate_operations.slicing;

import java.time.LocalDate;

public record Song(int no, String title, String artist, int likeCount, LocalDate releasedDate) {
}
