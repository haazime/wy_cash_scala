package example

class Franc(amount: Int) extends Money(amount) {
  def times(multiplier: Int): Franc = {
    return new Franc(amount * multiplier)
  }
}
