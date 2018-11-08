package example

class Dollar(var amount: Int) {
  def times(multiplier: Int): Unit = {
    amount *= multiplier
  }
}