package example

trait Expression {
  def reduce(bank: Bank, to: String): Money
  def plus(addend: Expression): Expression
  def times(multiplier: Int): Expression
}

case class Sum(val augend: Expression, val addend: Expression) extends Expression {
  def plus(addend: Expression): Expression = {
    new Sum(this, addend)
  }

  def times(multiplier: Int): Expression = {
    new Sum(augend.times(multiplier), addend.times(multiplier))
  }

  def reduce(bank: Bank, to: String): Money = {
    val amount: Int = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
}
