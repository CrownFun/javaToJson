package pl.filewicz.playlist;

public class Item {

    private int position;
    private Track track;

    public Item(int position, Track track) {
        this.position = position;
        this.track = track;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
