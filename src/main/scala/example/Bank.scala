package example

class Bank(private var rates: Map[Pair, Int] = Map.empty) {
  def reduce(source: Expression, to: String): Money = {
    source.reduce(this, to)
  }

  def addRate(from: String, to: String, rate: Int): Unit = {
    rates += (new Pair(from, to) -> rate)
  }

  def rate(from: String, to: String): Int = {
    from == to match {
      case true => 1
      case false => rates(new Pair(from, to))
    }
  }
}
