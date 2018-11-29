package example

object Money {
  def dollar(amount: Int): Money = {
    new Money(amount, "USD")
  }

  def franc(amount: Int): Money = {
    new Money(amount, "CHF")
  }
}

class Money(var amount: Int, val currency: String) extends Expression {
  def times(multiplier: Int): Money = {
    new Money(amount * multiplier, currency)
  }

  def plus(addend: Money): Expression = {
    new Sum(this, addend)
  }

  def reduce(to: String): Money = {
    this
  }

  override def equals(other: Any): Boolean = {
    other match {
      case that: Money =>
        this.currency == that.currency && this.amount == that.amount
      case _ =>
        false
    }
  }
}
