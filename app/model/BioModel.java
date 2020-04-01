package co.sebasdeveloper.pruebavalid2.model;

import java.util.List;

public class BioModel {
    private LinksModel links;
    private String published;
    private String summary;
    private String content;

    public BioModel() {
    }

    public BioModel(LinksModel links, String published, String summary, String content) {
        this.links = links;
        this.published = published;
        this.summary = summary;
        this.content = content;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(LinksModel links) {
        this.links = links;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
