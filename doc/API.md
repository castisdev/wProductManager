# API


#### `GET` /DBAPIServer/getProductList.[xml | json]
- 특정 지역의 네트워크 리소스 할당이 가능한 최대 대역폭 요청
- Request:
```json
{
  "type": "all",
  "profile": 2,
  "sortType": "nameAscend",
  "pageSize": 10,
  "pageIndex": 0,
  "startItemIndex": 0,
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
			"externalId" : "SVOD_01", 
			"name" : "캐치온디맨드", 
			"type" : "SVOD", 
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
	]
}
```
```xml
<response>
	<version>1</version> 
	<transactionId>304</transactionId> 
	<resultCode>100</resultCode>
	<errorString />
	<totalCount>2</totalCount>
	<productList>
	<product>
		<id>123|987654</id>
		<externalId>SVOD_01</externalId>
		<name>캐치온디맨드</name>
		<type>SVOD</type>
		<policyList>
		 <policy>
		   <id>4736</id>
		   <type>static</type>
		   <price>10000</price>
		   <licenseStart>2011-01-01 00:00:00</licenseStart>
		   <licenseEnd>2016-01-01 00:00:00</licenseEnd>
		 </policy>
		</policyList>
	</product>
	</productList>
</response>

```
