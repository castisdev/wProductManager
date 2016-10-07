#ProductManager
## 목차
- [ProductManager 설계 및 개발] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#productmanager-설계-및-개발)
 - [개발 범위] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#개발-범위)
 - [현재 API 설계 진행률] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#현재-api-설계-진행률)
- [Reference] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#reference)
- [API] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#api)
 - [상품 API] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#product-api)
 - [카테고리 API] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#category-api)
 - [아이템 API] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#item-api)
 - [주문 API] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#order-api)
- [Product] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#product)
 	- Product
 	- Category
	- Item
- [상품 종류] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#상품-종류)
	 - simple
	 - bundle

## ProductManager 설계 및 개발
#### 개발 범위
- API
	- Product (상품 생성/조회/수정/삭제)
	- ~~PricingPolicy (가격정책 생성/조회/수정/삭제)~~
	- Category (카테고리 생성/조회/수정/삭제)
	- Item (아이템 생성/조회/수정/삭제)
- 상품 종류
	- simple, bundle
- ProtoType App
	- jdk 1.7
	- tomcat 7
	- springframework 3
		- Spring-Data MongoDB
	- mongoDB 3.2
	- 상품/~~가격정책~~/카테고리의 CRUD가 가능한 app 개발 <br/><br/>
	- **개발 예상 MD: 5 MD**

#### 현재 API 설계 진행률
- 99%
	- Product CRUD API 완료
	- ~~PricingPolicy CRUD API 완료~~
	- Category CRUD API 완료

#### proto-type ProductManager API

- 전체 상품 조회: (GET) http://172.16.33.11:8080/ProductManager/v1/products
- 상품 조회(with ID): (GET) http://172.16.33.11:8080/ProductManager/v1/products/AA00201609030001
- 상품 조회(with type or name): (GET) http://172.16.33.11:8080/ProductManager/v1/products?type=SVOD&name=MBC
- 상품 생성: (POST) http://localhost:8080/ProductManager/v1/products
```json
{
  "product_id":"AA00201609290002",
  "name":"아는 형님 40화",
  "type":"RVOD",
  "categories":[
    {"categoryId":133}
  ],
  "price":"4500",
  "on_sale":false,
  "payment_type":"one_off_payment",
  "tax_status":"none",
  "image":"http://localhost:8080/ProductManager/PosterImage/jtbc_bros_40.png",
  "description":"아는형님 40화 입니다."
}
```
- 상품 수정: (PUT) http://localhost:8080/ProductManager/v1/products/AA00201609290002
```json
{
  "price":"3000"
}
```
****


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

### Product API
#### 전체 상품 조회
- **GET** /ProductManager/v1/products

- Response
 - 200 OK

```json
{
  "productList":[
    {
	"id":"AA00201201010001",
	"name":"최종병기 활",
	"type":"simple",
	"items":[{
	    "item_id":"IT00201201010001",
	    "item_name":"최종병기 활(2011)",
	    "item_type":"VOD",
	    "linkage_id":"www.hchoice.co.kr|M0018210LFO120101001",
	    "item_description":"[HD]최종병기 활"
	}],
	"created":"2012-01-01T13:55:10",
	"modified":"2016-09-07T17:24:41",
	"categories":[
	{"category_id":11, "category_name":"액션"},
	{"category_id":15, "category_name":"전쟁"}
	],
	"price":"2500",
	"sale_price":"",
	"sale_start_date":"",
	"sale_end_date":"",
	"on_sale":false,
	"payment_type":"one_off_payment",
	"tax_status":"none",
	"tax_class":"",
	"image":"http://localhost:8080/ProductManager/PosterImage/war_of_the_arrows.png",
	"description":"'[HD]최종병기 활' 입니다.",
	"average_rating":7.9,
	"rating_count":642,
	"upsell_ids": [],
	"cross_sell_ids": []
    },
    {
	"id":"AA00201609080002",
	"name":"부산행",
	"type":"simple",
	"items":[{
  		"item_id":"IT00201609070001",
		"item_name":"부산행(Train to Busan, 2016)",
		"item_type":"VOD",
		"linkage_id":"www.hchoice.co.kr|M0018210LFO160101001",
		"item_description":"[HD]부산행"
	}],
	"created":"2016-09-08T18:01:12",
	"modified":"2016-09-08T18:01:12",
	"categories":[
		{"category_id":11, "category_name":"액션"},
		{"category_id":12, "category_name":"스릴러"}
	],
	"price":"4500",
	"sale_price":"",
	"sale_start_date":"",
	"sale_end_date":"",
	"on_sale":false,
	"payment_type":"one_off_payment",
	"tax_status":"none",
	"tax_class":"",
	"image":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
	"description":"'[HD]부산행' 입니다.",
	"average_rating":8.5,
	"rating_count":17,
	"upsell_ids": [],
	"cross_sell_ids": []
    }
  ]
}
```

