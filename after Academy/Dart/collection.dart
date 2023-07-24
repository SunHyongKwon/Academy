main() {
  // List Collection
  // List 생성 방법
  List threeKingdoms = [];

  // List 요소 추가 하는 방법
  threeKingdoms.add("위");
  threeKingdoms.add("we");

  // List 수정 하는 방법
  threeKingdoms[0] = "아래";

  // List 요소 삭제 하는 방법
  threeKingdoms.removeAt(0);
  threeKingdoms.remove('we');

  // List 갯수 체크
  threeKingdoms.add(1);
  threeKingdoms.add('순형');
  threeKingdoms.length;

  print(threeKingdoms);

  // List에 제너릭 타입 주기
  // 타입 주지 않으면 아무 타입이나 다 들어갈 수 있지만, 그런 식으로는 잘 사용하지 않는다.
  List<String> threeKingdoms2 = ['1', '2', '3'];
  threeKingdoms2.add('장비');

  // 다른 타입은 들어가지 않는다.
  // threeKingdoms2.add(1);

  for (var a in threeKingdoms2) {
    print(a);
  }

  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------

  // Map ->  { Key : Value }
  Map fruits = {
    'apple': '사과',
    'oragne': '오렌지',
    'watermelon': '수박',
    1: 3,
  };

  // [] 에 key 값 넣으면 value 값 가져온다.
  print(fruits['apple']);

  // map에 key 값으로 value 추가하기 / 수정하기
  fruits['banana'] = '바나나';

  // 제너릭 타입 주기
  // int Integer 로 안 주어도 됨
  Map<String, int> fruitsPrice = {
    'apple': 1000,
    'orange': 2000,
    'watermelon': 3000,
  };

  // optional 이라는 거다 이게
  // null safety 모시기 없을 수도 있으니까네
  int applePrice = fruitsPrice['apple']!;
}
