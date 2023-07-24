main() {
  ThreeKingdoms threeKingdoms = ThreeKingdoms(
    name: '순형',
    nation: '대한민국',
  );

  print(threeKingdoms.name);
}

class ThreeKingdoms {
  // fields or property
  // field 에는 초기값이 무조건 있어야 한다.
  // 이 때 초기값이 없을 때 하는 것이 null safety 이다.
  // null로 초기화
  String? name;
  // 나중에 들어올거면은 late 앞에 붙인다.
  late String nation;

  // constructor
  ThreeKingdoms({required this.name, required this.nation});

  // function
  saySomething() {
    print('제 이름은 ${this.name} 이고 제가 사는 나라는 ${this.nation} 입니다.');
  }
}
