
# Product Manager
## 개발 범위
 1. 상품 범주
  - 상품 (vod, 광고 상품) CRUD <br/>
    - FOD, RVOD, bundle, SVOD, SVODPackage, AD, AD-bundle
  - 상품 카테고리 CRUD
  - 상품 정책 CRUD
 2. prototype app
  - jdk 1.7
  - tomcat 7
  - spring 4
  - mongoDB
  - prototype app 개발 예상 MD : 5MD (설계별도)
 3. 현재 API 설계 진행률
  - 65%
    - 상품 CRUD API 완료
    - 상품 카테고리 CRUD API 설계중
    - 상품 정책 CRUD API 설계중

## 상품 설계 마인드맵
![preview](https://raw.githubusercontent.com/ssuji/github-test/master/resources/img/product-mindmap.png)

---

## 상품 schema
- **Product** 
 
 이름  | 타입 | 설명
 --- | --- | --- 
 id | string | 상품 id
 name | string | 상품 이름
 type | string | 상품 타입 </br> VOD (비디오) &nbsp; Clothes (옷) &nbsp; Music (음원) ...
 detailed_type | string | 상품 상세 타입 </br> FOD (무료VOD) </br> RVOD (VOD) &nbsp;  bundle (묶음상품) </br> SVOD (월정액) &nbsp; SVODPackage (월정액묶음) </br> AD (광고상품) &nbsp; AD-bundle (광고상품묶음)
 reqular_price | integer | 상품 정규가격 </br> (실제가격은 polices에 의해 변동 가능)
 description | string | 상품 개요
 details | **details** | 상품 상세정보
 categories | **array** | 상품 카테고리 리스트. &nbsp; **category**의 list
 policies | **array** | 상품 정책 리스트. &nbsp; **policy**의 list
 creation_date | date | 상품 생성일
 related_products | **array** | 관련 상품 정보 리스트.  &nbsp; **related_product** 의 list
> 상품의 각 type 별 detailed_type 지정 가능
>> 현재는 비디오상품의 상세 타입만 예시

- **details** 

 이름  | 타입 | 설명
 --- | --- | --- 
director | string | 감독
cast | string | 출연진
genre | string | 장르
rating | string | 등급 </br> ALL (전체관람가), 12, 15, 19
runtime | integer | 상영시간 (min)
release_year | integer | 개봉한 년도
poster | string | 포스터이미지
> 현재는 비디오상품의 상세정보만 가정해, 위와 같은 형태

- **category**

 이름  | 타입 | 설명
 --- | --- | --- 
 category_id | integer | 상품이 위치한 카테고리 id정보
 category_name | string | 상품이 위치한 카테고리명 ```[READ-ONLY]```
> [REAE-ONLY]는 상품 수정(**PUT** /ProductManager/v1/products)시, 수정 불가
>> **PUT** /ProductManager/v1/products/categories 로 수정 가능

- **policy**

 이름  | 타입 | 설명
 --- | --- | --- 
 policy_id | integer | 정책 id
 type | string | 정책 타입. </br> license (라이선스) &nbsp; fixedPrice (고정가격.정가) &nbsp; discountedPrice (할인가격) ```[READ-ONLY]```
 price | integer | 금액. ```[READ-ONLY]```
 policy_start_date | date | 정책의 시작일. </br> 단, type=license일 때만, 해당 정보가 라이선스시작일. ```[READ-ONLY]```
 policy_end_date | date | 정책의 만료일. </br> 단, type=license일 때만, 해당 정보가 라이선스만료일. ```[READ-ONLY]```
 
 > product의 regular_price는 정규가격. &nbsp; 실제가격은 polices에 의해 변동 가능.</br>
>> 1. 할인가격이 없는 경우, 실제가격은 </br> 
 1) 고정가격 없는 경우, 실제가격 = products의 regular_price </br>
 2) 고정가격 있는 경우, 실제가격 = polices의 price (type=fixedPrice) </br></br>
>> 2. 할인가격이 있는 경우, 실제가격은 </br> 
 1) 고정가격 없는 경우, 실제가격 = products의 regular_price - price </br> 
 2) 고정가격 있는 경우, </br> 실제가격 = (type=fixedPrice의 price) - (type=discountedPrice의 price)

