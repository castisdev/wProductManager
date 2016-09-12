###상품 기본 정보 (Basic)
#### 상품 정보 생성 (Create a Product)
`POST` /v1/products/product
 - Parameters
 - Request Sample
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
