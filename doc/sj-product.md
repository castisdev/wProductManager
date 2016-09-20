
# Product Manager API
### 상품 생성
- **POST** /ProductManager/v1/products

```json
{
	"products":[
		{
			"id":"AAA100000000",
			"name":"밀정",
			"type":"RVOD",
			"regular_price":10000,
			"description":"1920년대 일제강점기, 조선인 출신 일본경찰 이정출(송강호)은 무장독립운동 단체 의열단의 뒤를 캐라는 특명으로
			의열단의 리더 김우진(공유)에게 접근하고, 한 시대의 양 극단에 서 있는 두 사람은 서로의 정체와 의도를 알면서도 속내를 감춘 채
			가까워진다... ",
			"details":{
				"director":"김지운",
				"cast":"송강호(이정출), 공유(김우진), 엄태구(하시모토)...",
				"genre":"action",
				"rating":"15",
				"runtime":140,
				"release_year":2016,
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/AAA100000000.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"}
			 ],
			"policy":[
			  {
			    "sale_price":1000, 
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-15T00:00:00"
			  }
			],
			"creation_date":"2016-09-13T12:30:00",
		}
	]
}
```

### 상품 조회
#### 전체 상품 조회
- **GET** /ProductManager/v1/products

#### 선택 상품 조회 (id)
- **GET** /ProductManager/v1/products/{id}

#### 선택 상품 조회 (type)
- **GET** /ProductManager/v1/products?type=:type

### 상품 수정
#### 선택 상품 수정 (id)
- **PUT** /ProductManager/v1/products/{id}
- Ex. /ProductManager/v1/products/AAA100000000
```json
{
	"products":[
		{
			"details":{
				"cast":"송강호(이정출), 공유(김우진), 한지민(연계순), 엄태구(하시모토)...",
			}
		}
	]
}
```
### 상품 삭제
#### 전체 상품 삭제
#### 선택 상품 삭제 (id)
- **DELETE** /ProductManager/v1/products/{id}

### 상품 타입
 상품 타입 | 
 --- | 
 RVOD | 
 SVOD |
 SVODPackage |
 bundle |
 FOD | 
 AD |

##### RVOD
```json
{
	"products":[
		{
			"id":"AAA100000000",
			"name":"밀정",
			"type":"RVOD",
			"regular_price":10000,
			"description":"1920년대 일제강점기, 조선인 출신 일본경찰 이정출(송강호)은 무장독립운동 단체 의열단의 뒤를 캐라는 특명으로
			의열단의 리더 김우진(공유)에게 접근하고, 한 시대의 양 극단에 서 있는 두 사람은 서로의 정체와 의도를 알면서도 속내를 감춘 채
			가까워진다... ",
			"details":{
				"director":"김지운",
				"cast":"송강호(이정출), 공유(김우진), 엄태구(하시모토)...",
				"genre":"action",
				"rating":"15",
				"runtime":140,
				"release_year":2016,
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/AAA100000000.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"},
			  {"category_id":5, "category_name":"액션"}
			],
			"policy":[
			  {
			    "sale_price":1000,
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-15T00:00:00"
			  }
			],
			"creation_date":"2016-09-13T12:30:00",
		}
		}
	]
}
```
##### SVOD
##### SVODPackage
##### bundle
```json
{
	"products":[
		{
			"id":"EVE100000232",
			"name":"[추석특집] 최신 액션 모아보기",
			"type":"bundle",
			"regular_price":25000,
			"description":"길고 긴 추석 연휴, 최신 액션과 함께!",
			"categories":[
			  {"category_id":222, "category_name":"[추석 특집관]"},
			],
			"policy":[
			  {
			    "price":27500, 
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-30T00:00:00"
			  }
			],
			"creation_date":"2016-09-20T14:30:05",
			"related_products":[
			  {"product_id":"AAA100000000"},
			  {"product_id":"AAB100023450"},
			  {"product_id":"CCK710900223"},
			  {"product_id":"AAA100000002"},
			]
		}
	]
}
```
##### FOD
##### AD

## REFERENCE
