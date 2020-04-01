package co.sebasdeveloper.pruebavalid.model;

public class AttrModel {
    private String country;
    private String page;
    private String perPage;
    private String totalPages;
    private String total;
    private String rank;

    public AttrModel() {
    }

    public AttrModel(String country, String page, String perPage, String totalPages, String total) {
        this.country = country;
        this.page = page;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.total = total;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRank() {
        int temp = Integer.valueOf(this.rank);
        temp = temp + 1;
        this.rank = String.valueOf(temp);
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
