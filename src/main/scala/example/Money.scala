package example

object Money {
  def dollar(amount: Int): Dollar = {
    new Dollar(amount, "USD")
  }

  def franc(amount: Int): Franc = {
    new Franc(amount, "CHF")
  }
}

abstract class Money(private var amount: Int, val currency: String) {
  def times(multiplier: Int): Money

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val that = other.asInstanceOf[Money]
      this.getClass == that.getClass && this.amount == that.amount
    } else {
      false
    }
  }
}
