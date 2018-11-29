package example

trait Expression {
  def reduce(to: String): Money
}

class Sum(val augend: Money, val addend: Money) extends Expression {
  def reduce(to: String): Money = {
    val amount: Int = augend.amount + addend.amount
    new Money(amount, to)
  }
}
