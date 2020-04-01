package co.sebasdeveloper.pruebavalid.model;

public class ArtistResponseModel {
    private ArtistModel artist;

    public ArtistResponseModel() {
    }

    public ArtistResponseModel(ArtistModel artist) {
        this.artist = artist;
    }

    public ArtistModel getArtist() {
        return artist;
    }

    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }
}
