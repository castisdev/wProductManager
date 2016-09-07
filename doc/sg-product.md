#ProductManager

## Reference
 - [개발자에게 사랑받는 API 만들기] (http://www.mimul.com/pebble/default/2012/08/07/1344315512542.html)
 - [Netflix Roulette API] (http://netflixroulette.net/api/)


## API

### 전체 상품 조회
#### `GET` /ProductManager/v1/products

- Response
 - 200 OK
 
```json
{
  "productList":[
    {
      "id":1,
      "show_id":"www.hchoice.co.kr|M0018210LFO157334201",
      "show_title":"최종병기 활",
      "release_year":"2011",
      "rating":"7.9",
      "categories":[
        {"categoryId":11, "categoryName":"액션"},
        {"categoryId":15, "categoryName":"전쟁"}
      ],
      "show_cast":"박해일,류승룡,김무열,문재원,이한위",
      "director":"김한민",
      "summary":"50만 포로가 끌려간 병자호란, 치열했던 전쟁의 한 복판에 역사가 기록하지 못한 위대한 신궁이 있었다.",
      "poster":"http://localhost:8080/ProductManager/PosterImage/war_of_the_arrows.png",
      "mediatype":0,
      "runtime":"122"
    },
    {
      "id":2,
      "show_id":"www.hchoice.co.kr|M0018210LFO116090701",
      "show_title":"부산행",
      "release_year":"2016",
      "rating":"8.5",
      "categories":[
        {"categoryId":11, "categoryName":"액션"},
        {"categoryId":12, "categoryName":"스릴러"}
      ],
      "show_cast":"공유,정유미,마동석,김수안,김의성",
      "director":"연상호",
      "summary":"정체불명의 바이러스가 전국으로 확산되고 대한민국 긴급재난경보령이 선포된 가운데, 열차에 몸을 실은 사람들은 단 하나의 안전한 도시 부산까지 살아가기 위한 치열한 사투를 벌이게 된다.",
      "poster":"http://localhost:8080/ProductManager/PosterImage/train_to_busan.png",
      "mediatype":0,
      "runtime":"118"
    }
  ]
}
```
