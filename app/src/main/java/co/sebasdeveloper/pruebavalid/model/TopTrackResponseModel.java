package co.sebasdeveloper.pruebavalid.model;

public class TopTrackResponseModel {

    private TopTrackModel tracks;

    public TopTrackResponseModel() {
    }

    public TopTrackResponseModel(TopTrackModel tracks) {
        this.tracks = tracks;
    }

    public TopTrackModel getTracks() {
        return tracks;
    }

    public void setTracks(TopTrackModel tracks) {
        this.tracks = tracks;
    }
}
