package co.sebasdeveloper.pruebavalid2.model;

import java.util.List;

public class ListTagModel {
    private List<TagModel> tag;

    public ListTagModel() {
    }

    public ListTagModel(List<TagModel> tag) {
        this.tag = tag;
    }

    public List<TagModel> getTag() {
        return tag;
    }

    public void setTag(List<TagModel> tag) {
        this.tag = tag;
    }
}
