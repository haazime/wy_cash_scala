package example

trait Expression {
  def reduce(bank: Bank, to: String): Money
  def plus(addend: Expression): Expression
  def times(multiplier: Int): Expression
}

case class Sum(augend: Expression, addend: Expression) extends Expression {
  def plus(addend: Expression): Expression = {
    Sum(this, addend)
  }

  def times(multiplier: Int): Expression = {
    Sum(augend.times(multiplier), addend.times(multiplier))
  }

  def reduce(bank: Bank, to: String): Money = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
}
