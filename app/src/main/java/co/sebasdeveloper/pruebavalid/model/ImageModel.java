package co.sebasdeveloper.pruebavalid.model;

import com.google.gson.annotations.SerializedName;

public class ImageModel {
    @SerializedName("#text")
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

