package co.sebasdeveloper.pruebavalid2.model;

import java.util.ArrayList;
import java.util.List;

public class ArtistModel {
    private String name;
    private String mbid;
    private String url;
    private List<ImageModel> image;
    private String streamable;
    private String ontour;
    private StatsModel stats;

    //Probar
    private ListArtistModel similar;

    private ListTagModel tags;

    private BioModel bio;

    public ArtistModel() {
        this.image = new ArrayList<>();
    }

    public ArtistModel(String name, String url, List<ImageModel> image) {
        this.name = name;
        this.url = url;
        this.image = image;
    }

    public ArtistModel(String name, String mbid, String url, List<ImageModel> image, String streamable, String ontour, StatsModel stats, ListArtistModel similar, ListTagModel tags, BioModel bio) {
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

    public List<ImageModel> getImage() {
        return image;
    }

    public void setImage(List<ImageModel> image) {
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
}
