### 솔루션 시작 배경
CJ 에서 상품 고도화의 목적으로 프로젝트화가 될 가능성이 높아 진행하게 됨

### 요구사항
* 동일 콘텐츠의 노출 단일화 (멀티 상품 구조 체계화)
* UHD/HD 콘텐츠 묶음
* VOD 가격 탄력적 관리 (시간대별 탄력 상품)
* 결합 상품 구조 (유/무형 상품 결합 체계) 
* 멀티룸(패밀리) 상품 (멀티룸 VOD 권한 공유)
* VOD 전용 티어 상품 (VOD 전용 상품 판매)
* VOD 월정액/ 유료채널 시간제 상품
* 평생소장 상품 해지 기능
* 단일 광고 상품 ( single )	
	* stb vod 광고 상품
	* 채널 광고 상품
	* 모바일 vod 광고 상품
	* vod 클라이언트 ui 광고 상품
  
* 통합 상품 : 단일 광고 상품의 묶음 상품 ( bundle )	
	* stb vod 광고 상품 + 모바일 vod 광고 상품
	* stb vod 광고 상품 + 모바일 vod 광고 상품 + vod 클라이언트 ui 광고 상품
	* stb vod 광고 상품 + 모바일 vod 광고 상품 + 채널 광고 상품

### 설계 MD 추정
 * 10월 28일부터 시작, 
 * 추정MD : 3 MD (모델링만, API 작성 MD는 추후 추정예정)

### 설계
#### 모델링
##### Item Model
![Item Model] (https://github.com/bobmann98/commonProduct/blob/master/Item_model.png?raw=true)

##### PricingPlan Model
![PricingPlan Model] (https://github.com/bobmann98/commonProduct/blob/master/PricingPlan_model.png?raw=true)

#### APIs
 - Parameters
 - Request
 - Response
 
### 설계 검토

### 구현 MD 추정
