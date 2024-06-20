# 3장. 입출금 내역 분석기 확장판

> ...



## 진행

* [ ] 한번 읽어보기!!!

### 





## 의견

* ...



## 기타

### 내가 종종 변수명을 오타 칠때가 있어서 VSCode에 CSpell을 적용했는데 괜찮아보인다. 👍

* 철자가 틀렸을 때,, 바로바로 알려줘서 매우 좋다👍
  

### Maven 빌드도 가능하게 예제 프로젝트를 수정할 것인가 말것인가? 😂

하면 좋긴한데... 이미 Gradle로 멀티 프로젝트 구성을 해서 사용중이니.. Gradle로만 프로젝트를 진행하자!

* pom.xml을 별도 추가하면 버전관리 따로 하느라고 불편해 질 것 같음...
* 그래도 뭐.. 생각을 해보자.. 그냥 추가할지?.. 😅



## 정오표

* 51쪽: 
  * 51쪽에 메서드가 추가되야할 클래스는 BankTransactionProcessor가 아니고,  BankStatementProcessor이다.
    * https://github.com/Iteratr-Learning/Real-World-Software-Development/blob/master/src/main/java/com/iteratrlearning/shu_book/chapter_03/BankStatementProcessor.java
* 55쪽:
  * 예제 기준으로는 BankTransactionProcessor가 아니고,  BankStatementProcessor여야하는데, 그래서 Google Play Book에서 원서 일부를 샘플로 볼 수 있어서 봤는데, 거기도 BankTransactionProcessor로 되어있음. 😂
    * 책이 예제 기준으로 더 다듬어져야할 것 같은데... 익숙하지 않은 사람이 보면 힘들 것 같다. 
    * BankStatementXXX와 BankTransacionXXX을 혼용하다가 저자님도 해깔리신 것 같다..
      * 그냥 내가 클래스 명을 BankTransactionXXX으로 바꿔버리는 게 나아보임. 
      * CSV를 파싱하는 부분은 BankStatementXXX이름을 유지하는게 나을 것 같고,
      * BankStatementProcessor -> BankTransactionProcessor 이렇게만 바꾸자..
        * 이름 바꾸는게 낫지 않겠냐고, 저자님 깃허브에 이슈 올렸음.
          * https://github.com/Iteratr-Learning/Real-World-Software-Development/issues/18