# 상품(Product)

### Product
| 이름 | 타입 | 설명 |
| --- | --- | --- | --- |
| id	 | String | 	상품 ID |
| name	 | String	 | 상품명	 |
| type	 | String	 | 상품 타입 	 |
| price	 | ProductPrice	 | 해당 상품 정책에 의한 가격 |
| properties | ProductProperties	 | 상품 속성 |
| policies | ProductPolicy	 | 상품 정책 |

### ProductProperties
| 이름 | 타입 | 설명 |
| --- | --- | --- | --- |
| width	 | String	 | product width |
| length	 | String	 | product length |
| height	 | String	 | product height |
| weight	 | String	 | product weight
| visibility	 | String	 | product visibility |
| externalId	 | String	 | 협의된 연동용 상품 ID |
| images	 | productImage	 | 상품 포스터 이미지 파일명	 |
| description	 | String	 | 상품 설명 |

###ProductPolicy
| 이름 | 타입 | 설명 |
| --- | --- | --- |
| id	 | String	 | productPolicy 내부 ID  |
| type	 | String	 | 상품 정책의 타입 </br>static : 고정 기간 고정 가격 정책 |
| licenseStart	 | String	 | 상품 정책 유효기간 시작일</br> “YYYY-MM-DD HH:MM:SS” 형태 |
| licenseEnd	 | String	 | 상품 정책 유효기간 종료일</br> “YYYY-MM-DD HH:MM:SS” 형태 |
| viewingLength	 | String	 | 구매가 유효한 기간. </br>DDD:HH:mm 형태 혹은 DD:HH:mm 형태 	 |
| viewablePeriodState	 | Int	 | 무제한시청(평생소장) 여부</br>0 : 기본값</br>1 : 무제한시청(평생소장). viewingLength값이 무시된다.  |

###ProductPrice
| 이름 | 타입 | 설명 |
| --- | --- | --- |
| price	 | String	 | Product price  | 
| regular_price	 | String	 | Product regular price  | 
| sale_price	 | String	 | Product sale price  | 
| tax_status	 | String	 | tax status  | 
| tax_class	 | String	 | tax class  | 

###productImage
| 이름 | 타입 | 설명 |
| --- | --- | --- |