#### 단일 상품 조회 (with id)
- **GET** /ProductManager/v1/products/:id
- **GET** /ProductManager/v1/products/AA00201609080002

- Response
 - 200 OK

```json
{
  "id":"AA00201609080002",
  "name":"부산행",
  "type":"simple",
  "items":[{
	"item_id":"IT00201609070001",
	"item_name":"부산행(Train to Busan, 2016)",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO160101001",
	"item_description":"[HD]부산행"
  }],
  "created":"2016-09-08T18:01:12",
  "modified":"2016-09-08T18:01:12",
  "categories":[
	{"category_id":11, "category_name":"액션"},
	{"category_id":12, "category_name":"스릴러"}
  ],
  "price":"4500",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"one_off_payment",
  "tax_status":"none",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
  "description":"'[HD]부산행' 입니다.",
  "average_rating":8.5,
  "rating_count":17,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```

#### 상품 조회 (with type)
- **GET** /ProductManager/v1/products?type=:type
- **GET** /ProductManager/v1/products?type=SVOD

- Response
 - 200 OK

```json
{
  "productList":[
    {
	  "id": "AA00201609120002",
	  "name": "MBC 월정액",
	  "type": "simple",
  	  "items":[{
    		"item_id":"IT00201609030002",
    		"item_name":"MBC",
    		"item_type":"Category",
    		"linkage_id":"category_52",
    		"item_description":"MBC 카테고리"
  	  }],
	  "created": "2016-09-12T18:01:12",
	  "modified": "2016-09-12T18:01:12",
	  "categories": [{
	    "category_id": 2,
	    "category_name": "월정액"
	  }],
	  "price": "9900",
	  "sale_price":"",
	  "sale_start_date":"",
	  "sale_end_date":"",
	  "on_sale":false,
	  "payment_type":"monthly_payment",
	  "tax_status":"none",
	  "tax_class":"",	
	  "image": "http://localhost:8080/ProductManager/PosterImage/MBC.png",
	  "description": "MBC 월정액 입니다.",
	  "average_rating":9.1,
	  "rating_count":80,
	  "upsell_ids": [],
	  "cross_sell_ids": []
    }
  ]
}

```

#### 상품 생성
- **POST** /ProductManager/v1/products/

```json
{
  "id":"AA00201609080005",
  "name":"터널",
  "type":"simple",
  "items":[{
    "item_id":"IT00201609080001"
  }],
  "categories":[
    {"category_id":17}
  ],
  "price":"4500",
  "on_sale":false,
  "payment_type":"one_off_payment",
  "tax_status":"none",
  "image":"http://localhost:8080/ProductManager/PosterImage/tunnel.png",
  "description":"'[HD]터널' 입니다."
}
```

- Response
 - 201 Created

#### 묶음 상품 생성 (SVODPackage, Bundle, Advertisement(Bundle))
- **POST** /ProductManager/v1/products/

```json
{
  "id": "AA00201609120006",
  "name": "지상파 통합 월정액",
  "type": "bundle",
  "items":[
  	{"item_id":"IT00201609030004"},{"item_id":"IT00201609030005"},{"item_id":"IT00201609030006"}
  ],
  "categories":[
	{"category_id":3}
  ],
  "price":"25900",
  "on_sale":false,
  "payment_type":"one_off_payment",
  "tax_status":"none",
  "image":"http://localhost:8080/ProductManager/PosterImage/KBS_MBC_SBS.png",
  "description":"지상파 통합 월정액 입니다."
}
```

- Response
 - 201 Created

#### 상품 수정 (with id)
- **PUT** /ProductManager/v1/products/:id
- **PUT** /ProductManager/v1/products/AA00201609080005

