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

  test("Plus Returns Sum") {
    val five: Money = Money.dollar(5)
    val result: Expression = five.plus(five)
    val sum: Sum = result.asInstanceOf[Sum]
    assert(sum.augend == five)
    assert(sum.addend == five)
  }

  test("Reduce Sum") {
    val sum: Expression = new Sum(Money.dollar(3), Money.dollar(4))
    val bank: Bank = new Bank
    val result: Money = bank.reduce(sum, "USD")
    assert(result == Money.dollar(7))
  }

  test("Reduce Money") {
    val bank: Bank = new Bank
    val result: Money = bank.reduce(Money.dollar(1), "USD")
    assert(result == Money.dollar(1))
  }
}