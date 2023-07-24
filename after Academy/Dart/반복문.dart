main() {
  List<int> list = [1, 2, 3];

  for (int i = 0; i < list.length; i++) {
    print(list[i]);
  }

  for (int i in list) {
    print(i);
  }

  // map 반복문 알아보기
  Map<String, String> map = {
    'apple': 'a',
    'banana': 'b',
    'canada': 'c',
  };
}
