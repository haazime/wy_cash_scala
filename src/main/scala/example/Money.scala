package example

object Money {
  def dollar(amount: Int): Money = {
    new Money(amount, "USD")
  }

  def franc(amount: Int): Money = {
    new Money(amount, "CHF")
  }
}

case class Money(val amount: Int, val currency: String) extends Expression {
  def times(multiplier: Int): Expression = {
    new Money(amount * multiplier, currency)
  }

  def plus(addend: Expression): Expression = {
    new Sum(this, addend)
  }

  def reduce(bank: Bank, to: String): Money = {
    val rate: Int = bank.rate(currency, to)
    new Money(amount / rate, to)
  }

  override def toString(): String = {
    amount + currency
  }
}
