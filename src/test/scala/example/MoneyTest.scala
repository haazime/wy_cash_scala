package example

import org.scalatest._

class MoneyTest extends FunSuite {
  test("Multiplication") {
    var five = new Dollar(5)
    var product = five.times(2)
    assert(product.amount == 10)

    product = five.times(3)
    assert(product.amount == 15)
  }

  test("Equality") {
    assert(new Dollar(5) == new Dollar(5))
    assert(new Dollar(5) != new Dollar(6))
  }
}