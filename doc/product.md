# 상품(Product)

### Product
| 이름 | 타입 | 설명 |
| --- | --- | --- | --- |
| id	 | String | 	상품 ID |
| name	 | String	 | 상품명	 | 
| type	 | String	 | 가입형 상품</br>패키지형 상품 	 |
| smallImageFile	 | String	 | 상품 포스터 이미지 파일명	(작은 사이즈) |
| imageFile	 | String	 | 상품 포스터 이미지 파일명	 |
| externalId	 | String	 | 협의된 연동용 상품 ID	 |
| viewingLength	 | String	 | 구매가 유효한 기간. </br>DDD:HH:mm 형태 혹은 DD:HH:mm 형태 	 | 
| viewablePeriodState	 | Int	 | 무제한시청(평생소장) 여부</br>0 : 기본값</br>1 : 무제한시청(평생소장). viewingLength값이 무시된다.  |
| policyList		 | productPolicy | productPolicy의 리스트 |
| description	 | String	 | 상품 설명 |

###ProductPolicy
| 이름 | 타입 | 설명 |
| --- | --- | --- |
| id	 | String	 | productPolicy 내부 ID  | 
| type	 | String	 | 상품 정책의 타입 </br>static : 고정 기간 고정 가격 정책 | 
| price	 | Int	 | 해당 상품 정책에 의한 가격 | 
| licenseStart	 | String	 | 상품 정책 유효기간 시작일</br> “YYYY-MM-DD HH:MM:SS” 형태 | 
| licenseEnd	 | String	 | 상품 정책 유효기간 종료일</br> “YYYY-MM-DD HH:MM:SS” 형태 | 
