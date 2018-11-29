package example

trait Expression {
}

class Sum(val augend: Money, val addend: Money) extends Expression {
}
