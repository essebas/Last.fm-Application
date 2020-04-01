package co.sebasdeveloper.pruebavalid.model;

public class StatsModel {
    private String listeners;
    private String playcount;

    public StatsModel() {
    }

    public StatsModel(String listeners, String playcount) {
        this.listeners = listeners;
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }
}
