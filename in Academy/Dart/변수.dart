// void 는 써도 되고 안 써도 된다.
main() {
  var name = '유비';
  print(name);

  int intNum1 = 30;
  int intNum2 = 20;

  // 나누기 결과 값이 double 로 나온다.
  print(intNum1 / intNum2);

  // 나누기 몫 출력
  print(intNum1 ~/ intNum2);
  // 나누기 나머지 출력
  print(intNum1 % intNum2);

// -----------------------------------------------------------
// -----------------------------------------------------------

  // 문자열 연결
  String str1 = '유비';
  String str2 = '장비';

  // 원래 쓰던 방법
  print(str1 + " : " + str2);
  // 문자열 보간법 (String Interpolation)
  print('$str1 : $str2');
  var test = 'intNum1과 intNum2의 합은 ${intNum1 + intNum2} 입니다.';
  print(test);
}
