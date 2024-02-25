main() {
  final String name1 = changeName('wkdal');
  const String name2 = 'ㅁㄴㅇㄹ';

  // class와 new 연산자 안써줘도 된다.
  final now1 = DateTime.now();
  print(now1);

  // final 과 const의 차이점
  // 둘다 한번 정해지면 변하지 않는다는 것은 같다. 하지만,
  // final은 실행시(complie)에 결정이 된다.
  // const는 정해진 값만 수용한다. 실행시 결정되는 값으로 정할 수 없다.
}

changeName(String name) {
  return name + ";";
}
