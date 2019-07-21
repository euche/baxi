package baxi.baxi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {



    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("previousPage")
    @Expose
    private Object previousPage;
    @SerializedName("nextPage")
    @Expose
    private String nextPage;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Object getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Object previousPage) {
        this.previousPage = previousPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