- **related_product**

 이름  | 타입 | 설명
 --- | --- | --- 
 product_id | string | 관련된 상품 id
 product_name | string | 관련된 상품명 ```[READ-ONLY]```
 category_id | integer | 관련된 카테고리 id
 category_name | string | 관련된 카테고리명 ```[READ-ONLY]```
> 해당 상품과 관련된 상품들의 정보 </br>
>> '상품id'  혹은  '카테고리id' 로 관련 상품들의 정보 확인 가능

--- 
## 상품 카테고리  schema
- **categories**
 
이름  | 타입 | 설명
 --- | --- | --- 
id | integer | 카테고리 id
name | string | 카테고리 이름
parent_id | integer | 부모카테고리 id
image | array | 카테고리 이미지


---
## 상품 정책  schema
- **policies**
 
이름  | 타입 | 설명
 --- | --- | --- 
id | integer | 정책 id
name | string | 정책 이름.
type | string | 정책 타입. </br> license (라이선스) &nbsp; fixedPrice (고정가격.정가) &nbsp; discountedPrice (할인가격)
price | integer | 금액.
start_date | date | 정책의 시작일. </br> 단, type=license일 때만, 해당 정보가 라이선스시작일. 
end_date | date | 정책의 만료일. </br> 단, type=license일 때만, 해당 정보가 라이선스만료일.

---
## API
구분 | API | 설명
--- | --- | ---
상품 CRUD | **POST** /ProductManager/v1/products </br> **GET** /ProductManager/v1/products </br> **PUT** /ProductManager/v1/products </br> **DELETE** /ProductManager/v1/products | 상품 생성</br>상품 조회</br>상품 수정</br>상품 삭제
상품 카테고리 CRUD | **POST** /ProductManager/v1/products/categories </br> **GET** /ProductManager/v1/products/categories </br> **PUT** /ProductManager/v1/products/categories </br> **DELETE** /ProductManager/v1/products/categories | 상품카테고리 생성</br>상품카테고리 조회</br>상품카테고리 수정</br>상품카테고리 삭제
상품 정책 CRUD | **POST** /ProductManager/v1/products/policies </br> **GET** /ProductManager/v1/products/policies </br> **PUT** /ProductManager/v1/products/policies </br> **DELETE** /ProductManager/v1/products/policies | 상품정책 생성</br>상품정책 조회</br>상품정책 수정</br>상품정책 삭제
### 상품 생성
- **POST** /ProductManager/v1/products </br></br>
- request
```json
{
	"products":[
		{
			"id":"RVD100000000",
			"name":"밀정",
			"type":"VOD",
			"detailed_type":"RVOD",
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
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/RVD100000000.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2018-12-31T11:59:59"
			  },
			  {
			  	"type":"discountedPrice",
			    "price":1000, 
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-15T00:00:00"
			  }
			],
			"creation_date":"2016-09-13T12:30:00",
		}
	]
}
```
---
### 상품 조회
#### 전체 상품 조회
- **GET** /ProductManager/v1/products </br></br>
- response
```json
{
	"products":[
		{
			"id":"RVD100023450",
			"name":"매그니피센트7",
			"type":"VOD",
			"detailed_type":"RVOD",
			"regular_price":12000,
			"description":"정의를 원하죠. 하지만 복수를 택하겠어요",
			"details":{
				"director":"안톤 후쿠아",
				"cast":"덴젤워싱턴(샘 치좀), 크리스프랫(조슈아 패러데이), 이병헌(빌리 락스)...",
				"genre":"action",
				"rating":"15",
				"runtime":133,
				"release_year":2016,
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/RVD10002345.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-20T00:00:00",
			    "policy_end_date":"2018-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-16T02:00:00",
		},
		{
			"id":"SVD222222222",
			"name":"MBC 월정액",
			"type":"VOD",
			"detailed_type":"SVOD",
			"regular_price":5000,
			"description":"MBC 모든 유료 다시보기 무제한",
			"categories":[
			  {"category_id":20, "category_name":"월정액"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"0000-00-00T00:00:00",
			    "policy_end_date":"9999-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-20T10:00:00",
			"related_products":[
			  {"category_id":"25", "category_name":"MBC"},
			]
		}
	]
}
```
#### 선택 상품 조회 (id)
- **GET** /ProductManager/v1/products/{id}
- Ex. /ProductManager/v1/products/SVD222222222 </br></br>
- response
```json
{
	"products":[
		{
			"id":"SVD222222222",
			"name":"MBC 월정액",
			"type":"VOD",
			"detailed_type":"SVOD",
			"regular_price":5000,
			"description":"MBC 모든 유료 다시보기 무제한",
			"categories":[
			  {"category_id":20, "category_name":"월정액"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"0000-00-00T00:00:00",
			    "policy_end_date":"9999-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-20T10:00:00",
			"related_products":[
			  {"category_id":"25", "category_name":"MBC"},
			]
		}
	]
}
```
#### 선택 상품 조회 (type)
- **GET** /ProductManager/v1/products?type=:type&detailed_type=:detailed_type
- Ex. /ProductManager/v1/products?type='VOD'&detailed_type='RVOD' </br></br>
- response
```json
{
	"products":[
		{
			"id":"RVD100023450",
			"name":"매그니피센트7",
			"type":"VOD",
			"detailed_type":"RVOD",
			"regular_price":12000,
			"description":"정의를 원하죠. 하지만 복수를 택하겠어요",
			"details":{
				"director":"안톤 후쿠아",
				"cast":"덴젤워싱턴(샘 치좀), 크리스프랫(조슈아 패러데이), 이병헌(빌리 락스)...",
				"genre":"action",
				"rating":"15",
				"runtime":133,
				"release_year":2016,
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/RVD10002345.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-20T00:00:00",
			    "policy_end_date":"2018-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-16T02:00:00",
		},
		{
			"id":"RVD100000000",
			"name":"밀정",
			"type":"VOD",
			"detailed_type":"RVOD",
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
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/RVD100000000.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2018-12-31T11:59:59"
			  },
			  {
			  	"type":"discountedPrice",
			    "price":1000, 
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-15T00:00:00"
			  }
			],
			"creation_date":"2016-09-13T12:30:00",
		}
	]
}
```
---
### 상품 수정
#### 선택 상품 수정 (id)
- **PUT** /ProductManager/v1/products/{id}
- Ex. /ProductManager/v1/products/AAA100000000 </br></br>
- request
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
---
### 상품 삭제
#### 전체 상품 삭제
- **DELETE** /ProductManager/v1/products

