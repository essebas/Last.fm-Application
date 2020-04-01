package co.sebasdeveloper.pruebavalid.model;

public class TopArtistResponseModel {

    private TopArtistModel topartists;

    public TopArtistResponseModel() {
    }

    public TopArtistResponseModel(TopArtistModel topartists) {
        this.topartists = topartists;
    }

    public TopArtistModel getTopartists() {
        return topartists;
    }

    public void setTopartists(TopArtistModel topartists) {
        this.topartists = topartists;
    }
}
