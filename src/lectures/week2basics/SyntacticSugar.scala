package lectures.week2basics

object SyntacticSugar extends App {
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation
    def speaksEnglish: Boolean = true
    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"

    def unary_! : String = s"$name is not real"
    def unary_+ : String = s"$name nanana"
  }

  val bob = new Person("Bob", "Developer")
  println(!bob)
  println(+bob)

}
