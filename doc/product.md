# 상품(Product)
```json
{
  "id": "162",
  "name": "Premium Quality",
  "permalink": "https://example.com/product/premium-quality-3/",
  "date_created": "2016-05-31T23:40:07",
  "date_modified": "2016-05-31T23:40:07",
  "type": "simple", //simple, grouped, external, variable
  "status": "publish", //draft, pending, private and publish
  "featured": false,
  "description": "<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>\n",
  "short_description": "<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>\n",
  "price": "21.99",
  "regular_price": "21.99",
  "sale_price": "",
  "date_on_sale_from": "",
  "date_on_sale_to": "",
  "on_sale": false,
  "purchasable": true,
  "total_sales": 0,
  "tax_status": "taxable", //taxable, shipping (Shipping only) and none
  "tax_class": "",
  "sold_individually": false,
  "weight": "",
  "dimensions": {
    "length": "",
    "width": "",
    "height": ""
  },
  "categories": [
    {
      "id": 9,
      "name": "Clothing",
      "slug": "clothing"
    },
    {
      "id": 14,
      "name": "T-shirts",
      "slug": "t-shirts"
    }
  ],
  "images": [
    {
      "id": 163,
      "date_created": "2016-05-31T23:40:07",
      "date_modified": "2016-05-31T23:40:07",
      "src": "https://example.com/wp-content/uploads/2016/05/T_2_front.jpg",
      "name": "",
      "alt": "",
      "position": 0
    },
    {
      "id": 164,
      "date_created": "2016-05-31T23:40:10",
      "date_modified": "2016-05-31T23:40:10",
      "src": "https://example.com/wp-content/uploads/2016/05/T_2_back.jpg",
      "name": "",
      "alt": "",
      "position": 1
    }
  ],
  "attributes": [],
  "default_attributes": [],
  "variations": [],
  "grouped_products": [],
  "menu_order": 0
}
```


### Product
| 이름 | 타입 | 설명 |
| --- | --- | --- | --- |
| id	 | String | 	상품 ID |
| name	 | String	 | 상품명	 |
| type	 | String	 | 상품 타입 	 |
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
| viewingLength	 | String	 | 구매가 유효한 기간. </br>DDD:HH:mm 형태 혹은 DD:HH:mm 형태 	 |
| viewablePeriodState	 | Int	 | 무제한시청(평생소장) 여부</br>0 : 기본값</br>1 : 무제한시청(평생소장). viewingLength값이 무시된다.  |

###ProductPolicy
| 이름 | 타입 | 설명 |
| --- | --- | --- |
| type	 | String	 | 상품 정책의 타입 </br>static : 고정 기간 고정 가격 정책 |
| licenseStart	 | String	 | 상품 정책 유효기간 시작일</br> “YYYY-MM-DD HH:MM:SS” 형태 |
| licenseEnd	 | String	 | 상품 정책 유효기간 종료일</br> “YYYY-MM-DD HH:MM:SS” 형태 |
| price	 | ProductPrice	 | 해당 상품 정책에 의한 가격 |

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
