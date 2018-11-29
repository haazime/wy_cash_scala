package example

import org.scalatest._

class MoneyTest extends FunSuite {
  test("Multiplication") {
    var five: Money = Money.dollar(5)
    assert(five.times(2) == Money.dollar(10))
    assert(five.times(3) == Money.dollar(15))
  }

  test("Equality") {
    assert(Money.dollar(5) == Money.dollar(5))
    assert(Money.dollar(5) != Money.dollar(6))
    assert(Money.dollar(5) != Money.franc(5))
  }

  test("Currency") {
    assert(Money.dollar(1).currency == "USD")
    assert(Money.franc(1).currency == "CHF")
  }

  test("Simple Addition") {
    val five: Money = Money.dollar(5)
    val sum: Expression = five.plus(five)

    val bank: Bank = new Bank()
    val reduced: Money = bank.reduce(sum, "USD")
    assert(reduced == Money.dollar(10))
  }
}