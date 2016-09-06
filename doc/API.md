# API

### GetProductList
#### `GET` /DBAPIServer/getProductList.json
- 제공하는 상품 목록을 조회한다.
- Request:
```json
{
  "type": "all",
  "profile": 0,
  "sortType": "nameAscend",
  "pageSize": 10,
  "pageIndex": 0,
  "startItemIndex": 0
}
```
- Response
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"version" : 1, 
	"transactionId" : 307, 
	"resultCode" : 100, 
	"errorString" : "",
	"totalCount" : 1, 
	"productList" : [
		{
			"id" : "123|987654", 
			"name" : "캐치온디맨드", 
			"type" : "SVOD", 
			"smallImageFile" : "Http://localhost:8080/smallImage.jpg"
		}
	]
}
```

### SaveProduct
#### `POST` /DBAPIServer/saveProduct.json
- 제공하는 상품 목록을 조회한다.
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
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : ""
 }
```

### GetProduct
#### `GET` /DBAPIServer/getProduct.json
- 상품 정보를 조회한다.
- Request:
```json
{
  "id": "123|987654",
  "profile": "3"
}
```
- Response
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : "", 
	"product" :		{
			"id" : "123|987654", 
			"name" : "캐치온디맨드", 
			"type" : "SVOD", 
			"smallImageFile" : "Http://localhost:8080/smallImage.jpg", 
			"imageFile" : "Http://localhost:8080/image.jpg", 
			"externalId" : "SVOD_01", 
			"viewingLength" : 3,
			"viewablePeriodState" : 0,
			"description" : "상품 설명",
			"policyList" : [
				{
				"id" : "4736", 
				"type" : "static", 
				"price" : 10000, 
				"licenseStart" : "2011-01-01 00:00:00", 
				"licenseEnd" : "2016-01-01 00:00:00"
				}
			]
		}
}
```

### UpdateProduct
#### `POST` /DBAPIServer/updateProduct.json
- 상품 정보를 엄데이트 한다.
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
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : ""
 }
```

### DeleteProduct
#### `POST` /DBAPIServer/deleteProduct.json
- 상품을 삭제한다.
- Request:
```json
{
  "id": "123|987654"
}
```
- Response
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : ""
 }
```

### SearchProduct
#### `GET` /DBAPIServer/searchProduct.json
- 상품을 삭제한다.
- Request:
```json
{
  "name": "product name",
  "profile": 0
}
```
- Response
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : "",
	"totalCount" : 1, 
	"productList" : [
		{
			"id" : "123|987654", 
			"name" : "product name", 
			"type" : "simple", 
			"smallImageFile" : "http://localhost:8080/smallImage.jpg"
		}
	]
}
```

### SaveProductPolicy 
#### `POST` /DBAPIServer/saveProductPolicy.json
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
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : ""
 }
```

### UpdateProductPolicy 
#### `POST` /DBAPIServer/updateProductPolicy.json
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
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : ""
 }
```

### DeleteProductPolicy 
#### `POST` /DBAPIServer/deleteProductPolicy.json
- 상품의 정책 정보를 삭제한다.
- Request:
```json
{
  "id": "12"
}
```
- Response
  - 100	: 성공 (Success)
  - 200	: 알 수 없는 에러 (General Error)
  - 204	: 잘못된 요청파라미터 값 (Invalid Parameter)
  - 211	: 일반 DB 에러 (DB General Error)
```json
{
	"resultCode" : 100, 
	"errorString" : ""
 }
```
