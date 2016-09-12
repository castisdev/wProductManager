#ProductManager

## Reference
- [개발자에게 사랑받는 API 만들기] (http://www.mimul.com/pebble/default/2012/08/07/1344315512542.html)
- [Netflix Roulette API] (http://netflixroulette.net/api/)
- [WooCommerce REST API - Product] (https://woothemes.github.io/woocommerce-rest-api-docs/#products)
- [HTTP Status Codes] (http://www.restapitutorial.com/httpstatuscodes.html)
- [마크다운(.mk) 문법] (http://blog.kalkin7.com/2014/02/05/wordpress-markdown-quick-reference-for-koreans/)
- **MongoDB**
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
        {"categoryId":11, "categoryName":"액션"},
        {"categoryId":15, "categoryName":"전쟁"}
      ],
      "price":"2500",
      "pricing_policies":[
        {"policy_id":12, "policy_name":"[할인]박해일 특집", "policy_type":"discount_fixed", "amount":1000, "expiry_date":null}
      ],
      "image":"http://localhost:8080/ProductManager/PosterImage/war_of_the_arrows.png",
      "description":"'[HD]최종병기 활' 입니다.",
      "details":[
        {
          "assets":[
            {"asset_id":"www.hchoice.co.kr|M0018210LFO157334201"}
          ],
          "release_year":"2011",
          "average_rating":"7.9",
          "rating_count":"142",
          "actors":"박해일,류승룡,김무열,문재원,이한위",
          "director":"김한민",
          "summary":"50만 포로가 끌려간 병자호란, 치열했던 전쟁의 한 복판에 역사가 기록하지 못한 위대한 신궁이 있었다.",
          "runtime":"122",
          "viewingLength":"001:00:00",
          "viewablePeriodState":0
        }
      ]
    },
    {
      "id":"AA00201609080002",
      "name":"부산행",
      "type":"RVOD",
      "created":"2016-09-08T18:01:12",
      "modified":"2016-09-08T18:01:12",
      "categories":[
        {"categoryId":11, "categoryName":"액션"},
        {"categoryId":12, "categoryName":"스릴러"}
      ],
      "price":"4500",
      "pricing_policies":[],
      "image":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
      "description":"'[HD]부산행' 입니다.",
      "details":[
        {
          "assets":[
            {"asset_id":"www.hchoice.co.kr|M0018210LFO116090701"}
          ],
          "release_year":"2016",
          "average_rating":"8.5",
          "rating_count":"17",
          "actors":"공유,정유미,마동석,김수안,김의성",
          "director":"연상호",
          "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
          "runtime":"118",
          "viewingLength":"001:00:00",
          "viewablePeriodState":0
        }
      ]
    }
  ]
}
```


### 상품 조회 (with id)
- **GET** /ProductManager/v1/products?id=:id
- **GET** /ProductManager/v1/products?id=AA00201609080002

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
    {"categoryId":11, "categoryName":"액션"},
    {"categoryId":12, "categoryName":"스릴러"}
  ],
  "price":"4500",
  "pricing_policies":[],
  "image":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
  "description":"'[HD]부산행' 입니다.",
  "details":[
    {
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO116090701"}
      ],
      "release_year":"2016",
      "average_rating":"8.5",
      "rating_count":"17",
      "actors":"공유,정유미,마동석,김수안,김의성",
      "director":"연상호",
      "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
      "runtime":"118",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0
    }
  ]
}
```


### 상품 조회 (with type)
- **GET** /ProductManager/v1/products?type=:type
- **GET** /ProductManager/v1/products?type=SVOD

- Response
 - 200 OK
 
```json
{
  "id": "AA00201609120001",
  "name": "MBC 월정액",
  "type": "SVOD",
  "created": "2016-09-12T18:01:12",
  "modified": "2016-09-12T18:01:12",
  "categories": [{
    "categoryId": 2,
    "categoryName": "월정액"
  }],
  "price": "9900",
  "pricing_policies": [],
  "image": "http://localhost:8080/ProductManager/PosterImage/MBC.png",
  "description": "MBC 월정액 입니다.",
  "details": [{		
    "viewingLength": "031:00:00",
    "viewablePeriodState": 0,
    "externalProductId": "SVOD_MBC",
    "relatedCategories": [
      {
        "categoryId": 52,
        "categoryName": "MBC"
      }
    ]
 	}]
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
    {"categoryId":17}
  ],
  "price":"4500",
  "image":"http://localhost:8080/ProductManager/PosterImage/tunnel.png",
  "description":"'[HD]터널' 입니다."
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
    {"categoryId":87, "categoryName":"무한도전"}
  ],
  "price":"1500",
  "pricing_policies":[],
  "image":"http://localhost:8080/ProductManager/PosterImage/infinite_challenge.png",
  "description":"무한도전 496회, 2016 무한상사",
  "details":[
    {
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160903201"}
      ],
      "release_year":"2016",
      "average_rating":"9.5",
      "rating_count":"210",
      "actors":"유재석,박명수,정준하,하하,황광희",
      "director":"김태호",
      "summary":"2016 무한상사",
      "runtime":"80",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0,
      "episode_name":"무한도전",
      "episode_number":496
    }
  ]
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
    "categoryId": 2,
    "categoryName": "월정액"
  }],
  "price": "9900",
  "pricing_policies": [],
  "image": "http://localhost:8080/ProductManager/PosterImage/MBC.png",
  "description": "MBC 월정액 입니다.",
  "details": [{		
    "viewingLength": "031:00:00",
    "viewablePeriodState": 0,
    "externalProductId": "SVOD_MBC",
    "relatedCategories": [
      {
        "categoryId": 52,
        "categoryName": "MBC"
      }
    ]
 	}]
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
    {"categoryId":1, "categoryName":"무료VOD"},
    {"categoryId":87, "categoryName":"무한도전"}
  ],
  "price":"0",
  "pricing_policies":[],
  "image":"http://localhost:8080/ProductManager/PosterImage/2016_infinite_company.png",
  "description":"2016 무한상사 예고편",
  "details":[
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
  ]
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
    "categoryId": 3,
    "categoryName": "월정액묶음"
  }],
  "price": "25900",
  "pricing_policies": [],
  "image": "http://localhost:8080/ProductManager/PosterImage/KBS_MBC_SBS.png",
  "description": "지상파 통합 월정액 입니다.",
  "details": [{		
    "viewingLength": "031:00:00",
    "viewablePeriodState": 0,
    "externalProductId": "SVODPackage_1",
    "relatedProducts": [
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
 	}]
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
    {"categoryId":11, "categoryName":"액션"}
  ],
  "price":"11900",
  "pricing_policies":[],
  "image":"http://localhost:8080/ProductManager/PosterImage/Avengers.png",
  "description":"아이언맨, 캡틴아메리카, 헐크, 토르",
  "details":[
    {
      "assets":[
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160701101"},
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160701102"},
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160701103"},
        {"asset_id":"www.hchoice.co.kr|M0018210LFO160701104"},
      ],
      "average_rating":"8.9",
      "rating_count":"115",
      "summary":"아이언맨, 캡틴아메리카, 헐크, 토르",
      "runtime":"482",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0
    }
  ]
}
```
