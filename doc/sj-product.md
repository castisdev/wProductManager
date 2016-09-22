
# Product Manager
## 상품 설계 마인드맵
![preview](https://raw.githubusercontent.com/ssuji/github-test/master/resources/img/product-mindmap.png)

---

## 상품 schema
- **Product** 
 
 이름  | 타입 | 설명
 --- | --- | --- 
 id | string | 상품 id
 name | string | 상품 이름
 type | string | 상품 타입 </br> FOD (무료VOD) </br> RVOD (VOD) &nbsp;  bundle (묶음상품) </br> SVOD (월정액) &nbsp; SVODPackage (월정액묶음) </br> AD (광고상품) &nbsp; AD-bundle (광고상품묶음)
 reqular_price | integer | 상품 정규가격 </br> (실제가격은 polices에 의해 변동 가능)
 description | string | 상품 개요
 details | **detail** | 상품 상세정보
 categories | **category** | 상품 카테고리
 policies | **policy** | 상품 정책
 creation_date | date | 상품 생성일
 related_products | **related_product** | 관련 상품 정보
 
- **detail** 

 이름  | 타입 | 설명
 --- | --- | --- 
director | string | 감독
cast | string | 출연진
genre | string | 장르
rating | string | 등급 </br> ALL(전체관람가), 12, 15, 19
runtime | integer | 상영시간(min)
release_year | integer | 개봉한 년도
poster | string | 포스터이미지
> 현재는 비디오상품의 상세정보만 가정해, 위와 같은 형태

- **category**

 이름  | 타입 | 설명
 --- | --- | --- 
 category_id | integer | 상품이 위치한 카테고리 id정보
 category_name | string | 상품이 위치한 카테고리명
 
- **policy**
> 아래 **'상품정책'**에 설명

- **related_product**

 이름  | 타입 | 설명
 --- | --- | --- 
 product_id | string | 관련된 상품 id
 category_id | integer | 관련된 카테고리 id
 category_name | string | 관련된 카테고리명
> 해당 상품과 관련된 상품들의 정보 </br>
>> '상품id'  혹은  '카테고리id' 로 관련 상품들의 정보 확인 가능

--- 
### 상품 정책
#### policy (상품 정책 properties)
 이름  | 타입 | 설명
 --- | --- | --- 
 type | string | 정책 타입. </br> license 라이선스, fixedPrice 고정가격(정가), discountedPrice 할인가격
 price | integer | 금액.
 policy_start_date | date | 정책의 시작일. </br> 단, type=license일 때만, 해당 정보가 라이선스시작일.
 policy_end_date | date | 정책의 만료일. </br> 단, type=license일 때만, 해당 정보가 라이선스만료일.
 
 > product의 regular_price는 정규가격. &nbsp; 실제가격은 polices에 의해 변동 가능.</br>
 1. 할인가격이 없는 경우, 실제가격은 </br> 
 1) 고정가격 없는 경우, 실제가격 = products의 regular_price </br>
 2) 고정가격 있는 경우, 실제가격 = polices의 price (type=fixedPrice) </br></br>
 2. 할인가격이 있는 경우, 실제가격은 </br> 
 1) 고정가격 없는 경우, 실제가격 = products의 regular_price - price </br> 
 2) 고정가격 있는 경우, </br> 실제가격 = (type=fixedPrice의 price) - (type=discountedPrice의 price)
 
---
## API
### 상품 생성
- **POST** /ProductManager/v1/products </br></br>
- request
```json
{
	"products":[
		{
			"id":"RVD100000000",
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
			"type":"RVOD",
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
			"type":"SVOD",
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
			"type":"SVOD",
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
- **GET** /ProductManager/v1/products?type=:type
- Ex. /ProductManager/v1/products?type='RVOD' </br></br>
- response
```json
{
	"products":[
		{
			"id":"RVD100023450",
			"name":"매그니피센트7",
			"type":"RVOD",
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

### 상품 타입
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
			"type":"SVOD",
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
			"type":"SVODPackage",
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
			"type":"bundle",
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
			  {"product_id":"RVD100000000"},
			  {"product_id":"RVD100023450"},
			  {"product_id":"RVD710900223"},
			  {"product_id":"RVD100000002"},
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
			"type":"FOD",
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
			"type":"AD",
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
			"type":"AD-bundle",
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
			  {"product_id":"AD1000000000"},
			  {"product_id":"AD1000000001"},
			]
		}
	]
}
```
---

## REFERENCE
 - **REST API**
 	- [REST API란] (http://meetup.toast.com/posts/92)
 - **Elasticsearch**
 	- [Elasticsearch 개념 및 예제] (http://opennote46.tistory.com/143)
 - **기타**
  - [구글 Postman - API테스트를 위한 툴] (http://ourcstory.tistory.com/6)
