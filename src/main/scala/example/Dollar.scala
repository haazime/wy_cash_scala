package example

class Dollar(amount: Int) extends Money(amount) {
  def times(multiplier: Int): Dollar = {
    return new Dollar(amount * multiplier)
  }
}