# 에러처리

에러처리의 기본은 HTTP Response Code를 사용한 후, Response body에 error detail을 서술한다.

대표적인 API 서비스들이 사용하는 HTTP Response Code

Google GData
200 201 304 400 401 403 404 409 410 500

Netflix
200 201 304 400 401 403 404 412 500

Digg
200 400 401 403 404 410 500 503

 | 코드 | 설명 | 비고 |
 | :---: | --- | --- |
 | 200 |  성공 |  |
 | 400 |  Bad Request |  field validation 실패시 |
 | 401 |  Unauthorized |  API 인증,인가 실패 |
 | 404 |  Not found ? |  해당 리소스가 없음 |
 | 500 |  Internal Server Error |  서버 에러 |

추가적인 HTTP response code에 대한 사용이 필요하면 http response code 정의 http://en.wikipedia.org/wiki/Http_error_codes 문서를 참고

Twillo의 Error Message 형식의 경우
 - HTTP Status Code : 401
 - {“status”:”401”,”message”:”Authenticate”,”code”:200003,”more info”:”http://www.twillo.com/docs/errors/20003"}
