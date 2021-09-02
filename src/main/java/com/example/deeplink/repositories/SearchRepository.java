package com.example.deeplink.repositories;

import com.example.deeplink.models.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

    List<Search> findByWebUrl(String deeplink);
    List<Search> findByDeepLink(String webUrl);

}
