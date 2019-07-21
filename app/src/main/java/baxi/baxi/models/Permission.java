package baxi.baxi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Permission {

    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("permissions")
    @Expose
    private List<Permission_> permissions = null;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<Permission_> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission_> permissions) {
        this.permissions = permissions;
    }





}
