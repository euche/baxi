package baxi.baxi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class storeResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private sData data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public sData getData() {
        return data;
    }

    public void setData(sData data) {
        this.data = data;
    }



}
