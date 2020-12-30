package stream.intermediate_operations.distinct;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistinctUsageTest {
    private final DistinctUsage distinctUsage = new DistinctUsage();
    private final List<Song> songs = List.of(
            new Song(1, "Bohemian Rhapsody", "A Night at the Opera", "Queen"),
            new Song(2, "2002", "Speak Your Mind", "Anne-Marie"),
            new Song(3, "Blueming", "Love Poem", "IU"),
            new Song(4, "Love Poem", "Love Poem", "IU"));

    @Test
    @DisplayName("중복 숫자 제거")
    void getDistinctNumbersTest() {
        final var expect = List.of(1, 2, 8, 4);
        final var result = distinctUsage.getDistinctNumbers(List.of(1, 2, 2, 8, 4, 1, 4));
        assertIterableEquals(expect, result);
    }

    @Test
    @DisplayName("중복된 가수 이름 제거")
    void getSongsWithDistinctAlbumNameTest() {
        final var result = distinctUsage.getSongsWithDistinctArtist(songs);
        result.forEach(System.out::println);
        assertEquals(3, result.size());
        assertEquals("Bohemian Rhapsody", result.get(0).getTitle());
        assertEquals("2002", result.get(1).getTitle());
        assertEquals("Blueming", result.get(2).getTitle());
    }

    @Test
    @DisplayName("")
    void test3() {

    }

    @Test
    @DisplayName("")
    void test4() {

    }
}