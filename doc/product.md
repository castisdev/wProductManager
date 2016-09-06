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

### Product
| 이름 | 타입 | 설명 | 프로파일 |
| --- | --- | --- | --- |
| id	 | String | 	상품 ID | 	0 | 
| name	 | String	 | 상품명	 | 0 | 
| type	 | String	 | 가입형 상품</br>패키지형 상품 	 | 0 |
 | smallImageFile	 | String	 | 상품 포스터 이미지 파일명	(작은 사이즈) | 1 | 
| imageFile	 | String	 | 상품 포스터 이미지 파일명	 | 1 | 
| externalId	 | String	 | 협의된 연동용 상품 ID	 | 1 | 
| viewingLength	 | String	 | 구매가 유효한 기간. </br>DDD:HH:mm 형태 혹은 DD:HH:mm 형태 	 | 1 | 
| viewablePeriodState	 | Int	 | 무제한시청(평생소장) 여부</br>0 : 기본값</br>1 : 무제한시청(평생소장). viewingLength값이 무시된다.  | 1 | 	
| policyList		 | productPolicy | productPolicy의 리스트 |  	2 | 
| description	 | String	 | 상품 설명 | 	3 | 

###ProductPolicy
| 이름 | 타입 | 설명 |
| --- | --- | --- |
| id	 | String	 | productPolicy 내부 ID  | 
| type	 | String	 | 상품 정책의 타입 </br>static : 고정 기간 고정 가격 정책 | 
| price	 | Int	 | 해당 상품 정책에 의한 가격 | 
| licenseStart	 | String	 | 상품 정책 유효기간 시작일</br> “YYYY-MM-DD HH:MM:SS” 형태 | 
| licenseEnd	 | String	 | 상품 정책 유효기간 종료일</br> “YYYY-MM-DD HH:MM:SS” 형태 | 
