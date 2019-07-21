package baxi.baxi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {




    @SerializedName("createdAt")
    @Expose
    private Long createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Long updatedAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("meta")
    @Expose
    private Object meta;
    @SerializedName("birthday_day")
    @Expose
    private Integer birthdayDay;
    @SerializedName("birthday_month")
    @Expose
    private Integer birthdayMonth;
    @SerializedName("points")
    @Expose
    private Object points;
    @SerializedName("rand")
    @Expose
    private String rand;
    @SerializedName("store_id")
    @Expose
    private Integer storeId;
    @SerializedName("customer_id")
    @Expose
    private CustomerId customerId;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("loyalty_points")
    @Expose
    private Object loyaltyPoints;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public Integer getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public Integer getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(Integer birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public Object getPoints() {
        return points;
    }

    public void setPoints(Object points) {
        this.points = points;
    }

    public String getRand() {
        return rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Object getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Object loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }





}
