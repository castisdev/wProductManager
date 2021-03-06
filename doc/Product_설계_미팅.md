~~~
10.20 - (진광현, 천광규, 박준석, 이영주, 이재근, 김민규) - 6층 생각방 
*	상품이란?
 * 상품(Product)는 Item에 pricingPolicy(pricingPlan?) 등의 가격정책이 부여된 것.
 * 가격은 변경될 수 있음
*	Item도 변경될 수 있을까?
 * 예를 들어 상품 하나 만들어놓고 아이템만 바꿔가며 판매가 가능할까?
* 동일 상품, 중복 상품 제한
 * 동일상품의 기준이 무엇인가? 중복구매 시 중복의 기준은 무엇인가?
 * 특정 Item에 가격이 같으면 동일 상품인가?
 * 그냥 Item이 같으면 동일 상품인가?
* 중복구매
 * VOD서비스에서 일반적으로 동일 Asset에 대하여 대여기간이 겹치게 두 번 이상 구매한 상태
 *	상품아이디는 다를 수 있고 Item아이디는 동일
 *	하지만 오픈마켓에서 실물 구입시에는 동일 상품을 여러 번 구매 가능
 *	상품아이디도 동일.
*	상품 모델링에서 동일 상품의 정의는 상품의 유일한 키가 동일한 것을 지칭하는 것으로 하자
 *	아이템, 가격이 동일하더라도 상품아이디가 다르면 다른 상품
 *	다만 아이템과 가격이 동일한 상품을 여러 개 만들 수 있는가? 제약사항으로 구현 시 적용하면 어떨까?
 *	동일 아이템을 다른 상품으로 구매할 수 있는 가의 문제는 구매처리시의 시나리오 이슈라고 생각 됨.
*	ProductItem과 관련된 의견
 *	배송방식에 따른 분류
 *	배송, 스트리밍도 아닌 즉시 수령 개념(혹은 방문수령)도 존재함(슈퍼에 가서 돈 내고 바로 구매한 물품을 들고 나옴)
*	판매방식
 *	단일 상품으로만 판매 가능한 아이템
 *	복합 상품으로도 판매 가능한 아이템
*	할인적용유뮤
 *	할인 적용 가능한 아이템, 혹은 쿠폰 적용 가능한 아이템
*	유형/무형
 *	VIP 고객 전용 상품 or 아이템? 일정의 타겟팅 상품
*	알라까르떼 상품 생성 특정 분류에 속하는 아이템을 자동 업데이트 해주면 좋을 것 같다
*	해시태그를 이용하면 어떨까?
*	순수한 아이템 속성 정보를 ProductItem까지 가져오지 않았으면 좋겠음.

~~~
~~~
10.21 (진광현, 박준석, 이영주, 이재근, 김민규) - 6층 생각방 

구매자와 사용자 분리
 * 상품의 모델쪽에 넣어야 하는 요소들인지 판단 필요.
 * 구매 시점에서 분리가 되어야 하는 것은 아닌지..
 * "사용 권한 공유하기" 이야기중에 대한 내용
  * 상품 속성에 권한을 주자.
  * 아니면 권한 정보를 가지고 있는 모델을 하나 만들자.
  
가격정책
 * 가격정책의 조건의 범위는 어디까지 인가?
  * 어떤 상품을 막론하고 시간, 지역은 공통적으로 있어야 하는 조건인 것으로 보임
 * 상품의 가격을 결정하는 곳은 가격정책인가, 상품정책인가, 판매정책인가? (아직 해당 정책이 모두 생겨날지는 미지수지만..)
 * 옥션에서 물건을 구매할 때 옵션(색상, 사이즈)을 선택하거나 연관 추가 상품을 구매할 수가 있는데 우리 상품 모델에는 어떻게 적용가능한가.
 * Item 속성으로 PricingPolicy를 포함한다면,
   * 타이틀이 같지만 화질이 다른 상품을 구성할 수 있지 않을까?
   * a la carte 상품도 쉽게 구성 가능해 보임.
~~~
~~~
10.24 (박준석, 이영주, 이재근) - 6층 생각방
* 멀티상품
 -> 멀티상품의 개념은 무엇인가.?
  -> 한 아이템이 여러 상품에 속해 있는 경우 를 멀티 상품이라고 본다.
  -> 상품의 다양화는 상품을 여러개 만들어두고, 다양화된 여러 상품에 아이템이 적용되는 개념이 아닌가 함.
* 멀티 디바이스
 -> 각 디바이스에 대하여 productType을 추가하는 것은 어떨까. 
 -> 한 상품에 여러가지 재생할 수 컨텐츠를 포함시키자.
 -> 컨텐츠 재생 횟수에 따른 제한 상품도 만들수 있지 않을까하는 의견이 나옴. (한 컨텐츠에 대하여 디바이스에 상관없이 3회만 볼수 있다던가..) 
 -> 상품에 그룹 타겟팅 적용이 필요해 보임 - 타겟팅의 개념안에는 어떤 기기에 할 것인지, 유저그룹에 있을수도 있다.