```json
{  
  "sale_price":"3500",
  "sale_start_date":"2016-09-29T00:00:00",
  "sale_end_date":"2016-10-31T23:59:59",
  "on_sale":true
}
```

- Response
 - 200 OK

#### 상품 삭제 (with id)
- **DELETE** /ProductManager/v1/products/:id
- **DELETE** /ProductManager/v1/products/AA00201609080002

- Response
 - 204 No Content


### Category API
#### 전체 카테고리 조회
- **GET** /ProductManager/v1/products/categories/
- Response
 - 200 OK
 
```json
{
	"categoryList":[
    		{"category_id":1, "category_name":"무료VOD", "parent_category":0},
    		{"category_id":2, "category_name":"영화", "parent_category":0},
    		{"category_id":11, "category_name":"액션", "parent_category":2},
        	{"category_id":15, "category_name":"전쟁", "parent_category":2}
	]
}
```

#### 카테고리 조회 (with category_id)
- **GET** /ProductManager/v1/products/categories/:category_id
- **GET** /ProductManager/v1/products/categories/87
- Response
 - 200 OK
 
```json
{
    	"category_id":87, "category_name":"무한도전", "parent_category":52
}
```

#### 카테고리 생성
- **POST** /ProductManager/v1/products/categories/

```json
{
    	"category_id":255, "category_name":"혼술남녀", "parent_category":215
}
```

- Response
 - 201 Created

#### 카테고리 수정 (with category_id)
- **PUT** /ProductManager/v1/products/categories/:category_id
- **PUT** /ProductManager/v1/products/categories/255

```json
{
	"category_name":"[HD]혼술남녀"
}
```

- Response
 - 200 OK

#### 카테고리 삭제 (with category_id)
- **DELETE** /ProductManager/v1/products/categories/:category_id
- **DELETE** /ProductManager/v1/products/categories/255

- Response
 - 204 No Content

### Item API
#### 전체 아이템 조회
- **GET** /ProductManager/v1/products/items/
- Response
 - 200 OK
 
```json
{
	"itemList":[
		{
			"item_id":"IT00201609030001",
			"item_name":"무한도전.E496.160903",
			"item_type":"VOD",
			"linkage_id":"www.hchoice.co.kr|M0018210LFO160903201",
			"item_description":"2016 무한상사, 위기의 회사원"
		},{
			"item_id":"IT00201609030002",
			"item_name":"MBC",
			"item_type":"Category",
			"linkage_id":"category_52",
			"item_description":"MBC 카테고리"
		},{
			"item_id":"IT00201610050001",
			"item_name":"이슬톡톡(CF)",
			"item_type":"AD",
			"linkage_id":"www.hchoice.co.kr|M0018210ADO161005001",
			"item_description":"기분좋게 발그레 이슬톡톡"
		}
	]
}
```

#### 아이템 조회 (with item_id)
- **GET** /ProductManager/v1/products/items/:item_id
- **GET** /ProductManager/v1/products/items/IT00201609030007
- Response
 - 200 OK
 
```json
{
	"item_id":"IT00201609030007",
	"item_name":"아이언맨(Iron Man, 2008)",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO161005001",
	"item_description":"아이언맨1"
}
```

#### 아이템 조회 (with item_type)
- **GET** /ProductManager/v1/products/items?type=:item_type
- **GET** /ProductManager/v1/products/items/type=Category
- Response
 - 200 OK
 
```json
{
	"itemList":[
		{
			"item_id":"IT00201609030004",
			"item_name":"KBS",
			"item_type":"Category",
			"linkage_id":"category_51",
			"item_description":"KBS 카테고리"
		},{
			"item_id":"IT00201609030005",
			"item_name":"MBC",
			"item_type":"Category",
			"linkage_id":"category_52",
			"item_description":"MBC 카테고리"
		},{
			"item_id":"IT00201609030006",
			"item_name":"SBS",
			"item_type":"Category",
			"linkage_id":"category_53",
			"item_description":"SBS 카테고리"
		}
	]
}
```

#### 아이템 생성
- **POST** /ProductManager/v1/products/items/

```json
{
	"item_id":"IT00201610070001",
	"item_name":"tvN",
	"item_type":"Category",
	"linkage_id":"category_70",
	"item_description":"tvN 카테고리"
}
```

- Response
 - 201 Created

