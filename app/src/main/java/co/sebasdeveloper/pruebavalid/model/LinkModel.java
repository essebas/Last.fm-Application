package co.sebasdeveloper.pruebavalid.model;

public class LinkModel {
    private String text;
    private String rel;
    private String href;

    public LinkModel() {
    }

    public LinkModel(String text, String rel, String href) {
        this.text = text;
        this.rel = rel;
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
