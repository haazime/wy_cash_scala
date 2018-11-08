package example

class Money(private var amount: Int) {
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val that: Money = other.asInstanceOf[Money]
      return amount == that.amount
    } else {
      return false
    }
  }
}
