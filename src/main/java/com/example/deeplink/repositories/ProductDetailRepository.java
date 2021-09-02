package com.example.deeplink.repositories;

import com.example.deeplink.models.ProductDetail;
import com.example.deeplink.models.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    List<ProductDetail> findByWebUrl(String deeplink);
    List<ProductDetail> findByDeepLink(String webUrl);
    ProductDetail save(ProductDetail productDetail);

}
