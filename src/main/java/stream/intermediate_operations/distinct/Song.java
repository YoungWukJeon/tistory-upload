package stream.intermediate_operations.distinct;

public class Song {
    private final int no;
    private final String title;
    private final String albumName;
    private final String artist;

    public Song(int no, String title, String albumName, String artist) {
        this.no = no;
        this.title = title;
        this.albumName = albumName;
        this.artist = artist;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public boolean equals(Object song) {
        return getClass() == song.getClass() && artist.equals(((Song) song).artist);
    }

    @Override
    public String toString() {
        return "Song{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", albumName='" + albumName + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
