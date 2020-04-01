package co.sebasdeveloper.pruebavalid.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class TopTrackModel {
    private ArrayList<TrackModel> track;
    @SerializedName("@attr")
    private AttrModel attrModel;

    public TopTrackModel() {
    }

    public TopTrackModel(ArrayList<TrackModel> track, AttrModel attrModel) {
        this.track = track;
        this.attrModel = attrModel;
    }

    public ArrayList<TrackModel> getTrack() {
        return track;
    }

    public void setTrack(ArrayList<TrackModel> track) {
        this.track = track;
    }

    public AttrModel getAttrModel() {
        return attrModel;
    }

    public void setAttrModel(AttrModel attrModel) {
        this.attrModel = attrModel;
    }
}
