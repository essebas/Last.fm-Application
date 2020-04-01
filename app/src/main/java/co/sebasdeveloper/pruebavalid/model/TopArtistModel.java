package co.sebasdeveloper.pruebavalid.model;

import java.util.ArrayList;
import java.util.List;

public class TopArtistModel {
    private List<ArtistModel> artist;
    private AttrModel attr;

    public TopArtistModel() {
        this.artist = new ArrayList<>();
    }

    public TopArtistModel(List<ArtistModel> artist, AttrModel attr) {
        this.artist = artist;
        this.attr = attr;
    }

    public List<ArtistModel> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistModel> artist) {
        this.artist = artist;
    }

    public AttrModel getAttr() {
        return attr;
    }

    public void setAttr(AttrModel attr) {
        this.attr = attr;
    }
}
