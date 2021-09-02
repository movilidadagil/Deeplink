package com.example.deeplink.models;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "other_pages")
public class OtherPages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String deepLink;
    private String webUrl;

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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
