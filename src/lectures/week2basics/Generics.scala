package lectures.week2basics

object Generics {
  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  class InvariantList[A]
  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  class ContravariantList[-A]
  val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]

  class SubtypeFood[T <: Fruit](fruit: T)
  val food = new SubtypeFood(new Banana)

  class SupertypeFood[T >: Fruit](fruit: T)
  val moreFood = new SupertypeFood(new Fruit)

  class CovariantList[+A]
  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]
}
