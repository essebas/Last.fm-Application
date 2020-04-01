package co.sebasdeveloper.pruebavalid.model;

import com.google.gson.annotations.SerializedName;

public class StreamableModel {
    @SerializedName("#text")
    private String text;
    private String fulltrack;

    public StreamableModel(String text, String fulltrack) {
        this.text = text;
        this.fulltrack = fulltrack;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }
}
