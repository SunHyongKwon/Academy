main() {
  // fat arrow 사용하서 꺼내 와야 된다.
  getVersionname().then(
    (value) => print(value),
  );
  print('samamda');
}

Future<String> getVersionname() async {
  var versionName = await lookUpVersionName();
  return versionName;
}

String lookUpVersionName() {
  return 'apple';
}


// app은 하나가 켜지면 하나가 꺼지는게 아니라 하나가 계속해서 앞에 쌓이는 것이다. 
// 그러므로 app은 life cycle이 없다는 것이다. 
// 그래서 then을 사용하는 것이다.  