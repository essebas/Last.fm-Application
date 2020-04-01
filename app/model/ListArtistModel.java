package co.sebasdeveloper.pruebavalid2.model;

import java.util.ArrayList;
import java.util.List;



public class ListArtistModel {
    private List<ArtistModel> artist;

    public ListArtistModel() {
        this.artist = new ArrayList<>();
    }

    public ListArtistModel(List<ArtistModel> artist) {
        this.artist = artist;
    }

    public List<ArtistModel> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistModel> artist) {
        this.artist = artist;
    }
}
