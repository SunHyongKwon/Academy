import 'dart:convert';

main() {
  // 여러 줄을 쓸 수 가 있다. """ 세개 쓰면
  // JSON 구조 만들기
  var jsonString = """
  [
    {
      "score" : 40 
    },
    {
      "score" : 80 
    },
    {
      "test":{
        "korean" : 20,
        "english" : 40,
        "mathematics" : 60
      }
    }
  ]
""";

  // list 형식을
  var scores = jsonDecode(jsonString);

  print(scores is List);
  print(scores);
  print(scores[0]["score"]);
  print(scores[2]["test"]["korean"]);

  List<Map<String, String>> listMap = [
    {
      '1': 'one',
      '2': 'two',
      '3': 'three',
      '4': 'four',
      '5': 'five',
    },
    {
      '1': 'one',
      '2': 'two',
      '3': 'three',
      '4': 'four',
      '5': 'five',
    },
    {
      '1': 'one',
      '2': 'two',
      '3': 'three',
      '4': 'four',
      '5': 'five',
    },
    {
      '1': 'one',
      '2': 'two',
      '3': 'three',
      '4': 'four',
      '5': 'five',
    },
    {
      '1': 'one',
      '2': 'two',
      '3': 'three',
      '4': 'four',
      '5': 'five',
    },
  ];

  print(listMap[0]['3']);
}
