#ProductManager
## 목차
- [Reference] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#reference)
- [API] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#api)
 - [전체 상품 조회] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#전체-상품-조회)
 - [단일 상품 조회 (with id)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#단일-상품-조회-with-id)
 - [상품 조회 (with type)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-조회-with-type)
 - [상품 생성] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-생성)
 - [묶음 상품 생성 (SVODPackage, Bundle, Advertisement(Bundle))] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#묶음-상품-생성-svodpackage-bundle-advertisementbundle)
 - [상품 수정 (with id)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-수정-with-id)
 - [상품 삭제 (with id)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-삭제-with-id)
 - [전체 가격정책 조회] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#전체-가격정책-조회)
 - [가격정책 조회 (with policy_id)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#가격정책-조회-with-policy_id)
 - [가격정책 조회 (with policy_type)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#가격정책-조회-with-policy_type)
 - [가격정책 생성] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#가격정책-생성)
 - [가격정책 수정 (with policy_id)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#가격정책-수정-with-policy_id)
 - [가격정책 삭제 (with policy_id)] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#가격정책-삭제-with-policy_id)
 - [상품 주문] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-주문)
	- ground_shipping (택배 등)
	- online
- [Product] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#product)
 	- Product
 	- Category
 	- PricingPolicy
- [상품 종류] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-종류)
	 - RVOD
	 - SVOD
	 - FOD
	 - SVOD Package
	 - Bundle
	 - 광고
		  - 단일 광고
		  - 광고 묶음
	 - Clothing


## Reference
- [개발자에게 사랑받는 API 만들기] (http://www.mimul.com/pebble/default/2012/08/07/1344315512542.html)
- [Netflix Roulette API] (http://netflixroulette.net/api/)
- [WooCommerce REST API - Product] (https://woothemes.github.io/woocommerce-rest-api-docs/#products)
- [HTTP Status Codes] (http://www.restapitutorial.com/httpstatuscodes.html)
- [마크다운(.mk) 문법] (http://blog.kalkin7.com/2014/02/05/wordpress-markdown-quick-reference-for-koreans/)
- **MongoDB**
 - [MongoDB Documentation] (https://docs.mongodb.com/manual/reference/)
 - [MongoDB 기본 쿼리] (http://uiandwe.tistory.com/969)
 - [MongoDB & SQL 쿼리 비교] (http://jy86.tistory.com/entry/MongoDB-MongoDB-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%BF%BC%EB%A6%AC-%EC%82%AC%EC%9A%A9%EB%B2%95)


## API

### 전체 상품 조회
- **GET** /ProductManager/v1/products

- Response
 - 200 OK
 
```json
{
  "productList":[
    {
      "id":"AA00201201010001",
      "name":"최종병기 활",
      "type":"RVOD",
      "created":"2012-01-01T13:55:10",
      "modified":"2016-09-07T17:24:41",
      "categories":[
        {"category_id":11, "category_name":"액션"},
        {"category_id":15, "category_name":"전쟁"}
      ],
      "price":"2500",
      "pricing_policies":[
        {"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null},
        {"policy_id":12, "policy_name":"[할인]박해일 특집", "policy_type":"fixed_discount", "amount":1000, "expiry_date":null}
      ],
      "image":"http://localhost:8080/ProductManager/PosterImage/war_of_the_arrows.png",
      "description":"'[HD]최종병기 활' 입니다.",
      "average_rating":7.9,
      "rating_count":642,
      "upsell_ids": [],
      "cross_sell_ids": [],
      "details":{
          "assets":[
            {"asset_id":"www.hchoice.co.kr|M0018210LFO157334201"}
          ],
          "release_year":"2011",
          "actors":"박해일,류승룡,김무열,문재원,이한위",
          "director":"김한민",
          "summary":"50만 포로가 끌려간 병자호란, 치열했던 전쟁의 한 복판에 역사가 기록하지 못한 위대한 신궁이 있었다.",
          "runtime":"122",
          "viewingLength":"001:00:00",
          "viewablePeriodState":0
       }
    },
    {
      "id":"AA00201609080002",
      "name":"부산행",
      "type":"RVOD",
      "created":"2016-09-08T18:01:12",
      "modified":"2016-09-08T18:01:12",
      "categories":[
        {"category_id":11, "category_name":"액션"},
        {"category_id":12, "category_name":"스릴러"}
      ],
      "price":"4500",
      "pricing_policies":[
        {"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null}
      ],
      "image":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
      "description":"'[HD]부산행' 입니다.",
      "average_rating":8.5,
      "rating_count":17,
      "upsell_ids": [],
      "cross_sell_ids": [],
      "details":
        {
          "assets":[
            {"asset_id":"www.hchoice.co.kr|M0018210LFO116090701"}
          ],
          "release_year":"2016",
          "actors":"공유,정유미,마동석,김수안,김의성",
          "director":"연상호",
          "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
          "runtime":"118",
          "viewingLength":"001:00:00",
          "viewablePeriodState":0
        }
    }
  ]
}
```

### 단일 상품 조회 (with id)
- **GET** /ProductManager/v1/products/:id
- **GET** /ProductManager/v1/products/AA00201609080002

- Response
 - 200 OK
 
```json
{
  "id":"AA00201609080002",
  "name":"부산행",
  "type":"RVOD",
  "created":"2016-09-08T18:01:12",
  "modified":"2016-09-08T18:01:12",
  "categories":[
    {"category_id":11, "category_name":"액션"},
    {"category_id":12, "category_name":"스릴러"}
  ],
  "price":"4500",
  "pricing_policies":[
    {"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
  "description":"'[HD]부산행' 입니다.",
  "average_rating":8.5,
  "rating_count":17,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
    {
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO116090701"}
      ],
      "release_year":"2016",
      "actors":"공유,정유미,마동석,김수안,김의성",
      "director":"연상호",
      "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
      "runtime":"118",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0
    }
}
```

### 상품 조회 (with type)
- **GET** /ProductManager/v1/products?type=:type
- **GET** /ProductManager/v1/products?type=SVOD

- Response
 - 200 OK
 
```json
{
  "productList":[
    {
	  "id": "AA00201609120001",
	  "name": "MBC 월정액",
	  "type": "SVOD",
	  "created": "2016-09-12T18:01:12",
	  "modified": "2016-09-12T18:01:12",
	  "categories": [{
	    "category_id": 2,
	    "category_name": "월정액"
	  }],
	  "price": "9900",
	  "pricing_policies": [
	    {"policy_id":2, "policy_name":"월정액", "policy_type":"monthly_subscription", "amount":-1, "expiry_date":null}
	  ],
	  "image": "http://localhost:8080/ProductManager/PosterImage/MBC.png",
	  "description": "MBC 월정액 입니다.",
	  "average_rating":9.1,
	  "rating_count":80,
	  "upsell_ids": [],
	  "cross_sell_ids": [],
	  "details": {		
	    "viewingLength": "031:00:00",
	    "viewablePeriodState": 0,
	    "externalProductId": "SVOD_MBC",
	    "relatedCategories": [
	      {
	        "category_id": 52,
	        "category_name": "MBC"
	      }
	    ]
	 }
    }
  ]
}
  
```

### 상품 생성
- **POST** /ProductManager/v1/products/

```json
{
  "id":"AA00201609080005",
  "name":"터널",
  "type":"RVOD",
  "categories":[
    {"category_id":17}
  ],
  "price":"4500",
  "pricing_policies":[
    {"policy_id":1}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/tunnel.png",
  "description":"'[HD]터널' 입니다."
}
```

- Response
 - 201 Created

### 묶음 상품 생성 (SVODPackage, Bundle, Advertisement(Bundle))
- **POST** /ProductManager/v1/products/

```json
{
  "id": "AA00201609120006",
  "name": "지상파 통합 월정액",
  "type": "SVODPackage",
  "categories":[
    {"category_id":3}
  ],
  "price":"25900",
  "pricing_policies":[
    {"policy_id":2}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/KBS_MBC_SBS.png",
  "description":"지상파 통합 월정액 입니다.",
  "related_products":[
    {"id":"AA00201609120001"},{"id":"AA00201609120002"},{"id":"AA00201609120003"}
  ]
}
```

- Response
 - 201 Created

### 상품 수정 (with id)
- **PUT** /ProductManager/v1/products/:id
- **PUT** /ProductManager/v1/products/AA00201609080005

```json
{
  "price":"5500",
  "pricing_policies":[
        {"policy_id":13}
  ]
}
```

- Response
 - 200 OK

### 상품 삭제 (with id)
- **DELETE** /ProductManager/v1/products/:id
- **DELETE** /ProductManager/v1/products/AA00201609080002

- Response
 - 204 No Content
 
  
  
### 전체 가격정책 조회
- **GET** /ProductManager/v1/products/pricing-policies/
- Response
 - 200 OK
 
```json
{
	"pricingPolicyList":[
		{"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null},
		{"policy_id":2, "policy_name":"월정액", "policy_type":"monthly_subscription", "amount":-1, "expiry_date":null},
		{"policy_id":3, "policy_name":"무료VOD", "policy_type":"free", "amount":-1, "expiry_date":null},
		{"policy_id":12, "policy_name":"[할인]박해일 특집", "policy_type":"fixed_discount", "amount":1000, "expiry_date":null},
		{"policy_id":21, "policy_name":"[고정금액]추석할인", "policy_type":"fixed_amount", "amount":7500, "expiry_date":"2016-09-19T00:00:00"},
		{"policy_id":27, "policy_name":"광고청약", "policy_type":"advertising_subscription", "amount":-1, "expiry_date":"2016-12-19T00:00:00"}
	]
}
```

### 가격정책 조회 (with policy_id)
- **GET** /ProductManager/v1/products/pricing-policies/:policy_id
- **GET** /ProductManager/v1/products/pricing-policies/12
- Response
 - 200 OK
 
```json
{	
	"policy_id":12, 
	"policy_name":"[할인]박해일 특집", 
	"policy_type":"fixed_discount", 
	"amount":1000, 
	"expiry_date":null
}
```

### 가격정책 조회 (with policy_type)
- **GET** /ProductManager/v1/products/pricing-policies?policy_type=:policy_type
- **GET** /ProductManager/v1/products/pricing-policies?policy_type=fixed_amount
- Response
 - 200 OK
 
```json
{
	"pricingPolicyList":[
		{"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null},
		{"policy_id":21, "policy_name":"[고정금액]추석할인", "policy_type":"fixed_amount", "amount":7500, "expiry_date":"2016-09-19T00:00:00"}
	]
}
```

### 가격정책 생성
- **POST** /ProductManager/v1/products/pricing-policies/

```json

```

- Response
 - 201 Created

### 가격정책 수정 (with policy_id)
- **PUT** /ProductManager/v1/products/pricing-policies/:policy_id
- **PUT** /ProductManager/v1/products/pricing-policies/21

```json

```

- Response
 - 200 OK

### 가격정책 삭제 (with policy_id)
- **DELETE** /ProductManager/v1/products/pricing-policies/:policy_id
- **DELETE** /ProductManager/v1/products/pricing-policies/21

- Response
 - 204 No Content
  
  
  
### 상품 주문
- **POST** /ProductManager/v1/orders/
 
- ground_shipping (택배 등)
```json
{
	"payment_method": "credit_card",
	"shipping_method": "ground_shipping",
	"billing": {
		"first_name": "John",
		"last_name": "Kim",
		"address": "K타워 3층",
		"postcode": "08801",
		"phone": "010-2588-2588",
		"email": "jkim@castis.com"
	},
	"shipping": {
		"first_name": "John",
		"last_name": "Kim",
		"address": "K타워 3층",
		"postcode": "08801"
	},
	"items": [
		{"product_id": "AA00201609130001", "options":{"color":"Black", "size":"S"}, "quantity": 1},
		{"product_id": "AA00201609130001", "options":{"color":"Blue", "size":"L"}, "quantity": 2}
	],
	"shipping_lines":[
		{"method": "CJ 대한통운", "total": 2500}
	]
}	
```
- online
```json
{
	"payment_method": "kakao_pay",
	"shipping_method": "online",
	"billing": {
		"first_name": "John",
		"last_name": "Kim",
		"address": "K타워 3층",
		"postcode": "08801",
		"phone": "010-2588-2588",
		"email": "jkim@castis.com"
	},
	"shipping": {
		"phone": "010-2588-2588",
		"email": "jkim@castis.com"
	},
	"items": [
		{"product_id": "AA00201609030001", "options":{}, "quantity": 1}
	],
	"shipping_lines":[]
}	
```

- Response
 - 200 OK
  

****

## Product
- **Product**

| 이름 | 타입 | 설명 |	|
| --- | --- | --- | --- | --- |
| id	 | String | 	상품 ID |	|
| name	 | String	 | 상품명	 |	|
| type	 | String	 | 상품 타입 	 | FOD(무료VOD), RVOD(편당보기VOD), SVOD(월정액VOD), <br/> SVODPackage(월정액 묶음), Bundle(묶음 상품), <br/> Advertisement(광고), Clothing(의류), ...	|
| created | String	 | 상품 생성 시각 | 'yyyy-MM-ddTHH:mm:ss'	|
| modified | String	 | 상품 수정 시각 | 'yyyy-MM-ddTHH:mm:ss'	|
| categories	 | Category | 	카테고리 리스트 |	|
| price	 | String | 	상품 가격 |	|
| tax_status	 | String | 	상품 세금 상태 | taxable(과세 대상), shipping(배송만?), none(비과세)	|
| tax_class	 | String | 	상품 세금 등급 |	|
| pricing_policies	 | PricingPolicy | 	상품 가격 정책 |	|
| image	 | String | 	상품 이미지 |	|
| description	 | String | 	상품 설명 |	|
| average_rating	 | Double | 	상품 평점 |	|
| rating_count	 | Integer | 	상품 평점 참여수   |	|
| upsell_ids	 | String[] | 	상위 상품 ID 목록 |	|
| cross_sell_ids	 | String[] | 	교차판매 상품 ID 목록 |	|
| details	 | Object | 	상품 상세 속성 |	|

- **Category**

| 이름 | 타입 | 설명 |
| --- | --- | --- | --- |
| category_id	 | Integer | 	카테고리 ID |
| category_name	 | String	 | 카테고리명	 |
| parent_category	 | Integer	 | 상위 카테고리	 |

- **PricingPolicy**

| 이름 | 타입 | 설명 |	|
| --- | --- | --- | --- | --- |
| policy_id	 | Integer | 	정책 ID |	|
| policy_name	 | String	 | 정책명	 |	|
| policy_type	 | String	 | 정책 타입 	 | free(무료), fixed_amount(고정금액), fixed_discount(고정금액 할인), <br/> rated_discount(비율 할인), monthly_subscription(월정액), <br/> advertising_subscription(광고청약) 	|
| amount | Integer	 | 금액/비율  | -1: Product의 price 값을 따름	|
| expiry_date | String	 | 정책 만료일 | 'yyyy-MM-ddTHH:mm:ss'	|

****

## 상품 종류
- **RVOD**
```json
{
  "id":"AA00201609030001",
  "name":"무한도전 496회",
  "type":"RVOD",
  "created":"2016-09-03T19:55:10",
  "modified":"2016-09-03T19:55:41",
  "categories":[
    {"category_id":87, "category_name":"무한도전"}
  ],
  "price":"1500",
  "pricing_policies":[
    {"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/infinite_challenge.png",
  "description":"무한도전 496회, 2016 무한상사",
  "average_rating":9.5,
  "rating_count":210,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
    {
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160903201"}
      ],
      "release_year":"2016",
      "actors":"유재석,박명수,정준하,하하,황광희",
      "director":"김태호",
      "summary":"2016 무한상사",
      "runtime":"80",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0,
      "episode_name":"무한도전",
      "episode_number":496
    }
}
```
- **SVOD**
```json
{
  "id": "AA00201609120002",
  "name": "MBC 월정액",
  "type": "SVOD",
  "created": "2016-09-12T18:01:12",
  "modified": "2016-09-12T18:01:12",
  "categories": [{
    "category_id": 2,
    "category_name": "월정액"
  }],
  "price": "9900",
  "pricing_policies": [
    {"policy_id":2, "policy_name":"월정액", "policy_type":"monthly_subscription", "amount":-1, "expiry_date":null}
  ],
  "image": "http://localhost:8080/ProductManager/PosterImage/MBC.png",
  "description": "MBC 월정액 입니다.",
  "average_rating":9.1,
  "rating_count":80,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details": 
   {		
    "viewingLength": "031:00:00",
    "viewablePeriodState": 0,
    "externalProductId": "SVOD_MBC",
    "related_categories": [
      { "category_id": 52, "category_name": "MBC" }
    ]
   }
}
```
- **FOD**
```json
{
  "id":"AA00201201010001",
  "name":"2016 무한상사 예고편",
  "type":"FOD",
  "created":"2012-09-03T13:55:10",
  "modified":"2016-09-03T17:24:41",
  "categories":[
    {"category_id":1, "category_name":"무료VOD"},
    {"category_id":87, "category_name":"무한도전"}
  ],
  "price":"0",
  "pricing_policies":[
    {"policy_id":3, "policy_name":"무료VOD", "policy_type":"free", "amount":-1, "expiry_date":null}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/2016_infinite_company.png",
  "description":"2016 무한상사 예고편",
  "average_rating":0.0,
  "rating_count":0,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
    {
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160903112"}
      ],
      "release_year":"2016",
      "summary":"2016 무한상사, 위기의 회사원",
      "runtime":"1",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0
    }
}
```
- **SVOD Package**
```json
{
  "id": "AA00201609120006",
  "name": "지상파 통합 월정액",
  "type": "SVODPackage",
  "created": "2016-09-12T18:01:12",
  "modified": "2016-09-12T18:01:12",
  "categories": [{
    "category_id": 3,
    "category_name": "월정액묶음"
  }],
  "price": "25900",
  "pricing_policies": [
    {"policy_id":2, "policy_name":"월정액", "policy_type":"monthly_subscription", "amount":-1, "expiry_date":null}
  ],
  "image": "http://localhost:8080/ProductManager/PosterImage/KBS_MBC_SBS.png",
  "description": "지상파 통합 월정액 입니다.",
  "average_rating":8.2,
  "rating_count":15,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details": {		
    "viewingLength": "031:00:00",
    "viewablePeriodState": 0,
    "externalProductId": "SVODPackage_1",
    "related_products": [
      {
        "id": "AA00201609120001",
        "name": "KBS 월정액"
      },
      {
        "id": "AA00201609120002",
        "name": "MBC 월정액"
      },
      {
        "id": "AA00201609120003",
        "name": "SBS 월정액"
      }
    ]
  }
}
```
- **Bundle**
```json
{
  "id":"AA00201607010001",
  "name":"어벤저스 몰아보기",
  "type":"Bundle",
  "created":"2016-07-01T19:55:10",
  "modified":"2016-07-01T19:55:41",
  "categories":[
    {"category_id":11, "category_name":"액션"}
  ],
  "price":"11900",
  "pricing_policies":[
    {"policy_id":1, "policy_name":"고정금액", "policy_type":"fixed_amount", "amount":-1, "expiry_date":null}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/Avengers.png",
  "description":"아이언맨, 캡틴아메리카, 헐크, 토르",
  "average_rating":9.1,
  "rating_count":124,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
    {
      "viewingLength" : "001:00:00",
      "viewablePeriodState" : 0,
      "externalProductId" : "Bundle_1",
      "related_products" : [ 
            {"id":"AA00201609190001", "name":"아이언맨"}, 
            {"id":"AA00201609190002", "name":"아이언맨2"}, 
            {"id":"AA00201609190003", "name":"캡틴아메리카:퍼스트 어벤져"}, 
            {"id":"AA00201609190004", "name":"인크레더블 헐크"}, 
            {"id":"AA00201609190005", "name":"토르:천둥의 신"}
        ]
    }
}
```
- **광고**
 - 단일 광고
```json
{
  "id":"AA00201609130211",
  "name":"이슬톡톡 광고",
  "type":"Advertisement",
  "created":"2016-09-13T19:55:10",
  "modified":"2016-09-13T19:55:41",
  "categories":[
    {"category_id":210, "category_name":"광고"}
  ],
  "price":"3000000",
  "pricing_policies":[
    {"policy_id":27, "policy_name":"광고청약", "policy_type":"advertising_subscription", "amount":-1, "expiry_date":"2016-12-19T00:00:00"}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/isultoktok.png",
  "description":"달의연인, 프로듀사 등을 재생하기 전에 광고로 나감",
  "average_rating":9.1,
  "rating_count":4,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
    {
      "advertisement_type":"Single",
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO1609130101"}
      ],
      "summary":"기분좋게 발그레 이슬톡톡",
      "runtime":"1"
    }
}
```

 - 광고 묶음
```json
{
  "id":"AA00201609200201",
  "name":"게임 광고 묶음",
  "type":"Advertisement",
  "created":"2016-09-19T19:55:10",
  "modified":"2016-09-19T19:55:41",
  "categories":[
    {"category_id":210, "category_name":"광고"}
  ],
  "price":"8000000",
  "pricing_policies":[
    {"policy_id":27, "policy_name":"광고청약", "policy_type":"advertising_subscription", "amount":-1, "expiry_date":"2016-12-19T00:00:00"}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/game_ad_bundle.png",
  "description":"온게임넷 콘텐트 시청 전에 광고로 나감",
  "average_rating":8.3,
  "rating_count":7,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
    {
      "advertisement_type":"Bundle",
      "summary":"거부할 수 없는 감동! 리니지2 레볼루션, 끝없이 펼쳐지는 해상전투! 한계를 뒤어넘는 리얼함을 느껴라! 해전1942",
      "runtime":"3",
      "related_products" : [
            {"id":"AA00201609200204", "name":"리니지2 레볼루션"}, 
            {"id":"AA00201609200205", "name":"해전1942"}
      ]
    }
}
```
- **Clothing**
```json
{
  "id":"AA00201609130001",
  "name":"T-shirts",
  "type":"Clothing",
  "created":"2016-09-13T11:55:10",
  "modified":"2016-09-13T11:55:41",
  "categories":[
    {"category_id":114, "category_name":"T-shirts"}
  ],
  "price":"11500",
  "pricing_policies":[
    {"policy_id":21, "policy_name":"[고정금액]추석할인", "policy_type":"fixed_amount", "amount":7500, "expiry_date":"2016-09-19T00:00:00"}
  ],
  "image":"http://localhost:8080/ProductManager/PosterImage/t-shirts.png",
  "description":"2016 신상 티셔츠",
  "average_rating":9.5,
  "rating_count":210,
  "upsell_ids": [],
  "cross_sell_ids": [],
  "details":
   {
      "attributes":[
      		{ "id":6, "name":"Color", "options":["Black","White","Blue"] },
      		{ "id":1, "name":"Size", "options":["S","M","L","XL"] }
	     ],
      "in_stock":true
   }
}
```

[맨위로] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#productmanager)
