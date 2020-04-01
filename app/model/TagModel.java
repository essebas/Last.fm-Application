package co.sebasdeveloper.pruebavalid2.model;

public class TagModel {
    private String name;
    private String url;

    public TagModel() {
    }

    public TagModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
