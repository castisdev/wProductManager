#ProductManager

## Reference
- [개발자에게 사랑받는 API 만들기] (http://www.mimul.com/pebble/default/2012/08/07/1344315512542.html)
- [Netflix Roulette API] (http://netflixroulette.net/api/)
- [HTTP Status Codes] (http://www.restapitutorial.com/httpstatuscodes.html)
- [마크다운(.mk) 문법] (http://blog.kalkin7.com/2014/02/05/wordpress-markdown-quick-reference-for-koreans/)


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
      "type":"vod",
      "categories":[
        {"categoryId":11, "categoryName":"액션"},
        {"categoryId":15, "categoryName":"전쟁"}
      ],
      "price":"2500",
      "pricing_policies":[
        {"policy_id":12, "policy_name":"[할인]박해일 특집", "policy_type":"discount", "price":1000}
      ],
      "image":"http://localhost:8080/ProductManager/PosterImage/war_of_the_arrows.png",
      "description":"'[HD]최종병기 활' 입니다.",
      "details":[
        {
          "assets":[
            {"asset_id":"www.hchoice.co.kr|M0018210LFO157334201"}
          ],
          "release_year":"2011",
          "rating":"7.9",
          "actors":"박해일,류승룡,김무열,문재원,이한위",
          "director":"김한민",
          "summary":"50만 포로가 끌려간 병자호란, 치열했던 전쟁의 한 복판에 역사가 기록하지 못한 위대한 신궁이 있었다.",
          "mediatype":0,
          "runtime":"122",
          "viewingLength":"001:00:00",
          "viewablePeriodState":0
        }
      ]
    },
    {
      "id":"AA00201609080002",
      "name":"부산행",
      "type":"vod",
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
          "rating":"8.5",
          "actors":"공유,정유미,마동석,김수안,김의성",
          "director":"연상호",
          "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
          "mediatype":0,
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
- **GET** /ProductManager/v1/products/:id
- **GET** /ProductManager/v1/products/AA00201609080002

- Response
 - 200 OK
 
```json
{
  "id":"AA00201609080002",
  "name":"부산행",
  "type":"vod",
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
      "rating":"8.5",
      "actors":"공유,정유미,마동석,김수안,김의성",
      "director":"연상호",
      "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
      "mediatype":0,
      "runtime":"118",
      "viewingLength":"001:00:00",
      "viewablePeriodState":0
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
  "type":"vod",
  "categories":[
    {"categoryId":17, "categoryName":"드라마"}
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
  "pricing_policies":[
        {"policy_id":13, "policy_name":"[할인]하정우 특집", "policy_type":"discount", "price":1000}
  ],
  "details":[
    {
      "viewingLength":"007:00:00",
      "viewablePeriodState":0
    }
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
