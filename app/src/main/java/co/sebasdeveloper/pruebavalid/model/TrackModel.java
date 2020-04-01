package co.sebasdeveloper.pruebavalid.model;

import com.google.gson.annotations.SerializedName;

public class TrackModel {
    private String name;
    private String duration;
    private String abr_duration;
    private String listeners;
    private String abr_listeners;
    private String mbid;
    private String url;
    private StreamableModel streamable;
    private ArtistModel artist;
    private ImageModel[] image;

    @SerializedName("@attr")
    private AttrModel attrModel;

    public TrackModel() {
    }

    public TrackModel(String name, String duration, String listeners, String mbid, String url, StreamableModel streamable, ArtistModel artist, ImageModel[] image, AttrModel attrModel) {
        this.name = name;
        this.duration = duration;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.image = image;
        this.attrModel = attrModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public StreamableModel getStreamable() {
        return streamable;
    }

    public void setStreamable(StreamableModel streamable) {
        this.streamable = streamable;
    }

    public ArtistModel getArtist() {
        return artist;
    }

    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }

    public ImageModel[] getImage() {
        return image;
    }

    public void setImage(ImageModel[] image) {
        this.image = image;
    }

    public AttrModel getAttrModel() {
        return attrModel;
    }

    public void setAttrModel(AttrModel attrModel) {
        this.attrModel = attrModel;
    }

    public String getAbr_listeners() {
        if(abr_listeners == null){
            convertListeners();
        }
        return abr_listeners;
    }

    public String getAbr_duration() {
        if(abr_duration == null){
            convertDuration();
        }
        return abr_duration;
    }

    public void convertDuration(){
        int duration = Integer.valueOf(this.duration);
        int seconds = duration % 60;
        int hours = duration / 60;
        int minutes = hours % 60;
        if(seconds<10){
            abr_duration = minutes + ":0" + seconds;
        }else{
            abr_duration = minutes + ":" + seconds;
        }
    }

    public void convertListeners(){
        switch (this.listeners.length()){
            case 1:
            case 2:
            case 3:
                abr_listeners = this.listeners;
            case 4:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + " K";
                break;
            case 5:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + this.listeners.charAt(3);
                abr_listeners = abr_listeners + " K";
                break;
            case 6:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(3);
                abr_listeners = abr_listeners + this.listeners.charAt(4);
                abr_listeners = abr_listeners + " K";
                break;
            case 7:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + " M";
                break;
            case 8:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + this.listeners.charAt(3);
                abr_listeners = abr_listeners + " M";
                break;
            case 9:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(3);
                abr_listeners = abr_listeners + this.listeners.charAt(4);
                abr_listeners = abr_listeners + " M";
                break;
            case 10:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + " B";
                break;
            case 11:
                abr_listeners = String.valueOf(this.listeners.charAt(0));
                abr_listeners = abr_listeners + this.listeners.charAt(1);
                abr_listeners = abr_listeners + ".";
                abr_listeners = abr_listeners + this.listeners.charAt(2);
                abr_listeners = abr_listeners + this.listeners.charAt(3);
                abr_listeners = abr_listeners + " B";
                break;
            default:
                abr_listeners = this.listeners;
        }
    }
}
