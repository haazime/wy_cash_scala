package example

import org.scalatest._

class MoneyTest extends FunSuite {
  val bank: Bank = new Bank()
  val fiveBucks: Expression = Money.dollar(5)
  val tenFrancs: Expression = Money.franc(10)

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
    val result: Money = bank.reduce(sum, "USD")
    assert(result == Money.dollar(7))
  }

  test("Reduce Money") {
    val result: Money = bank.reduce(Money.dollar(1), "USD")
    assert(result == Money.dollar(1))
  }

  test("Reduce Money Different Currency") {
    bank.addRate("CHF", "USD", 2)

    val result: Money = bank.reduce(Money.franc(2), "USD")
    assert(result == Money.dollar(1))
  }

  test("Identity Rate") {
    assert(new Bank().rate("USD", "USD") == 1)
  }

  test("Mixed Addition") {
    bank.addRate("CHF", "USD", 2)
    val result: Money = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
    assert(result == Money.dollar(10))
  }

  test("Sum Plus Money") {
    bank.addRate("CHF", "USD", 2)
    val sum: Expression = new Sum(fiveBucks, tenFrancs).plus(fiveBucks)
    val result: Money = bank.reduce(sum, "USD")
    assert(result == Money.dollar(15))
  }

  test("Sum Times") {
    bank.addRate("CHF", "USD", 2)
    val sum: Expression = new Sum(fiveBucks, tenFrancs).times(2)
    val result: Money = bank.reduce(sum, "USD")
    assert(result == Money.dollar(20))
  }
}