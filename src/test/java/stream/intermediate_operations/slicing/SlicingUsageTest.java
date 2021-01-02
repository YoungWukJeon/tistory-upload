package stream.intermediate_operations.slicing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlicingUsageTest {
    private final SlicingUsage slicingUsage = new SlicingUsage();
    private final List<Song> songs = List.of(
            new Song(1, "밤편지", "아이유", 393_424, LocalDate.of(2017, 3,24)),
            new Song(2, "Love poem", "아이유", 280_586, LocalDate.of(2019, 11,1)),
            new Song(3, "Blueming", "아이유", 280_323, LocalDate.of(2019, 11,18)),
            new Song(4, "삐삐", "아이유", 264_664, LocalDate.of(2018, 10,10)),
            new Song(5, "가을 아침", "아이유", 257_136, LocalDate.of(2017, 9,22)),
            new Song(6, "팔레트", "아이유", 244_865, LocalDate.of(2017, 4,21)));

    @Test
    @DisplayName("좋아요가 28만개 이상인 노래들 조회")
    void getSongsWithTakeWhileTest() {
        final var result = slicingUsage.getSongsWithTakeWhile(songs, i -> i.likeCount() >= 280_000);
        result.forEach(System.out::println);
        assertEquals(3, result.size());
        assertEquals("밤편지", result.get(0).title());
        assertEquals("Love poem", result.get(1).title());
        assertEquals("Blueming", result.get(2).title());
    }

    @Test
    @DisplayName("좋아요가 28만개 이상인 노래를 제외한 나머지 노래들 조회")
    void getSongsWithDropWhileTest() {
        final var result = slicingUsage.getSongsWithDropWhile(songs, i -> i.likeCount() >= 280_000);
        result.forEach(System.out::println);
        assertEquals(3, result.size());
        assertEquals("삐삐", result.get(0).title());
        assertEquals("가을 아침", result.get(1).title());
        assertEquals("팔레트", result.get(2).title());
    }

    @Test
    @DisplayName("상위 2개 노래들 조회")
    void getSongsWithLimitTest() {
        final var result = slicingUsage.getSongsWithLimit(songs, 2);
        result.forEach(System.out::println);
        assertEquals(2, result.size());
        assertEquals("밤편지", result.get(0).title());
        assertEquals("Love poem", result.get(1).title());
    }

    @Test
    @DisplayName("상위 n개를 제외한 나머지 노래들 조회")
    void getSongsWithSkipTest() {
        final var result = slicingUsage.getSongsWithSkip(songs, 4);
        result.forEach(System.out::println);
        assertEquals(2, result.size());
        assertEquals("가을 아침", result.get(0).title());
        assertEquals("팔레트", result.get(1).title());
    }
}
