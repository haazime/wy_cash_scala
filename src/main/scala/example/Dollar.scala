package example

class Dollar(amount: Int, currency: String) extends Money(amount, currency) {
  def times(multiplier: Int): Money = {
    Money.dollar(amount * multiplier)
  }
}