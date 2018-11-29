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
    assert(Money.franc(5) == Money.franc(5))
    assert(Money.franc(5) != Money.franc(6))
    assert(Money.dollar(5) != Money.franc(5))
  }

  test("Franc Multiplication") {
    var five: Money = Money.franc(5)
    assert(five.times(2) == Money.franc(10))
    assert(five.times(3) == Money.franc(15))
  }

  test("Currency") {
    assert(Money.dollar(1).currency == "USD")
    assert(Money.franc(1).currency == "CHF")
  }

  test("Different Class Equality") {
    assert(new Money(10, "CHF") == Money.franc(10))
  }
}