# API

### GetProductList
#### `GET` /product/v1/products
- 제공하는 상품 목록을 조회한다.
- Request:
```json
{
  "type": "all",
  "sortType": "nameAscend",
  "offset": 0,
  "limit": 10
}
```
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러

```json
{
	"count" : 1, 
	"productList" : [
		{
			product(상품정보)
		}
	]
}
```

### SaveProduct
#### `POST` /product/v1/products
-  상품을 생성한다.
- Request:
```json
{
  "name": "testProduct",
  "type": "RVOD",
  "smallImageFile": "smallImage.jpg",
  "imageFile": "image.jpg",
  "externalId": "",
  "viewingLength": "001:00:00",
  "viewablePeriodState": 0,
  "description": "test product save"
}
```
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
OK
 }
```

### GetProduct
#### `GET` /product/v1/products/{id}
- 상품 정보를 조회한다.
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
	"product" :		{
			product(상품정보)
		}
}
```

### UpdateProduct
#### `PUT` /product/v1/products
- 상품 정보를 업데이트 한다.
- Request:
```json
{
  "id": "123|987654",
  "name": "testProduct",
  "smallImageFile": "testsmallImage.jpg",
  "imageFile": "test.jpg",
  "externalId": "",
  "viewingLength": "001:00:00",
  "viewablePeriodState": 0,
  "description": "test product save"
}
```
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
OK
 }
```

### DeleteProduct
#### `DELETE` /product/v1/products/{id}
- 상품을 삭제한다.
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
OK
 }
```

### SearchProduct
#### `GET` /product/v1/products
- 상품을 이름으로 검색한다.
- Request:
```json
{
  "name": "product name",
  "sortType": "nameAscend",
  "offset": 0,
  "limit": 10
}
```
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
	"count" : 1, 
	"productList" : [
		{
			product(상품정보)
		}
	]
}
```

### SaveProductPolicy 
#### `POST` /product/v1/policies
- 상품의 정책 정보를 저장한다.
- Request:
```json
{
	"productId": "123|987654",
	"type" : "static ", 
	"price" : 100, 
	"licenseStart" : "2016-09-05 00:00:00", 
	"licenseEnd" : "2016-12-05 00:00:00"
}
```
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
OK
 }
```

### UpdateProductPolicy 
#### `PUT` /product/v1/policies
- 상품의 정책 정보를 업데이트 한다.
- Request:
```json
{
	"id": "12",
	"type" : "static ", 
	"price" : 100, 
	"licenseStart" : "2016-09-05 00:00:00", 
	"licenseEnd" : "2016-12-05 00:00:00"
}
```
- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
OK
 }
```

### DeleteProductPolicy 
#### `DELETE` /product/v1/policies/{id}
- 상품의 정책 정보를 삭제한다.

- Response
  - 200 성공
  - 400 Bad Request - field validation 실패시
  - 401 Unauthorized - API 인증,인가 실패
  - 404 Not found ? 해당 리소스가 없음
  - 500 Internal Server Error - 서버 에러
```json
{
OK
 }
```
