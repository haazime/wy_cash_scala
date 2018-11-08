package example

class Franc(private var amount: Int) {
  def times(multiplier: Int): Franc = {
    return new Franc(amount * multiplier)
  }

  override def equals(other: Any): Boolean = other match {
    case that: Franc => amount == that.amount
    case _ => false
  }
}
