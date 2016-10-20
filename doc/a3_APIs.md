
### Generalization of Product
![Generalization of Product] (https://github.com/bobmann98/commonProduct/blob/master/%EC%83%81%ED%92%88%EA%B3%A0%EB%8F%84%ED%99%94.png?raw=true)

### API for Product
![API for Product] (https://github.com/bobmann98/commonProduct/blob/master/Product.png?raw=true)

### * 동일한 상품 이란?
     상품안에 구성되어 있는 item{id, type}이 동일한 경우 같은 상품이라고 봄. 
     가격조건은 동일 상품 기준에서 제외. 
     동일한 상품을 매니저상에서 구성할 수 없도록 제약조건 필요.

## Models
### Wants
~~~
 상품의 찜기능 정보
~~~
#### Fields
 * product


## APIs
###상품 기본 정보 (Basic)
#### 상품 정보 생성 (Create a Product)
`POST` /v1/products/product
 - Parameters
 - Request Sample
```
{
    "products" : [
        {
            "id":"상품01",
            "name":"텐트01",            
            "description":"백패킹용 텐트",
            "isPackage":"false",
            "classifications": {
                                  "large":"여행",
                                  "medium":"캠핑",
                                  "small":"텐트"
            },
            "image":"tent.jpg",
            "creation_time":"2016-09-13T12:00:00",           
            "specifications": {
                                  "color":"red",
                                  "size":"100x100x100",
                                  "capacity":"4"
            },
            "item_list" : {
                "items" : [
                    {
                          "id":"ITEM01",
                          "name":"아이템",
                          "type":"텐트",
                          "cost":"400",
                          "currency":"WON",
                          "origin":"korea",
                          "brand":"castis",       
                          "specifications": {
                                              "color":"red",
                                              "size":"100x100x100",
                                              "capacity":"4"
                          },
                         "image":"tent.jpg"
                    }
                ]
            },
            "pricing_plan_list" : {
                "pricing_plans" : [
                    {
                        "id":"plan01",
                        "name" : "기본가격정책",
                        "price":"1000",
                        "currency":"WON",
                        "default":"true", 
                        "sales_for_where": ["all"],
                        "sales_for_who": ["all"],
                        "sales_for_how": ["online","offline"],
                        "sales_for_when": {
                            "start_time":"2016-09-13T12:00:00",
                            "end_time":"2016-09-14T12:00:00"
                            }
                    },
                    {
                        "id":"plan02",
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
        }, 
        {
                 "id":"상품02",
                 "name":"텐트용품 묶음상품",            
                 "description":"백패킹용 상품 스페셜",
                 "isPackage":"true",
                 "classifications": {
                         "large":"여행",
                         "medium":"캠핑",
                         "small":"텐트"
                    }
                 "image":"tent.jpg",
                 "creation_time":"2016-09-13T12:00:00"
                  "specifications": {
                         "color":"red",
                         "size":"100x100x100",
                         "capacity":"4"
                   },
                 "item_list" : {
                      "items" : [
                         {
                              "id":"ITEM01",
                              "name":"고성능텐트",
                              "type":"텐트",
                              "cost":"1000",
                              "currency":"WON",
                              "origin":"korea",
                              "brand":"castis",                      
                              "specifications": {
                                   "color":"red",
                                   "size":"100x100x100",
                                   "capacity":"4"
                              },
                              "image":"tent.jpg"
                         },
                         {
                              "id":"ITEM02",
                              "name":"고성능의자",
                              "type":"의자",
                              "cost":"400",
                             "currency":"WON",  
                              "origin":"china",
                              "brand":"castis1",                              
                              "specifications": {
                                   "color":"green",
                                   "size":"30x30x30",
                                   "capacity":"1"
                              },
                              "image":"chair.jpg"
                         },
                          {
                              "id":"ITEM03",
                              "name":"고성능타프",
                              "type":"타프",
                              "cost":"600",
                              "currency":"WON",
                              "origin":"usa",
                              "brand":"castis2",                             
                              "specifications": {
                                   "color":"blue",
                                   "size":"400x500"
                              },
                              "image":"tarp.jpg"
                         }
                     ]
                 },
                 "pricing_plan_list" : {
                     "pricing_plans" : [
                         {
                             "id":"plan03",
                             "name" : "기본가격정책",
                             "price":"1000",
                             "currency":"WON",
                             "default":"true",
                             "sales_for_where": ["all"],
                             "sales_for_who": ["all"],
                             "sales_for_how": ["online","offline"],
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
```
{
  "purchases":[
    {
      "order_id":"order01",
      "sale_id":"sale01",
      "transaction_currency":"WON",
      "purchase_price":"3000",
      "selling_price": "4000",
      "included_shipping_fee":"true",
      "customer_id":"cust01",
      "product":{
        "id":"p001",
        "name":"상품1"
      },
      "shipping":{
        "addressee":"bobmann",
        "address":"seoul",
        "fee":"3000"
      },
      "payments":[
          {
              "type":"credit_card",
              "issuer":"bc",
              "monthly_division_count":3,
              "interest":"false",
              "amount":"2000"
          },
          {
              "type":"online_banker",
              "issuer":"paypal",
              "amount":"1000"
          }
      ],
      "applied_promotions":[
        {
            "id":"pmo02",
            "type":"discount",
            "how":{
              "type":"fix",
              "amount":"1000"
            },
            "duplicable":"true"
        }
      ]
    }
  ]
}
```
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
 
 ```
 {
  "sales": [
      {
        "id": "sale01",
        "name":"상품판매",
        "description":"특가세일",
        "product":
        {
          "id": "test12",
          "name": "텐트01",
          "description": "백패킹용 텐트",
          "is_package": false,
          "classifications": {
            "large": "여행",
            "medium": "캠핑",
            "small": "텐트"
          },
          "image": "tent.jpg",
          "specifications": {
            "color": "red",
            "size": "100x100x100",
            "capacity": "4"
          },
          "creation_time": "2016-09-13T12:00:00",
          "item_list": {
            "items": [
              {
                "id": "ITEM01",
                "name": "아이템",
                "type": "텐트",
                "cost": "400",
                "currency": "WON",
                "origin": "korea",
                "brand": "castis",
                "specifications": {
                  "color": "red",
                  "size": "100x100x100",
                  "capacity": "4"
                },
                "image": "tent.jpg"
              }
            ]
          },
          "pricing_plan_list": {
            "pricing_plans": [
              {
                "id": "plan01",
                "name": "기본가격정책",
                "price": "1000",
                "currency": "USD",
                "default": true,
                "sale_for_where": [
                  "all"
                ],
                "sale_for_who": [
                  "all"
                ],
                "sale_for_how": [
                  "online",
                  "offline"
                ],
                "sale_for_when": {
                  "start_time": "2016-09-13T12:00:00",
                  "end_time": "2016-09-14T12:00:00"
                }
              }
           ]
          }
        },
        "available_payments":{
          "payments":[
            {
              "id":"pay01",
              "type":"credit_card",
              "issuers":["bc","keb","shinhan"],
              "monthly_division_count":3,
              "interest":"false"
            },
            {
              "id":"pay02",
              "type":"online_banker",
              "issuers":["paypal", "kakao"]
            },
            {
              "id":"pay03",
              "type":"cash"
            }
          ]
        },
        "promotions":[
          {
            "id":"pmo01",
            "type":"discount",
            "when":"sale_duration",
            "how":{
              "type":"fix",
              "amount":"30"
            },
            "duplicable":"true"
          },
          {
            "id":"pmo02",
            "type":"1+1",
            "when":"1day_after_purchase",
            "what":{
                "type":"product"
            }
          }
        ]
      }
    ]
}
 ```
 
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
```
{
  "favorites":[
    {
      "id":"fav01",
      "name":"좋아하는 것",
      "customer_id":"cust01",
      "creation_time":"2016-10-10T09:00:00",
      "product": {
        "id":"product01",
        "name":"상품1",
        "now_price":"600",
        "currency":"WON"
      }
    }
  ]
}
```
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
