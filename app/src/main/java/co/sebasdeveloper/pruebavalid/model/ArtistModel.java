package co.sebasdeveloper.pruebavalid.model;

import java.util.ArrayList;
import java.util.List;

public class ArtistModel {
    private String name;
    private String listeners;
    private String abr_listeners;
    private String mbid;
    private String url;
    private ImageModel[] image;
    private String streamable;
    private String ontour;
    private StatsModel stats;

    //Probar
    private ListArtistModel similar;

    private ListTagModel tags;

    private BioModel bio;

    private String postition_atr;

    public ArtistModel() {
    }

    public ArtistModel(String name, String url, ImageModel[] image) {
        this.name = name;
        this.url = url;
        this.image = image;
    }

    public ArtistModel(String name, String listeners, String mbid, String url, ImageModel[] image, String streamable) {
        this.name = name;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.streamable = streamable;
    }

    public ArtistModel(String name, String listeners, String mbid, String url, ImageModel[] image, String streamable, String ontour, StatsModel stats, ListArtistModel similar, ListTagModel tags, BioModel bio) {
        this.name = name;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.streamable = streamable;
        this.ontour = ontour;
        this.stats = stats;
        this.similar = similar;
        this.tags = tags;
        this.bio = bio;
    }

    public ArtistModel(String name, String mbid, String url, ImageModel[] image, String streamable, String ontour, StatsModel stats, ListArtistModel similar, ListTagModel tags, BioModel bio) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.streamable = streamable;
        this.ontour = ontour;
        this.stats = stats;
        this.similar = similar;
        this.tags = tags;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ImageModel[] getImage() {
        return image;
    }

    public void setImage(ImageModel[] image) {
        this.image = image;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public String getOntour() {
        return ontour;
    }

    public void setOntour(String ontour) {
        this.ontour = ontour;
    }

    public StatsModel getStats() {
        return stats;
    }

    public void setStats(StatsModel stats) {
        this.stats = stats;
    }

    public ListArtistModel getSimilar() {
        return similar;
    }

    public void setSimilar(ListArtistModel similar) {
        this.similar = similar;
    }

    public ListTagModel getTags() {
        return tags;
    }

    public void setTags(ListTagModel tags) {
        this.tags = tags;
    }

    public BioModel getBio() {
        return bio;
    }

    public void setBio(BioModel bio) {
        this.bio = bio;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getAbr_listeners() {
        convertListeners();
        return abr_listeners;
    }

    public String getPostition_atr() {
        return postition_atr;
    }

    public void setPostition_atr(String postition_atr) {
        this.postition_atr = postition_atr;
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