#### 아이템 수정 (with item_id)
- **PUT** /ProductManager/v1/products/items/:item_id
- **PUT** /ProductManager/v1/products/items/IT00201610070001

```json
{
	"item_description":"tvN 카테고리 설명 수정"
}
```

- Response
 - 200 OK

#### 아이템 삭제 (with item_id)
- **DELETE** /ProductManager/v1/products/items/:item_id
- **DELETE** /ProductManager/v1/products/items/IT00201610070001

- Response
 - 204 No Content


### Order API
#### 상품 주문
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
| ~~type~~	 | ~~String~~	 | ~~상품 타입~~ 	 | ~~FOD(무료VOD), RVOD(편당보기VOD), SVOD(월정액VOD), <br/> SVODPackage(월정액 묶음), Bundle(묶음 상품), <br/> Advertisement(광고), Clothing(의류), ...~~	|
| type	 | String	 | 상품 타입 	 | simple, bundle	|
| items	 | List&lt;Item&gt;	 | 아이템 목록 	 | 	|
| created | String	 | 상품 생성 시각 | 'yyyy-MM-ddTHH:mm:ss'	|
| modified | String	 | 상품 수정 시각 | 'yyyy-MM-ddTHH:mm:ss'	|
| categories	 | Category | 	카테고리 리스트 |	|
| price	 | String | 	상품 가격 |	|
| sale_price	 | String | 	할인 가격 |	|
| sale_start_date	 | String | 	할인 시작 시각 |	|
| sale_end_date	 | String | 	할인 종료 시각 |	|
| on_sale	 | Boolean | 	상품 할인 여부 |	|
| payment_type	 | String | 	가격 지불 방법 | one_off_payment(일시불), monthly_payment(월정액), <br/> subscription_payment(광고 청약), free(무료)	|
| tax_status	 | String | 	상품 세금 상태 | taxable(과세 대상), shipping(배송만?), none(비과세)	|
| tax_class	 | String | 	상품 세금 등급 |	|
| image	 | String | 	상품 이미지 |	|
| description	 | String | 	상품 설명 |	|
| average_rating	 | Double | 	상품 평점 |	|
| rating_count	 | Integer | 	상품 평점 참여수   |	|
| upsell_ids	 | String[] | 	상위 상품 ID 목록 |	|
| cross_sell_ids	 | String[] | 	교차판매 상품 ID 목록 |	|
| ~~details~~	 | ~~Object~~ | 	~~상품 상세 속성~~ |	|

- **Item**

| 이름 | 타입 | 설명 |	|
| --- | --- | --- | --- | --- |
| item_id	 | String | 	아이템 ID |	|
| item_name	 | String	 | 아이템명	 |	|
| item_type	 | String	 | 아이템 타입  | VOD, AD, Clothing, Channel, Category ...	|
| linkage_id	 | String	 | 아이템 연결된 ID  | 	 |
| item_description	 | String	 | 아이템 상세설명	 |	|

- **Category**

| 이름 | 타입 | 설명 |
| --- | --- | --- | --- |
| category_id	 | Integer | 	카테고리 ID |
| category_name	 | String	 | 카테고리명	 |
| parent_category	 | Integer	 | 상위 카테고리	 |

****

## 상품 종류
- **RVOD**
```json
{
  "id":"AA00201609030001",
  "name":"무한도전 496회",
  "type":"simple",
  "items":[{
  	"item_id":"IT00201609030001",
	"item_name":"무한도전.E496.160903",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO160903201",
	"item_description":"2016 무한상사, 위기의 회사원"
  }],
  "created":"2016-09-03T19:55:10",
  "modified":"2016-09-03T19:55:41",
  "categories":[
    {"category_id":87, "category_name":"무한도전"}
  ],
  "price":"1500",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"one_off_payment",
  "tax_status":"none",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/infinite_challenge.png",
  "description":"무한도전 496회, 2016 무한상사 위기의 회사원",
  "average_rating":9.5,
  "rating_count":210,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```
