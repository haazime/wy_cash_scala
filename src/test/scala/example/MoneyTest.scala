package example

import org.scalatest._

class MoneyTest extends FunSuite {
  test("Multiplication") {
    var five = new Dollar(5)
    assert(five.times(2) == new Dollar(10))
    assert(five.times(3) == new Dollar(15))
  }

  test("Equality") {
    assert(new Dollar(5) == new Dollar(5))
    assert(new Dollar(5) != new Dollar(6))
  }
}