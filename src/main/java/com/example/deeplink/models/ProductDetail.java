package com.example.deeplink.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;
    private String categoryName;
    private String productName;
    private String contentId;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String  getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getButiqueId() {
        return butiqueId;
    }

    public void setButiqueId(String butiqueId) {
        this.butiqueId = butiqueId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String  merchantId) {
        this.merchantId = merchantId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    private String butiqueId;
    private String merchantId;
    private String campaignId;
    private String deepLink;
    private String webUrl;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
