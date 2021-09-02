package com.example.deeplink.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "search_page")
public class Search {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
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

    @Id
    public Long getId() {
        return id;
    }

    private String deepLink;
    private String webUrl;

}
