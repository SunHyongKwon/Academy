main() {
  // 동기 처리 (sync)
  // 직렬적으로 일을 처리
  // 싱글 코어 일 때 적합하지만, 요새는 다 멀티 코어니까 비동기 처리방식이 훨씬 효율적이다.

  // 비동기 처리 (async)
  // 병렬적으로 일을 처리
  // 멀티 쓰레드를 사용하는 것이다.

  checkVersion();
  checkVersion2();
  print('end process');
}

// 비동기 처리 함수 만들기
// Future async 를 사용하면 멀티 쓰레드를 쓰도록 하는 것이다.
Future checkVersion() async {
  // await로 작업의 순서를 정해주는 것이다.
  var version = await lookupVersion(1);
  print(version);
}

int lookupVersion(int x) {
  if (x == 1) {
    return 12;
  }
  return 0;
}

// 다 불러 왔는지 안 불러 왔는지 알려고 사용하는 것이 삼항연산자 이다.

Future checkVersion2() async {
  // await로 작업의 순서를 정해주는 것이다.
  var version = await lookupVersion(0);
  print(version);
}

int lookupVersion2() {
  return 20;
}
