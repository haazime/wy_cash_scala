package example

import org.scalatest._

class MoneyTest extends FunSuite {
  val bank: Bank = new Bank()
  bank.addRate("CHF", "USD", 2)

  val fiveBucks: Expression = Money.dollar(5)
  val tenFrancs: Expression = Money.franc(10)

  test("Multiplication") {
    val five = Money.dollar(5)
    assertResult(Money.dollar(10)) { five.times(2) }
    assertResult(Money.dollar(15)) { five.times(3) }
  }

  test("Equality") {
    assert(Money.dollar(5) == Money.dollar(5))
    assert(Money.dollar(5) != Money.dollar(6))
    assert(Money.dollar(5) != Money.franc(5))
  }

  test("Currency") {
    assertResult("USD") { Money.dollar(1).currency }
    assertResult("CHF") { Money.franc(1).currency }
  }

  test("Simple Addition") {
    val five = Money.dollar(5)
    val sum = five.plus(five)
    assertResult(Money.dollar(10)) {
      bank.reduce(sum, "USD")
    }
  }

  test("Plus Returns Sum") {
    val five = Money.dollar(5)
    val result = five.plus(five)
    result match {
      case Sum(augend, addend) =>
        assertResult(five) { augend }
        assertResult(five) { addend }
      case _ =>
        assert(false, "plus is expected to return Sum but returns other type")
    }
  }

  test("Reduce Sum") {
    val sum = Sum(Money.dollar(3), Money.dollar(4))
    assertResult(Money.dollar(7)) {
      bank.reduce(sum, "USD")
    }
  }

  test("Reduce Money") {
    assertResult(Money.dollar(1)) {
      bank.reduce(Money.dollar(1), "USD")
    }
  }

  test("Reduce Money Different Currency") {
    assertResult(Money.dollar(1)) {
      bank.reduce(Money.franc(2), "USD")
    }
  }

  test("Identity Rate") {
    assertResult(1) { bank.rate("USD", "USD") }
  }

  test("Mixed Addition") {
    assertResult(Money.dollar(10)) {
      bank.reduce(fiveBucks.plus(tenFrancs), "USD")
    }
  }

  test("Sum Plus Money") {
    val sum = Sum(fiveBucks, tenFrancs).plus(fiveBucks)
    assertResult(Money.dollar(15)) {
      bank.reduce(sum, "USD")
    }
  }

  test("Sum Times") {
    val sum = Sum(fiveBucks, tenFrancs).times(2)
    assertResult(Money.dollar(20)) {
      bank.reduce(sum, "USD")
    }
  }
}