# API

#### `POST` /nrm/available-resource
- 특정 지역의 네트워크 리소스 할당이 가능한 최대 대역폭 요청
- Request:
```json
{
  "resourceGroupId": "advertisement",
  "locationList": [
    { "locationId": "jeju" },
    { "locationId": "newyork" }
  ]
}
```
- Response
  - 400: Request 포맷이 잘못된 경우, 설정에 없는 locationId/resourceGroupId 사용한 경우
  - 201: OK
```json
{
  "resourceGroupId": "advertisement",
  "locationList": [
    { "locationId": "jeju", 
      "inAvailableBps": 5000000, 
      "outAvailableBps": 7000000 },
    { "locationId": "newyork", 
      "inAvailableBps": 3000000, 
      "outAvailableBps": 12000000 }
  ]
}
```
