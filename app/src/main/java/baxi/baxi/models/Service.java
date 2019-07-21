package baxi.baxi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {




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
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("special_price")
    @Expose
    private Integer specialPrice;
    @SerializedName("supply_price")
    @Expose
    private Integer supplyPrice;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("rand")
    @Expose
    private String rand;
    @SerializedName("vendor_discount")
    @Expose
    private Integer vendorDiscount;
    @SerializedName("meta")
    @Expose
    private Object meta;
    @SerializedName("vendor_id")
    @Expose
    private Object vendorId;
    @SerializedName("added_by")
    @Expose
    private Integer addedBy;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category")
    @Expose
    private String category;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Integer specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Integer getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(Integer supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getRand() {
        return rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }

    public Integer getVendorDiscount() {
        return vendorDiscount;
    }

    public void setVendorDiscount(Integer vendorDiscount) {
        this.vendorDiscount = vendorDiscount;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public Object getVendorId() {
        return vendorId;
    }

    public void setVendorId(Object vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }





}
