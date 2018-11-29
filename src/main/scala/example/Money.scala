package example

object Money {
  def dollar(amount: Int): Money = {
    new Money(amount, "USD")
  }

  def franc(amount: Int): Money = {
    new Money(amount, "CHF")
  }
}

class Money(private var amount: Int, val currency: String) extends Expression {
  def times(multiplier: Int): Money = {
    new Money(amount * multiplier, currency)
  }

  def plus(addend: Money): Expression = {
    new Money(amount + addend.amount, currency)
  }

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val that = other.asInstanceOf[Money]
      this.currency == that.currency && this.amount == that.amount
    } else {
      false
    }
  }
}
