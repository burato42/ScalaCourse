package lectures.week2basics

case class Person(name: String, occupation: String)

object CaseClasses extends App {
  val bob = Person("Bob", "Developer")

  val anotherBob = bob.copy()
  println(bob) // Person(Bob,Developer)
  println(anotherBob) // Person(Bob,Developer)

  val bobsTwin = bob.copy(name = "John")
  println(bobsTwin) // Person(John,Developer)

  assert(bob == anotherBob)
  assert(bob != bobsTwin)
}