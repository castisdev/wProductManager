###상품 기본 정보 (Basic)
#### 상품 정보 생성 (Create a Product)
`POST` /v1/products/product
 - Parameters
 - Request Sample
```
{
    "products" : [
        {
            "name":"단일상품",
            "description":"",
            "item_list" : {
                "items" : [
                    {
                        "name":"아이템"
                    }
                ]
            },
            "pricing_plan_list" : {
                "pring_plans" : [
                    {
                        "name" : "기본가격정책",
                        "price":"1000",
                        "currency":"WON",
                        "sales_for_where": ["all"],
                        "sales_for_who": ["all"],
                        "sales_for_how": ["online","offline"],
                        "sales_for_when": {
                            "start_time":"2016-09-13T12:00:00",
                            "end_time":"2016-09-14T12:00:00"
                            }
                    },
                    {
                        "name" : "가격정책",
                        "price":"500",
                        "currency":"WON",
                        "sales_for_where": ["서울", "부산"],
                        "sales_for_who": ["남자", "20대"],
                        "sales_for_how": ["online"],
                        "sales_for_when": {
                            "start_time":"2016-09-13T12:00:00",
                            "end_time":"2016-09-14T12:00:00"
                            }
                    }
                ]
            }
        }
    ]
}
```

 - Response Sample

#### 상품 정보 갱신 (Update a Product)
`PUT` /v1/products/product
 - Parameters
 - Request Sample
 - Response Sample

#### 상품 정보 삭제
`DELETE` /v1/products/product
 - Parameters
 - Request Sample
 - Response Sample

#### 상품 정보 조회(Product List)
`GET` /v1/products/product/{product-id}
 - Parameters
 - Request Sample
 - Response Sample

###상품 구매 정보(Purchase)
####상품 구매 
`POST` /v1/products/purchase
 - Parameters
 - Request Sample
 - Response Sample

####구매한 상품 조회
`GET` /v1/products/purchase/list
 - Parameters
 - Request Sample
 - Response Sample

`GET` /v1/products/purchase/{purchase-id}
 - Parameters
 - Request Sample
 - Response Sample

####구매 삭제
`DELETE` /v1/products/purchase
 - Parameters
 - Request Sample
 - Response Sample


###상품 판매 정보(Sale)
####상품 판매
`POST` /v1/products/sale
 - Parameters
 - Request Sample
 - Response Sample

####판매한 상품 조회
`GET` /v1/products/sale/list
 - Parameters
 - Request Sample
 - Response Sample

`GET` /v1/products/sale/{sale-id}
 - Parameters
 - Request Sample
 - Response Sample

####판매 상품 업데이트
`PUT` /v1/products/sale/
 - Parameters
 - Request Sample
 - Response Sample

####판매 일시 중지
`POST` /v1/products/sale/{sale-id}/suspend
 - Parameters
 - Request Sample
 - Response Sample

####판매 상품 삭제
`DELETE` /v1/products/sale/{sale-id}/
 - Parameters
 - Request Sample
 - Response Sample

### 관심 상품 정보 (Favorite)
#### 관심 상품 등록
`POST` /v1/products/favorite
 - Parameters
 - Request Sample
 - Response Sample

#### 관심 상품 삭제
`DELETE` /v1/products/favorite/
 - Parameters
 - Request Sample
 - Response Sample

#### 관심 상품 조회
`GET` /v1/products/favorite/list
 - Parameters
 - Request Sample
 - Response Sample

### 상품 프로모션 정보(Promotion)
#### 프로모션 생성
`POST` /v1/products/promotion/
 - Parameters
 - Request Sample
 - Response Sample


#### 프로모션 조회
`GET` /v1/products/promotion/{promotion-id}
 - Parameters
 - Request Sample
 - Response Sample

#### 프로모션 업데이트
`PUT` /v1/products/promotion/
 - Parameters
 - Request Sample
 - Response Sample

#### 프로모션 삭제
`DELETE` /v1/products/promotion/
 - Parameters
 - Request Sample
 - Response Sample


### 상품 선물(Give a Product)
`POST` /v1/products/product/{product-id}/give
 - Parameters
 - Request Sample
 - Response Sample

### 상품 획득(Acquire a Product)
`POST` /v1/products/product/{product-id}/acquire
 - Parameters
 - Request Sample
 - Response Sample
