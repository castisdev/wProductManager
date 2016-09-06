
# 상품(Product)

### another Product 
다른 회사의 e-commerce manager 들과, billing solution의  model 참고
 - magento
 - woocommerce
 
``` json
{
  "id": "123/456",
  "name": "my product",
  "type": "simple",
  "description" : "simple product for vod",
  "slogan" : "CHOOSUK SALE",
  "category" : "vod",
  "lifeTimeStartDate" : "2016-09-05",
  "lifeTimeEndDate" : "2016-09-06"
  
}

// type from woocommerce : simple, grouped, external-affiliate, variable, simple rental
// type from magento : simple, virtual, configurable, grouped, downloadable, bundle, giftcard
// class : product, subscription, bundle
// item type : product, service, donation

```
## Product display

``` json
// from woocommerce
{
  "catalogImageUri" : "www.castis.com/images/product/123/1456/product_for_catalog.png",
  "catalogImageWidth" : 200,
  "catalogImageHeight" : 200,
  
  "productImageUri" : "www.castis.com/images/product/123/1456/product.png",
  "productImageWidth" : 400,
  "productImageHeight" : 400,
  
  "thumnails" : [ "www.castis.com/images/product/123/1456/thumb1.png",
                  "www.castis.com/images/product/123/1456/thumb2.png",
                  "www.castis.com/images/product/123/1456/thumb3.png"
                ],
  "thumnailsWidth" : 120,
  "thumnailsHeight" : 120,                
}
```
