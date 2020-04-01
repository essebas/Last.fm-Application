package co.sebasdeveloper.pruebavalid2.model;

public class ImageModel {
    private String text;
    private String size;

    public ImageModel() {
    }

    public ImageModel(String text, String size) {
        this.text = text;
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

