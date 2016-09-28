# API 명세

## 목적
- 

## 상품매니저 웹버전 예상 기능
- 상품 정보 입력
- 상품 정보 수정
- 상품 정보 삭제
- 상품 목록 조회
- 상품 정보 조회?
- 가격 정책 정보 입력
- 가격 정책 정보 수정
- 가격 정책 정보 삭제
- 가격 정책 목록 조회
- 가격 정책 정보 조회?
- 상품과 가격 정책 맵핑

## 일반 상품(Common Product)

### Model

#### Product
- 상품의 일반 정보

<table>
  <tr><td>이름</td><td>타입</td><td>설명</td></tr>
  <tr><td>id</td><td>int</td><td>상품의 id</td></tr>
  <tr><td>name</td><td>string</td><td>상품의 이름</td></tr>
  <tr><td></td><td>int</td><td>상품의 id</td></tr>
  <tr><td>type</td><td>string</td><td>상품의 유형</td></tr>
  <tr><td>category</td><td>string</td><td>상품의 범주. 카테고리는 타입의 상위 개념. 흔히 이야기하는 대분류, 소분류. 일괄적용같은 기능이 있다면 기준이 될 수 있는 항목(물론 타입도 되겠지만)<br>- 카테고리 위의 카테고리도 생각할 수 있지 않을까?<br>- 꼭 필요한 항목일까?</td></tr>
  <tr><td>price</td><td>int</td><td>상품의 가격. 기본가격</td></tr>
  <tr><td>image</td><td>string?</td><td>상품의 이미지<br>- 이미지 경로 정보일까?<br>- 사이즈 별로 정보가 필요할까?</td></tr>
  <tr><td>externalId</td><td>string</td><td>상품의 외부 연동용 id</tr>
</table>

#### Pricing Policy
- 가격 정책 정보. 직접 가격을 정하거나 할인률을 설정하기 위한 정보. 상품과는 별개 정보이고 관계는 n:m. SO 같은 개념이 들어간다면 맵핑 모델에서 처리

<table>
  <tr><td>이름</td><td>타입</td><td>설명</td></tr>
  <tr><td>name</td><td>string</td><td>정책의 이름</td></tr>
  <tr><td>type</td><td>string</td><td>정책의 유형. 가격을 직접 변경하거나 할인률만 적용하거나</td></tr>
  <tr><td>value</td><td>int</td><td>정책의 값. 유형에 따라 의미하는 바가 다름</td></tr>
  <tr><td>licenseStart</td><td>date</td><td>정책 라이선스 시작일</td></tr>
  <tr><td>licenseEnd</td><td>date</td><td>정책 라이선스 종료일</td></tr>
</table>

#### ProductItem
- 미확정.

### API

#### GetProductInfo
- 단일 상품의 정보 요청. 매니저에서 필요?

#### GetProductList
- 상품 목록의 정보 요청

#### AddProductInfo
- 상품 정보 입력

#### UpdateProductInfo
- 상품 정보 수정

#### DeleteProductInfo
- 상품 정보 삭제

#### GetPricePolicyInfo
- 단일 가격 정책의 정보 요청. 매니저에서 필요?

#### GetPricePolicytList
- 가격 정책 목록의 정보 요청

#### AddPricePolicyInfo
- 가격 정책 정보 입력

#### UpdatePricePolicyInfo
- 가격 정책 정보 수정

#### DeletePricePolicyInfo
- 가격 정책 정보 삭제

#### AddProductPricePolicyMappingInfo
- 상품 가격 정책 정보 맵핑 정보 입력

### 개발 명세


### 기타
