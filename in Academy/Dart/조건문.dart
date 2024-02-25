main() {
  // 삼항연산자
  int num1 = 10;
  int num2 = 10;
  var visibility = num1 == num2 ? 'apple' : 'banana';
  print(visibility);

  // 데이터가 들어왔는지 안 들어왔는지 판단할 떄 사용한다.
  bool isPublic = true;
  var visibility2 = isPublic ? 'public' : 'private';
  print(visibility2);

  // for문도 동일하다.
}
