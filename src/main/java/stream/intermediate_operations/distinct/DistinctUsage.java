package stream.intermediate_operations.distinct;

import java.util.List;
import java.util.stream.Collectors;

public class DistinctUsage {
    public List<Integer> getDistinctNumbers(List<Integer> lists) {
        return lists.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Song> getSongsWithDistinctArtist(List<Song> songs) {
        return songs.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
