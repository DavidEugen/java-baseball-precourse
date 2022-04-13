# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 진행 방식

- 미션은 세 가지로 구성되어 있다.
    - 기능 요구사항
    - 프로그래밍 요구사항
    - 과제 진행 요구사항
- **기능을 구현하기 전에 기능 목록을 만들고**,
- **기능 단위로 commit**

## 과제 진행 요구사항

- [x] https://github.com/next-step/java-baseball-precourse fork/clone 
- [x] 기능을 구현하기 전에 **docs/README.md** 파일에 구현할 기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞 단계에서 docs/README.md 파일에 정리한 **기능 목록 단위** 또는 **의미있는 단위**로 Commit
- [x] [커밋 메시지 컨벤션][커밋 메시지 컨벤션 URL] 참고해 commit log를 남기려고 노력해 본다.
- [x] 제 진행 및 제출 방법은 [프리코스 과제 제출 문서][프리코스 과제 제출 문서 URL]를 참고

## 과제 제출 전 체크리스트 - 0점 방지
- [x] 터미널에서 “java -version”을 실행해 자바 8인지 확인
- [x] 또는 Eclipse, Intellij와 같 은 IDE의 자바 8로 실행하는지 확인
- [ ] ```./gradlew clean test``` 명령어를 실행하고, 모든 테스트가 통과하는지 확인

## 프로그래밍 요구사항1 - 제약사항
- [ ] 숫자 야구게임을 실행하는 시작점은 **src/main/java** 폴더의 **baseball.Application**의 **main()** 이다
- [ ] 숫자 야구게임은 JDK 8 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다.
- [ ] Random 및 Scanner 사용시 => camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
  - Random 값 추출은 **camp.nextstep.edu.missionutils.Randoms**의 **pickNumberInRange()**
  - 사용자가 입력하는 값은 **camp.nextstep.edu.missionutils.Console**의 **readLine()** 을
- [ ] 완료시 src/test/java 폴더의 baseball.ApplicationTest의 2개의 Test Case가 성공. 실패할 경우 0점
  - ApplicationTest에서 제공하는 2개의 Test Case는 숫자 야구게임 구현을 위한 최소한의 Test Case이다.
  - [옵션] 소스 코드를 참고해 숫자 야구게임을 위한 모든 Test Case를 추가해 보는 것도 테스트에 대한 좋은 연습.

## 프로그래밍 요구사항2 - 제약사항
- [ ] [자바 코드 컨벤션][자바 코드 컨벤션 URL]을 지키면서 프로그래밍
  - [x] intellij-java-wooteco-style.xml 로 formatter 적용.
- [ ] indent 1까지만 허용
  - ex) while문 안에 if문이 있으면 들여쓰기는 2
  - 힌트: ndent depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [ ] 자바 8에 추가된 **stream api를 사용하지 않고** 구현해야 한다. 단, **람다는 사용 가능**하다.
- [ ] **else 예약어를 쓰지 않는다**.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다
  - switch/case도 허용하지 않는다
- [ ] 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현


## 프로그래밍 요구사항3 - 단위 테스트
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다
  - 단, UI(System.out, System.in, Scanner) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현
  - 힌트: **MVC 패턴 기반으로 구현한** 후 **View, Controller 를 제외한 Model 에 대한 단위 테스트를 추가**하는 것에 집중
- [x] JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해
  사용법을 학습한 후 JUnit5 기반 단위 테스트를 구현

## 기능 요구 사항

- [ ] 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임 => 룰(모델)
- [ ] 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를
  이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다. => 룰(모델), UI
- [ ] 상대방의 역할을 컴퓨터가 한다.  컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택. 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력. 
  컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력 => UI 
- [ ] 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료 => UI
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료 => UI

### [기능 요구사항 목록 정리](./docs/README.md)

## 프로그램 실행 결과
```shell
숫자를 입력해주세요 : 123 
1볼 1스트라이크
숫자를 입력해주세요 : 145 
1볼
숫자를 입력해주세요 : 671 
2볼
숫자를 입력해주세요 : 216 
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 1
숫자를 입력해주세요 : 123
1볼
...
```

---
참고사항

[커밋 메시지 컨벤션 URL]: https://gist.github.com/stephenparish/9941e89d80e2bc58a153
[프리코스 과제 제출 문서 URL]: https://github.com/next-step/nextstep-docs/blob/master/precourse
[자바 코드 컨벤션 URL]: https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java