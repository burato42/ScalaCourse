package lectures.week2basics

class Pizza private {
  override def toString = "This is pizza"
}

object Pizza {
  val pizza = new Pizza

  def getInstance: Pizza = {
    pizza
  }
}

object TestPizza extends App {

  val pizza = Pizza.getInstance

    println(pizza)
}