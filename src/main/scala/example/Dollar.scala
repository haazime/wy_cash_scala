package example

class Dollar(var amount: Int) {
  def times(multiplier: Int): Dollar = {
    return new Dollar(amount * multiplier)
  }

  override def equals(other: Any): Boolean = other match {
    case that: Dollar => amount == that.amount
    case _ => false
  }
}