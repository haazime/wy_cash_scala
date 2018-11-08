package example

import org.scalatest._

class MoneyTest extends FunSuite {
  test("Multiplication") {
    val five: Dollar = new Dollar(5)
    five.times(2)
    assert(five.amount == 10)
  }
}