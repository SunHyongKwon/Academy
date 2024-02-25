main() {
  // void는 생략 가능
  // public
  addition(int x, int y) {
    print('$x + $y = ${x + y}');
  }

  // private _ 붙이면 private
  _addition(int x, int y) {
    print('$x + $y = ${x + y}');
  }

  addition(10, 20);
  _addition(10, 20);
}
