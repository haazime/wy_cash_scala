package example

trait Expression {
  def reduce(bank: Bank, to: String): Money
  def plus(addend: Expression): Expression
}

class Sum(val augend: Expression, val addend: Expression) extends Expression {
  override def plus(addend: Expression): Expression = { null }

  def reduce(bank: Bank, to: String): Money = {
    val amount: Int = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }
}