* a la carte 상품
 -> item을 선택할 수 있는 상품을 만들어서 사용자가 item을 고르면 갯수 만큼 가격이 책정이 되어 구매 가능할 수 있을 것 같다.
 -> n개의 상품 m가격으로 정의될 것으로 추측이 되어, 가격 정책에 포함되면 되지 않을까 함.

* 한정판매
 -> 아이템과 상품 정보에 재고량을 나타내는 정보가 필요해 보임.
* 공동구매, 선착순 할인
 -> 상품의 종류라기 보다는 상품에 대한 이벤트라고 보여짐. 이벤트를 모델링해서 적용하면 되지 않을까 함.
* 되팔기
 -> 상품의 대여기간을 한정하고, 대여기간이 남아있는 상품을 다른 사용자에게 중고로 판매하는 시나리오가 있을 것 같다.
     하지만, 사이트 운영자들은 해당 서비스에 대하여 매력적이지 않을 것 같아서 실현 가능성이 없어보임.
* Bidding
 -> 상품을 생성할때 정해지기 정책이라기 보다는 판매시점에 또 다른 정책(판매정책?)을 추가해야 하는 것은 아닌가.
* 가족할인
 -> 타겟팅으로 지정하여 할인을 해주면 되는 것이 아닌가.

~~~

```
10.25 (박준석, 이영주, 이재근) - 6층 생각방
* 모델링 할 때는 상품에 대한 일반화를 생각하며 해보자. 어떤 상품이라도 적용 가능하게 위해..
* Item Model
 * 할인/쿠폰 적용 가능한 상품, 단일/복합 상품에 쓰이는 아이템인지는 추후에 모델에 반영해도 되지 않을까함. 
 * Item Type에 따라 각 각의 메타정보가 있는 모델을 별도로 존재해야 할 것으로 보임. (Asset, Channel, Advertisement)

* PricingPlan Model
 * 가격정책과 판매정책을 분리해야 생각해보는 것은 어떨까?
  * 가격정책과 판매정책의 정의를 분명히 할 필요성이 있다. (가격은 결정 짓는 요소 중 시간/지역은 판매를 결정 짓는 요소일 가능성이 있다)
 * 가격정책 대신 판매정책으로 바꾸는 것은 어떨까?
```
### Product Model
![Product Model] (https://raw.githubusercontent.com/bobmann98/commonProduct/master/Product_basic.png)

### Item Model
![Item Model] (https://github.com/bobmann98/commonProduct/blob/master/Item_model.png?raw=true)

### PricingPlan Model
![PricingPlan Model] (https://github.com/bobmann98/commonProduct/blob/master/PricingPlan_model.png?raw=true)

```
2016.11.07(박준석, 이영주, 이재근) - 6층 생각방
 - 동일 컨텐츠의 노출 단일화
   - 상품 기능보다는 전시기능에 가까워 보임
   - 클라이언트 UI에서 아이템 기준으로 연결된 상품 목록을 보여주면 되지 않을까 함.(RVOD를 선택하면 Bundle, SVOD 상품을 보여줌)
 - UHD/HD 컨텐츠 묶음
   - 이것 역시 전시 기능에 가까워 보임
   - 새롭게 모델링한 상품이 기존 전시기능(CG)에 적용 가능해야 할 것으로 보임 
 - VOD 가격 탄력적 관리
   - 한 상품에 여러 개의 PricingPlan을 가질 수 있는 구조로 모델링을 했기 때문에 반영할 수 있을 것으로 보임
 - 결합상품 구조 (유/무형 상품 결합 체계)
   - 한 상품에 여러 개의 아이템을 가질 수 있는 구조인데, 유형/무형에 상관없이 반영가능 함.
 - 멀티룸(패밀리) 상품
   - 초기 논의 시에는 User에 종속 되어야 하나, Device에 종속 되어야 하나는 등의 고민을 하며, UserGroup과 DeviceGroup 중 하나 만 존재하는 게 맞지 않을 까 했었음.
   - 추후 UserGroup과 DeviceGroup 을 생성하여 서로 N:N 구조로 모델링 하면 확장성까지 고려되지 않을 까 함.
   - 상품 정보에는 멀티 User/멀티 Device 적용 가능한 지에 대한 flag만 존재하도록 하고, 구매 시 판단하여 상품의 가격을 달리 보여주도록 하는 시나리오를 구상함.
 - 명일 논의할 내용
   - UserGroup/DerviceGroup 모델링
   - VOD 전용 상품
   - VOD 월정액/유료 채널 시간제 상품
```
