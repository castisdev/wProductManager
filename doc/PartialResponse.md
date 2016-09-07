# Partial Response

 * product pofile(level 에 따라서 응답 리스트가 달라짐) 을 제공하지 않음
 * 필요한 필드 값만 제공하도록 함.
 * Google 스타일로 사용

 API를 요청하는 Client의 용도에 따라 선별적으로 몇가지 필드만이 필요한 경우가 있다. 필드를 제한하는 것은 전체 응답의 양을 줄여서 네트워크 대역폭(특히 모바일에서) 절약할 수 있고, 응답 메세지를 간소화하여 파싱등을 간략화할 수 있다.
그래서 몇몇 잘 디자인된, REST API의 경우 이러한 Partial Response 기능을 제공하는데, 주요 서비스들을 비교해보면 다음과 같다.
Linked in : /people:(id,first-name,last-name,industry)
Facebook : /terry/friends?fields=id,name
Google : ?fields=title,media:group(media:thumnail)
Linked in 스타일의 경우 가독성은 높지만 :()로 구별하기 때문에, HTTP 프레임웍으로 파싱하기가 어렵다. 전체를 하나의 URL로 인식하고, :( 부분을 별도의 Parameter로 구별하지 않기 때문이다.
Facebook과 Google은 비슷한 접근 방법을 사용하는데, 특히 Google의 스타일은 더 재미있는데, group(media:thumnail) 와 같이 JSON의 Sub-Object 개념을 지원한다.
Partial Response는 Google 스타일을 이용하는 것을 권장한다.
