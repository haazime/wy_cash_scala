package example

class Money(private var amount: Int) {
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val that = other.asInstanceOf[Money]
      return this.getClass == that.getClass && this.amount == that.amount
    } else {
      return false
    }
  }
}
