package com.example.deeplink.repositories;

import com.example.deeplink.models.OtherPages;
import com.example.deeplink.models.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OtherPagesRepository extends JpaRepository<OtherPages, Long> {

    List<OtherPages> findByWebUrl(String deeplink);
    List<OtherPages> findByDeepLink(String webUrl);

}
