package stream.intermediate_operations.slicing;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SlicingUsage {
    public List<Song> getSongsWithTakeWhile(List<Song> songs, Predicate<Song> predicate) {
        return songs.stream()
                .takeWhile(predicate)
                .collect(Collectors.toList());
    }

    public List<Song> getSongsWithDropWhile(List<Song> songs, Predicate<Song> predicate) {
        return songs.stream()
                .dropWhile(predicate)
                .collect(Collectors.toList());
    }

    public List<Song> getSongsWithLimit(List<Song> songs, int size) {
        return songs.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public List<Song> getSongsWithSkip(List<Song> songs, int offset) {
        return songs.stream()
                .skip(offset)
                .collect(Collectors.toList());
    }
}
