<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fpdyvo%2FbtshHMQ3AGA%2FjyJlOfloclRuI5ZtAi7qRK%2Fimg.png"> 의 리팩토링 프로젝트


<br><br>
저는 스프링의 꽃은 객체지향이 아닐까 생각해요<br>
스프링의 본질에 좀 더 다가가기 위해 어떻게 하면 좀 더 유지보수와 확장에 유리한 코드를 작성할 수 있을까 고민하는데<br>
이것은 제가 <strong>"오늘도 휴일"</strong>을 개발하며 아쉬웠던 부분을 리팩토링하는 자기반성용 프로젝트입니다<br>
부족한 제가 나름대로 고민한 결과물이에요! :)




<h3> 메일 서비스 수정 </h3>


https://hyuil.tistory.com/204


```swift
- 기존 메일 서비스는 메일을 요청마다 각각 다른 템플릿 메서드와 코드 셋팅 메서드 등을 사용해야 했음
- 요청을 보낼 때 어떤 요청인지 알 수 있는 값을 보내어 조금씩 다르게 동작하게 한다면 좀 더 확장에 유리하지 않을까?
```