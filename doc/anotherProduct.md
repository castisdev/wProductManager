
# 상품(Product)

다른 회사의 e-commerce manager 들과, billing solution의  model 참고
 - magento
 - woocommerce

## general

``` json
{
  "id": "123/456",
  "name": "my product",
  "type": "simple rental",
  "description" : "simple product for vod",
  "slogan" : "CHOO-SUK SALE",
  "category" : "vod",
  "lifeTimeStartDate" : "2016-09-05",
  "lifeTimeEndDate" : "2016-09-06",
  "sellingType" : "rental"
  
}

// type from woocommerce : simple, grouped, external-affiliate, variable, simple rental
// type from magento : simple, virtual, configurable, grouped, downloadable, bundle, giftcard
// class : product, subscription, bundle
// item type : product, service, donation

```
## status
``` json
{
  "status" : "published",
  "visibility" : "public",
  "publishedDate" : "2016-09-10T10:20:10.001",
}

```

## display

``` json
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

## price

``` json

{
  "price" : 200.0,
  "currency" : "KRW",
  "salePrice" : 150.0,
  "saleFrom" : "2016-09-07",
  "saleTo" : "2016-10-07"
}

```

## linking

``` json

{
 "up-sells" : ["123/4123413", "13/4213"], 
 "cross-sells" : ["hello/world", "product/hello"],
 "grouping" : ["p1", "p2"],
}
```

## item

``` json

{
 "type" : "title",
 "itemId" : "www.abc.com/ACGD1204912402040",
 "name" : "설리: 허드슨강의 기적 (SULLY, 2016)",
 "details" : "http://www.abc.com/asset/details/ACGD1204912402040"
},
{
 "type" : "advertisement-inventory",
 "itemId" : "cjhv/VOD201610AG0294012542322-204123",
 "name" : "cjhv 의 tvn 카테고리:서울:성인:20-22시:2016-10-01,2016-10-30",
 "details" : "http://www.abc.com/ad/inventory/cjhv/VOD201610AG0294012542322-204123"
 }

```




## from others 

* Features For Pro-version
* Day basis price configuration
* Monthly price configuration (Seasonal pricing)
* Day ranges price configuration
* Discount on day ranges pricing
* General price configuration
* Hourly price configuration
* Availability control
* European date format
* American Date format
* Asian Date format 
* Date blocking
* Choose how much you must have to pay during booking
* Unlimited payable resources
* Unlimited payable person.
* Three type of date format.
* Add unlimited product attributes.
* Add unlimited product features.
* pickup and return location added.
* Add pickup and return location cost
* Admin email notification during new order
* Customers email notification during complete order, cancel order, or refund order
* Developer friendly code
* Font-awesome include 
* Products global and local settings 
* Multilingual

