package example

class Money(private var amount: Int) {
  override def equals(other: Any): Boolean = other match {
    case that: Money => amount == that.amount
    case _ => false
  }
}
