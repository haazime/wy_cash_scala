package example

class Franc(amount: Int, currency: String) extends Money(amount, currency) {
  def times(multiplier: Int): Money = {
    Money.franc(amount * multiplier)
  }
}
