
# Metting

## 목차
- 개요
- 프로그램 구조 설명
- 문제 해결 방법
- 실행 방법
- Table 생성 방법
- 단위 테스트 케이스
- 통합 테스트 케이스

## 개요
- 30단위로 예약 가능, 30분을 기준으로 시작 
- 반복 예약 기능 —> 주단위 반복
- 동일한 회의실에 중첩된 일시로 예약 불가
- 종료 시간과 시작 시간이 겹치는 경우 중첩 아님
- 다수의 사용자가 동시에 동일 날짜, 회의실에 예약할 때 먼저 요청한 사용자의 예약만 처리

## 프로그램 구조
- Spring 4 MVC RESTful + MyBatis + MariaDB
- Spring 4.3.10.RELEASE
- Eclipse Oxygen.3a (4.7.3a)
- Maven 10.13.6
- JavaSE 1.8
- Apache Tomcat  7.0.47 (Embedded)
- 

## 문제 해결 방법
- Metting Table : <Metting Room Name, Start, End>, User, cycleCount
- Metting Room Table <Metting Room Name> 로 구성
- 회의실 예약 시, Start, End 2개의 값을 Date 값으로 저장함으로써, End 와 Start 간 30분 차이가 있는지 확인
- 회의실 예약 시, Start, End 2개의 값을 이용해서 일자가 넘어가서 예약이 될 경우도 처리 (예 : 2018-08-27 11:30 ~ 2018-08-28 00:30)
- 회의실 예약 내역 확인 시, Metting Room Table 을 이용해서 예약이 이루어지 않은 회의실에 대한 정보도 조회할 수 있도로 함
- 반복 예약 시, 하나의 데이터라도 중복이 발생하면 모든 예약이 이루어지지 않도로 Transaction 처리함.
- 예약이 중첩되는 3가지 경우 처리
  1. 신규 예약의 시작 시간이  이전 예약 시간 사이에 위치하는 경우
  2. 신규 예약의 종료 시간이  이전 예약 시간 사이에 위치하는 경우
  3. 신규 예약이 이전 예약 시간을 포함하는 경우
- 한 개 