#### 선택 상품 삭제 (id)
- **DELETE** /ProductManager/v1/products/{id}
- Ex. /ProductManager/v1/products/AAA100000000 </br></br>

---

### 상품 타입 별 상품
 상품 타입 | 
 --- | 
 RVOD | 
 SVOD |
 SVODPackage |
 bundle |
 FOD | 
 AD |
 AD-bundle |

##### RVOD
```json
{
	"products":[
		{
			"id":"RVD100000000",
			"name":"밀정",
			"type":"VOD",
			"detailed_type":"RVOD",
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
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/RVD100000000.png"
			},
			"categories":[
			  {"category_id":12, "category_name":"최신영화"},
			  {"category_id":5, "category_name":"액션"}
			],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2018-12-31T11:59:59"
			  },
			  {
			  	"type":"fixedPrice",
			    "price":12000, 
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-31T11:59:59"
			  },
			  {
			  	"type":"discountedPrice",
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
##### SVOD
```json
{
	"products":[
		{
			"id":"SVD222222222",
			"name":"MBC 월정액",
			"type":"VOD",
			"detailed_type":"SVOD",
			"regular_price":5000,
			"description":"MBC 모든 유료 다시보기 무제한",
			"categories":[
			  {"category_id":20, "category_name":"월정액"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"0000-00-00T00:00:00",
			    "policy_end_date":"9999-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-20T10:00:00",
			"related_products":[
			  {"category_id":"25", "category_name":"MBC"},
			]
		}
	]
}
```

##### SVODPackage
```json
{
	"products":[
		{
			"id":"SVP111111111",
			"name":"지상파 월정액",
			"type":"VOD",
			"detailed_type":"SVODPackage",
			"regular_price":13000,
			"description":"MBC, KBS, SBS 지상파 3사의 모든 유료 다시보기 무제한",
			"categories":[
			  {"category_id":20, "category_name":"월정액"}
			 ],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"0000-00-00T00:00:00",
			    "policy_end_date":"9999-12-31T11:59:59"
			  },
			  {
			  	"type":"fixedPrice",
			    "price":14000, 
			    "policy_start_date":"2016-09-20T00:00:00",
			    "policy_end_date":"2016-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-21T10:00:00",
			"related_products":[
			  {"category_id":"25", "category_name":"MBC"},
			  {"category_id":"26", "category_name":"KBS"},
			  {"category_id":"27", "category_name":"SBS"}
			]
		}
	]
}
```
##### bundle
```json
{
	"products":[
		{
			"id":"BDL100000232",
			"name":"[추석특집] 최신 액션 모아보기",
			"type":"VOD",
			"detailed_type":"bundle",
			"regular_price":25000,
			"description":"길고 긴 추석 연휴, 최신 액션과 함께!",
			"categories":[
			  {"category_id":222, "category_name":"[추석 특집관]"},
			],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-31T11:59:59"
			  },
			  {
			  	"type":"fixedPrice",
			    "price":27500, 
			    "policy_start_date":"2016-09-10T00:00:00",
			    "policy_end_date":"2016-09-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-20T14:30:05",
			"related_products":[
			  {"product_id":"RVD100000000", "product_name":"밀정"},
			  {"product_id":"RVD100023450", "product_name":"매그니피센트7"},
			  {"product_id":"RVD710900223", "product_name":"메카닉: 리크루트"},
			  {"product_id":"RVD100000002", "product_name":"수어사이드 스쿼드"},
			]
		}
	]
}
```
##### FOD
```json
{
	"products":[
		{
			"id":"FOD100000097",
			"name":"[예고편] 미스 페레그린과 이상한 아이들의 집",
			"type":"VOD",
			"detailed_type":"FOD",
			"regular_price":0,
			"description":"올 가을, 세상에 없던 유일한 미스터리 판타지!",
			"details":{
				"director":"팀버튼",
				"cast":"에바그린(페레그린), 사무엘L.잭슨, 에이사버터필드(제이크)...",
				"genre":"fantasy",
				"rating":"12",
				"runtime":2,
				"release_year":2016,
				"poster":"http://ip address:port num/ProductManager/v1/products/resources/posterImage/2016/FOD100000097.png"
			},
			"categories":[
			  {"category_id":107, "category_name":"최신영화 예고편"}
			],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-22T14:00:00",
			    "policy_end_date":"2018-12-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-22T14:00:00",
		}
	]
}
```
##### AD
```json
{
	"products":[
		{
			"id":"AD1000000000",
			"name":"광고",
			"type":"VOD",
			"detailed_type":"AD",
			"regular_price":30000000,
			"description":"최신 영화 10개 송출 전, 10% 확률로 해당 광고가 송출",
			"details":{
				"runtime":2,
				"release_year":2016
			},
			"categories":[
			  {"category_id":100, "category_name":"광고"}
			],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-09-01T00:00:00",
			    "policy_end_date":"2016-09-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-13T12:30:00"
		}
	]
}
```
##### AD-bundle
```json
{
	"products":[
		{
			"id":"ADB100000000",
			"name":"광고 묶음",
			"type":"VOD",
			"detailed_type":"AD-bundle",
			"regular_price":50000000,
			"description":"최신 영화 10개 송출 전, 10% 확률로 해당 광고가 연속해서 송출",
			"details":{
				"runtime":5,
				"release_year":2016
			},
			"categories":[
			  {"category_id":100, "category_name":"광고"}
			],
			"policies":[
			  {
			    "type":"license",
			    "policy_start_date":"2016-10-03T00:00:00",
			    "policy_end_date":"2016-10-31T11:59:59"
			  }
			],
			"creation_date":"2016-09-13T12:30:00",
			"related_products":[
			  {"product_id":"AD1000000000", "product_name":"광고"},
			  {"product_id":"AD1000000001", "product_name":"광고2"},
			]
		}
	]
}
```
---
### 상품 카테고리 생성
 - **POST** /ProductManager/v1/products/categories </br></br>

---
### 상품 정책 생성
 - **POST** /ProductManager/v1/products/policies </br></br>

 - request
```json
{
	"policies":[
		{
			"id":"LCS100000000",
			"name":"[상품 라이선스] 밀정",
			"type":"license",
			"start_date":"2016-09-26T18:00:00",
			"end_date":"2021-09-26T18:00:00"
		}
	]
}
```
---
### 상품 정책 조회
#### 전체 상품 정책 조회
 - **GET** /ProductManager/v1/products/policies </br></br>

 - response
```json
{
	"polices":[
		{
			"id":"LCS100000001",
			"name":"[상품 라이선스] 매그니피센트7",
			"type":"license",
			"start_date":"2016-09-01T18:00:00",
			"end_date":"2021-09-01T18:00:00"
		},
		{
			"id":"FXP22222222",
			"name":"[10월1째주 할인영화-고정가격] 3000",
			"type":"fixedPrice",
			"price":3000,
			"start_date":"2016-10-01T00:00:00",
			"end_date":"2016-10-08T23:59:59"
		},
		{
			"id":"DCP33333333",
			"name":"[추석특집-가격할인가] 5000",
			"type":"discountedPrice",
			"price":5000,
			"start_date":"2016-09-10T00:00:00",
			"end_date":"2016-09-18T23:59:59"
		}
	]
}
```
#### 선택 상품 정책 조회 (id)
 - **GET** /ProductManager/v1/products/policies/{id} </br>
 - **GET** /ProductManager/v1/products/policies/LCS100000000 </br></br>

 - response
```json
{
	"polices":[
		{
			"id":"",
			"name":"",
			"type":"",
			"price":"",
			"start_date":"",
			"end_date":""
		}
	]
}
```
#### 선택 상품 정책 조회 (type)
 - **GET** /ProductManager/v1/products/policies?type=:type </br>
 - **GET** /ProductManager/v1/products/policies?type='license' </br></br>

 - response
```json
{
	"polices":[
		{
			"id":"LCS100000000",
			"name":"[상품 라이선스] 밀정",
			"type":"license",
			"start_date":"2016-09-26T18:00:00",
			"end_date":"2021-09-26T18:00:00"
		},
		{
			"id":"LCS100000001",
			"name":"[상품 라이선스] 매그니피센트7",
			"type":"license",
			"start_date":"2016-09-01T18:00:00",
			"end_date":"2021-09-01T18:00:00"
		},
		{
			"id":"LCS100000002",
			"name":"[상품 라이선스] 수어사이드 스쿼드",
			"type":"license",
			"start_date":"2016-08-20T00:00:00",
			"end_date":"2020-08-20T23:59:59"
		}
	]
}
```
---
### 상품 정책 수정
#### 선택 상품 정책 수정 (id)
 - **PUT** /ProductManager/v1/products/policies/{id} </br>
 - **PUT** /ProductManager/v1/products/policies/LCS100000000 </br></br>

 - request

---
### 상품 정책 삭제
#### 전체 상품 정책 삭제
 - **DELETE** /ProductManager/v1/products/policies
 
#### 선택 상품 정책 삭제 (id)
 - **DELETE** /ProductManager/v1/products/policies/{id} </br>
 - **DELETE** /ProductManager/v1/products/policies/LCS100000000 </br></br>

---
### HTTP status code
status code | 설명
--- | ---
200 | OK - 성공
400 | Bad Request - 잘못된 요청
401 | Unauthorized - 인증실패 </br> (API 없음 or 로그인하지않은 상태에서, 상품정보 수정요청 상황 등)
404 | Not Found - 해당 리소스가 존재하지 않음
500 | Internal error - 서버 에러

## REFERENCE
 - **REST API**
 	- [REST API란] (http://meetup.toast.com/posts/92)
 - **Elasticsearch**
 	- [Elasticsearch 개념 및 예제] (http://opennote46.tistory.com/143)
 - **기타**
  - [구글 Postman - API테스트를 위한 툴] (http://ourcstory.tistory.com/6)
