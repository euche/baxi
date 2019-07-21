package baxi.baxi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerId {


    @SerializedName("createdAt")
    @Expose
    private Long createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Long updatedAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("rand")
    @Expose
    private String rand;

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRand() {
        return rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }






}
