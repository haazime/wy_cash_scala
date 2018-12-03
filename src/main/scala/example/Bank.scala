package example

class Bank {
  private var rates: Map[Pair, Int] = Map.empty

  def reduce(source: Expression, to: String): Money = {
    source.reduce(this, to)
  }

  def addRate(from: String, to: String, rate: Int): Unit = {
    rates += (Pair(from, to) -> rate)
  }

  def rate(from: String, to: String): Int = {
    if (from == to) {
      return 1
    }
    rates(Pair(from, to))
  }
}