- **SVOD**
```json
{
  "id": "AA00201609120002",
  "name": "MBC 월정액",
  "type": "simple",
  "items":[{
  	"item_id":"IT00201609030002",
	"item_name":"MBC",
	"item_type":"Category",
	"linkage_id":"category_52",
	"item_description":"MBC 카테고리"
  }],
  "created": "2016-09-12T18:01:12",
  "modified": "2016-09-12T18:01:12",
  "categories": [{
    "category_id": 2,
    "category_name": "월정액"
  }],
  "price": "9900",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"monthly_payment",
  "tax_status":"none",
  "tax_class":"",
  "image": "http://localhost:8080/ProductManager/PosterImage/MBC.png",
  "description": "MBC 월정액 입니다.",
  "average_rating":9.1,
  "rating_count":80,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```
- **FOD**
```json
{
  "id":"AA00201201010001",
  "name":"2016 무한상사 예고편",
  "type":"simple",
  "items":[{
  	"item_id":"IT00201609030003",
	"item_name":"무한도전.E496.160903.preview",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO160903112",
	"item_description":"무한상사 예고편"
  }],
  "created":"2012-09-03T13:55:10",
  "modified":"2016-09-03T17:24:41",
  "categories":[
    {"category_id":1, "category_name":"무료VOD"},
    {"category_id":87, "category_name":"무한도전"}
  ],
  "price":"0",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"free",
  "tax_status":"none",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/2016_infinite_company.png",
  "description":"2016 무한상사 예고편",
  "average_rating":0.0,
  "rating_count":0,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```
- **SVOD Package**
```json
{
  "id": "AA00201609120006",
  "name": "지상파 통합 월정액",
  "type": "bundle",
  "items":[
  {
  	"item_id":"IT00201609030004",
	"item_name":"KBS",
	"item_type":"Category",
	"linkage_id":"category_51",
	"item_description":"KBS 카테고리"
  },{
  	"item_id":"IT00201609030005",
	"item_name":"MBC",
	"item_type":"Category",
	"linkage_id":"category_52",
	"item_description":"MBC 카테고리"
  },{
  	"item_id":"IT00201609030006",
	"item_name":"SBS",
	"item_type":"Category",
	"linkage_id":"category_53",
	"item_description":"SBS 카테고리"
  }
  ],
  "created": "2016-09-12T18:01:12",
  "modified": "2016-09-12T18:01:12",
  "categories": [{
    "category_id": 3,
    "category_name": "월정액묶음"
  }],
  "price": "25900",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"monthly_payment",
  "tax_status":"none",
  "tax_class":"",
  "image": "http://localhost:8080/ProductManager/PosterImage/KBS_MBC_SBS.png",
  "description": "지상파 통합 월정액 입니다.",
  "average_rating":8.2,
  "rating_count":15,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```
- **Bundle**
```json
{
  "id":"AA00201607010001",
  "name":"어벤저스 몰아보기",
  "type":"bundle",
  "items":[
  {
  	"item_id":"IT00201609030007",
	"item_name":"아이언맨(Iron Man, 2008)",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO161005001",
	"item_description":"아이언맨1"
  },{
  	"item_id":"IT00201609030008",
	"item_name":"캡틴 아메리카:퍼스트 어벤져(Captain America: The First Avenger, 2011)",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO161005002",
	"item_description":"캡틴아메리카1"
  },{
  	"item_id":"IT00201609030009",
	"item_name":"토르: 천둥의 신(Thor, 2011)",
	"item_type":"VOD",
	"linkage_id":"www.hchoice.co.kr|M0018210LFO161005003",
	"item_description":"토르1"
  }
  ],
  "created":"2016-07-01T19:55:10",
  "modified":"2016-07-01T19:55:41",
  "categories":[
    {"category_id":11, "category_name":"액션"}
  ],
  "price":"11900",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"one_off_payment",
  "tax_status":"none",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/Avengers.png",
  "description":"아이언맨, 캡틴아메리카, 헐크, 토르",
  "average_rating":9.1,
  "rating_count":124,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```
- **광고**
 - 단일 광고
```json
{
  "id":"AA00201609130211",
  "name":"이슬톡톡 광고",
  "type":"simple",
  "items":[{
  	"item_id":"IT00201610050001",
	"item_name":"이슬톡톡(CF)",
	"item_type":"AD",
	"linkage_id":"www.hchoice.co.kr|M0018210ADO161005001",
	"item_description":"기분좋게 발그레 이슬톡톡"
  }],
  "created":"2016-09-13T19:55:10",
  "modified":"2016-09-13T19:55:41",
  "categories":[
    {"category_id":210, "category_name":"광고"}
  ],
  "price":"3000000",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"subscription_payment",
  "tax_status":"none",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/isultoktok.png",
  "description":"달의연인, 프로듀사 등을 재생하기 전에 광고로 나감",
  "average_rating":9.1,
  "rating_count":4,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```

 - 광고 묶음
