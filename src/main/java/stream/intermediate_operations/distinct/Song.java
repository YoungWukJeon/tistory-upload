package stream.intermediate_operations.distinct;

public record Song(int no, String title, String albumName, String artist) {
    @Override
    public boolean equals(Object song) {
        return getClass() == song.getClass() && artist.equals(((Song) song).artist);
    }

    @Override
    public int hashCode() {
        return artist.hashCode();
    }
}
