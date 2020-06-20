# cqrs-eventsourcing-practice

## event sourcing ?

이벤트 소싱은 영속 데이터를 어떤 식으로 저장할 것인지에 관한 것으로, 전통적인 데이터 저장 방법은 현실 세계의 것들을 직접적으로 표현하고 있는 도메인 객체(혹은 DB layer와 domain layer 사이의 간극을 해소하기 위한 DTO 객체)를 db에 담는 방식이었다. 이러한 방식은 직관적이어서 이해하기 쉽다는 장점이 있지만, 항상 도메인 객체의 최종 상태만을 담고 있기 때문에 변경된 기록을 정확하게 추적할 수 없고, 한 데이터에 대해 검색 및 변경 요청이 빈번하게 발생하기 때문에 동시성 문제를 갖고 있다는 단점이 존재한다.

반면 이벤트 소싱 방식은 도메인 객체를 생성하고, 상태를 변경하기 위해 발생하는 이벤트(event)들을 db에 저장함으로써 위에 언급한 문제들의 해결을 시도한다. 이벤트 소싱 방식에서는 도메인 객체에 대한 변경 이벤트를 모두 추적할 수 있으며, 이벤트는 한 번 발생한 이후 수정되지 않기 때문에 update나 delete 없이 항상 insert 작업만 일어난다. 따라서 동시성 문제로부터 비교적 자유롭다.

![event_sourcing](./images/Event-Sourcing.jpg)

## CQRS (command query responsibility segregation)

그렇다면 이벤트 소싱 방식에서 질의(query)에 대한 응답은 어떻게 이루어질까? 질의란 데이터를 변경하지 않고 현재 데이터의 상태를 조회하는 요청을 뜻한다. 실제 db에 담겨 있는 데이터는 이벤트들의 집합이므로, 이 이벤트들을 시간 순서대로 실행하고 나면 최종적인 도메인 데이터를 얻을 수 있다. 하지만 조회 요청이 들어올 때마다 쌓여있는 이벤트들을 모두 실행시키는 것은 너무나 비효율적이므로, 도메인 데이터의 조회에 대한 새로운 모델이 필요해보인다. 이러한 맥락에서 이벤트 소싱 패턴은 명령(command)와 질의(query)의 책임을 분리하는 패턴인 CQRS 패턴과 잘 어울린다.

## Axon framework

axon framework는 DDD 패러다임 하에서 event sourcing과 CQRS 패턴을 이용해 애플리케이션을 작성할 수 있도록 도와주는 framework이다. 이번 실습에서는 axon framework과 spring boot를 사용해 cqrs 및 event sourcing 방식의 application을 만들어보려고 한다.