```json
{
  "id":"AA00201609200201",
  "name":"모바일게임 광고 묶음",
  "type":"bundle",
  "items":[
  {
  	"item_id":"www.hchoice.co.kr|M0018210ADO161005002",
	"item_name":"리니지2 레볼루션(CF)",
	"item_type":"AD",
	"item_description":"거부할 수 없는 감동! 리니지2 레볼루션"
  },{
  	"item_id":"www.hchoice.co.kr|M0018210ADO161005003",
	"item_name":"해전1942(CF)",
	"item_type":"AD",
	"item_description":"끝없이 펼쳐지는 해상전투! 한계를 뒤어넘는 리얼함을 느껴라! 해전1942"
  }
  ],
  "created":"2016-09-19T19:55:10",
  "modified":"2016-09-19T19:55:41",
  "categories":[
    {"category_id":210, "category_name":"광고"}
  ],
  "price":"8000000",
  "sale_price":"",
  "sale_start_date":"",
  "sale_end_date":"",
  "on_sale":false,
  "payment_type":"subscription_payment",
  "tax_status":"none",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/game_ad_bundle.png",
  "description":"온게임넷 콘텐트 시청 전에 광고로 나감",
  "average_rating":8.3,
  "rating_count":7,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```
- **Clothing**
```json
{
  "id":"AA00201609130001",
  "name":"T-shirts",
  "type":"simple",
  "items":[{
  	"item_id":"www.hchoice.co.kr|M0018210ADO161005002",
	"item_name":"T-shirts_2016_summer",
	"item_type":"Clothing",
	"item_description":"2016 여름 신상"
  }],
  "created":"2016-09-13T11:55:10",
  "modified":"2016-09-13T11:55:41",
  "categories":[
    {"category_id":114, "category_name":"T-shirts"}
  ],
  "price":"11500",
  "sale_price":"5000",
  "sale_start_date":"2016-09-14T00:00:00",
  "sale_end_date":"2016-09-18T23:59:59",
  "on_sale":true,
  "payment_type":"one_off_payment",
  "tax_status":"taxable",
  "tax_class":"",
  "image":"http://localhost:8080/ProductManager/PosterImage/t-shirts.png",
  "description":"2016 신상 티셔츠",
  "average_rating":9.5,
  "rating_count":210,
  "upsell_ids": [],
  "cross_sell_ids": []
}
```

[맨위로] (https://github.com/castisdev/wProductManager/blob/master/doc/sg-product.md#productmanager)

***
~~~

## 삭제해버림...

- **PricingPolicy**

| 이름 | 타입 | 설명 |	|
| --- | --- | --- | --- | --- |
| policy_id	 | Integer | 	정책 ID |	|
| policy_name	 | String	 | 정책명	 |	|
| policy_type	 | String	 | 정책 타입 	 | free(무료), fixed_amount(고정금액), fixed_discount(고정금액 할인), <br/> rated_discount(비율 할인), monthly_subscription(월정액), <br/> advertising_subscription(광고청약) 	|
| amount | Integer	 | 금액/비율  | -1: Product의 price 값을 따름	|
| expiry_date | String	 | 정책 만료일 | 'yyyy-MM-ddTHH:mm:ss'	|

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
{
	"policy_id":114,
	"policy_name":"[할인]또 오해영, 또 할인",
	"policy_type":"fixed_discount",
	"amount":3000,
	"expiry_date":"2016-10-15T00:00:00"
}
```

- Response
 - 201 Created

### 가격정책 수정 (with policy_id)
- **PUT** /ProductManager/v1/products/pricing-policies/:policy_id
- **PUT** /ProductManager/v1/products/pricing-policies/114

```json
{
	"amount":2000,
	"expiry_date":"2017-01-01T00:00:00"
}
```

- Response
 - 200 OK

### 가격정책 삭제 (with policy_id)
- **DELETE** /ProductManager/v1/products/pricing-policies/:policy_id
- **DELETE** /ProductManager/v1/products/pricing-policies/114

- Response
 - 204 No Content


