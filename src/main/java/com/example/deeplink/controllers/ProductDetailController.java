package com.example.deeplink.controllers;


import com.example.deeplink.models.ProductDetail;
import com.example.deeplink.repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductDetailController {

    @Autowired
    ProductDetailRepository productDetailRepository;

    /*
    Product detail page URL must contain "-p-" text.
● Product detail page URLs must contain contentId which is located after "-p-" prefix.
● URL can contain boutiqueId and merchantId.
● If URL doesn't contain boutiqueId, you shouldn't add CampaignId to deeplink
● If URL doesn't contain merchantId, you shouldn't add MerchantId to deeplink
● Deeplink and Web URL have differences on CampaignId and boutiqueId. Deeplinks have
CampaignId, web URLs have boutiqueId.

https://www.trendyol.com/{BrandName-or-CategoryName}/{ProductName}-p-{ContentId}? boutiqueId={BoutiqueId}&merchantId={MerchantId}


ty://?Page=Product&ContentId=1925865&Camp aignId=439892&MerchantId=105064
https://www.trendyol.com/casio/saat-p- 1925865?boutiqueId=439892&merchantId=1050 64
     */


    @PostMapping("/c2deep")
    public ResponseEntity<String> createTest(@RequestParam("weburl") String weburl) {

        return new ResponseEntity<>(weburl, HttpStatus.CREATED);

    }


    @PostMapping("/c2deeplink")
    public ResponseEntity<String> createDeeplink(@RequestParam("weburl") String weburl) {

        //https://www.trendyol.com/{BrandName-or-CategoryName}/{ProductName}-p-{ContentId}? boutiqueId={BoutiqueId}&merchantId={MerchantId}
        //https://www.trendyol.com/casio/saat-p- 1925865?boutiqueId=439892&merchantId=1050 64
        //ty://?Page=Product&ContentId=1925865&Camp aignId=439892&MerchantId=105064
       // ty://?Page=Product&ContentId=1925865&CampaignIdboutiqueId&MerchantIdmerchantId
        //ty://?Page=Product&ContentId=1925865&CampaignIdboutiqueId&MerchantIdmerchantId
        //ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064
            ProductDetail product =     new ProductDetail();

        product.setBrandName(weburl.split("/")[3]);
            product.setCategoryName(weburl.split("/")[3]);
            product.setProductName(weburl.split("/")[3].split("-")[0]);
            product.setContentId(weburl.split("/")[4].split("-")[2].split("\\?")[0]);
            if(weburl.split("/")[4].split("\\?")[1].contains("boutiqueId")){
                product.setButiqueId(weburl.split("/")[4].split("\\?")[1].split("=")[1].split("&")[0]);
            }

            if(weburl.split("/")[4].split("\\?")[1].contains("merchantId")){
                product.setMerchantId(weburl.split("/")[4]
                        .split("\\?")[1]
                        .split("&")[1].split("=")[1]);

            }



            String deeplink ="ty://?Page=Product&ContentId=";
            deeplink+=product.getContentId();

            if(product.getButiqueId()!=null){
                deeplink+="&CampaignId="+product.getButiqueId();
            }
            if(product.getMerchantId()!=null){
            deeplink+="&MerchantId="+product.getMerchantId();
            }

              product.setDeepLink(deeplink);

              ProductDetail _product_detail =
                productDetailRepository.save(
                        product
                );

        return new ResponseEntity<>(_product_detail.getDeepLink(), HttpStatus.CREATED);


    }
}
