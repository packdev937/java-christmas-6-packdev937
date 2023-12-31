## 📮한 줄 요약
*식당 예약 시 받을 수 있는 할인 혜택의 종류와 예상 결제 금액*

## 🚀 기능 구현 목록
### 출력 기능
- [x] 이벤트 플래너 시작 문구를 출력한다
- [x] 예상 방문 날짜를 묻는 문구를 출력한다
- [x] 주문할 메뉴와 개수를 묻는 문구를 출력한다
- [x] 이벤트 혜택을 안내하는 문구를 출력한다
- [x] 이벤트 혜택을 출력한다
  - [x] 주문 메뉴를 출력한다
    - [x] 메뉴는 `메뉴명 : N개` 형식으로 출력한다
  - [x] 할인 전 총 주문 금액을 출력한다
  - [x] 증정 메뉴를 출력한다
  - [x] 혜택 내역을 출력한다
    - [x] 할인 된 금액에 대해서는 -를 붙여 출력한다
  - [x] 총 혜택 금액을 출력한다
  - [x] 12월 이벤트 배지를 출력한다
  - [x] 적용된 이벤트가 없다면 `없음`을 출력한다
- [x] 할인 후 예상 결제 금액을 출력한다
- [x] 에러 메세지에는 `[ERROR]`를 함께 출력한다

### 입력 기능
- [x] 식당 예상 방문 날짜를 입력한다
  - [x] 입력 날짜가 1 미만 31 초과 라면 예외를 발생한다
  - [x] 숫자를 입력하지 않으면 예외를 발생한다
- [x] 주문할 메뉴와 개수를 입력한다
  - [x] `메뉴명-N` 의 형식으로 입력한다
  - [x] 입력 형식을 지키지 않는다면 예외를 발생한다
  - [x] 메뉴의 개수가 숫자가 아니라면 예외를 발생한다
  - [x] 메뉴의 개수는 0 이상 20 이하 여야 한다

### 동작 기능
- [x] 혜택
  - [x] 각 할인 정책의 혜택 내역을 저장한다
- [x] 총 혜택
  - [x] 총 혜택 금액을 계산한다
- [x] 크리스마스 디데이 할인
  - [x] 크라스마스 디데이 할인은 날마다 할인 금액이 100원씩 증가한다
  - [x] 크라스마스 디데이 할인의 시작 금액은 1000원이다
  - [x] 크리스마스 디데이 할인은 12월 1일 부터 12월 25일 까지 적용된다
-[x] 특별 할인 
  - [x] 특별 할인 정책은 3일, 10일, 17일, 24일, 25일, 31일은 특별 할인이 적용된다
  - [x] 특별 할인 정책은 총 주문 금액에서 1000원을 할인한다
- [x] 평일 할인 정책
  - [x] 평일 할인 정책은 디저트 메뉴 1개 당 2023원을 할인한다
  - [x] 평일 할인 정책은 12월 1일 부터 12월 31일 까지 적용된다
  - [x] 평일 할인 정책은 일요일 부터 목요일 까지 적용된다
- [x] 주말 할인 정책
  - [x] 주말 할인 정책은 메인 메뉴 1개 당 2023원을 할인한다
  - [x] 주말 할인 정책은 12월 1일 부터 12월 31일 까지 적용된다
  - [x] 주말 할인 정책은 금요일과 토요일에 적용된다
- [x] 프로모션
  - [x] 할인 전 총 주문 금액이 120,000원 이상일 때 샴페인 1개를 증정한다
  - [x] 샴페인이 증정된다면 증정 이벤트 할인 혜택에는 25,000원이 적용된다
- [x] 총 할인 혜택 금액을 계산한다
- [x] 총 할인 혜택 금액에 따라 이벤트 배지를 부여한다
  - [x] 5,000원 이상은 별, 10,000 이상은 트리, 20,000 이상은 산타를 부여한다
- [x] 총 주문 금액을 계산한다
  - [x] 총 주문 금액이 10,000 이상이여야 이벤트가 적용된다
- [x] 메뉴를 주문한다
  - [x] 어떤 종류의 주문이 들어왔는지 확인한다
    - [x] 음료만 주문 시 예외를 발생한다
  - [x] 총 주문 개수의 합을 계산한다
    - [x] 총 주문 개수의 합이 20을 초과한다면 예외를 발생한다
  - [x] 메뉴 리스트를 확인한다
    - [x] 메뉴가 존재하지 않는다면 예외를 발생한다
  - [x] 메뉴의 중복을 검사한다
    - [x] 중복된 메뉴를 주문 시 예외를 발생한다
- [x] 총 혜택 금액은 할인 금액의 합계과 증정 메뉴의 가격을 합하여 계산한다
  - [x] 총 혜택 금액에 따라 이벤트 배지를 변경한다
- [x] 할인 후 예상 결제 금액
  - [x] 할인 전 총 주문 금액에서 할인 금액을 빼서 계산한다
- [x] 메뉴의 이름에 따라 어떤 종류의 음식인지 확인한다
- [x] 메뉴의 이름에 따라 가격을 확인한다

## 도메인 추출
*README의 기능 명세를 보고 1차로 도메인을 추출하는 작업을 진행합니다.*

>중복된 할인과 증정을 허용해서, 고객들이 혜택을 많이 받는다는 것을 체감
- 할인 (DiscountPolicy -> XXXDiscountPolicy), 고객 (Client)

> 올해 12월에 지난 5년 중 최고의 판매 금액 달성
- 판매 금액 (SaleAmount)

> (12.1 ~ 12.25) 크리스마스 디데이 할인 : 날마다 할인 금액이 100원씩 증가
- 누적 할인 정책 (AccumulateDiscountPolicy)

> (12.1 ~ 12.31) 평일 (일요일 ~ 목요일) 할인 :평일에는 디저트 메뉴 1개당 2023원 할인
- 평일 할인 정책 (WeekdayDiscountPolicy)

> (12.1 ~ 12.31) 주말 (금요일 ~ 토요일) 할인 :주말에는 메인 메뉴 1개당 2023원 할인
- 주말 할인 정책 (WeekendDiscountPolicy)

> (12.1 ~ 12.31) 특별 (달력에 별이 있으면) 할인 : 총 주문 금액에서 1000원 할인
- 특별 할인 정책 (SpecialDiscountPolicy)

> (12.1 ~ 12.31) 증정 이벤트 : 할인 전 총 주문 금액이 12만원 이상일 때, 샴페인 1개 증정
- 이벤트 (Event)

> 총 혜택 금액에 따른 이벤트 배지를 부여
- 이벤트 뱃지 (EventBadge : Enum)
  - ex) (5000, STAR), (10000, TREE), (20000, SANTA)

>총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 총 주문 금액 (TotalOrderAmount)

```java
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```
- Food -> Epitizer, Main, Dessert, Drink

>음료만 주문 시, 주문할 수 없습니다.
- Cashier

>메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
- Cashier

>고객들이 식당에 방문할 날짜와 메뉴를 미리 선택하면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 보여주기를 기대합니다.
- 식당 (Restaurant), 방문할 날짜와 메뉴 (Reservation), 이벤트 플래너 (Event Planner)

> 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 총 혜택 금액 (TotalDiscountAmount)

> 할인 후 예상 결제 금액
- 최종 금액 (FinalAmount)

## 🚗 기능 구현 예제
```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액> 
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```