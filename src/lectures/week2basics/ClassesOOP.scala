package lectures.week2basics

object ClassesOOP extends App {
  val noStudent = new Student()
  val newStudent = new Student("Will")
  val student = new Student(id = 1, name = "Bob")
  println(student.name)
  println(student.##)
  println(student.getId("Pam", 2))
  println(student.getId)
  println(noStudent.getId)
  println(noStudent.##)
  println(newStudent.getId)
}

class Student(id: Int, val name: String) {
  val uni = "University"

  def this(name: String) = this(0, name)
  def this() = this(0, "NoName")

  println("Student class")

  def getId(name: String, id: Int) = s"${this.name} has ID ${this.id} and $name has ID $id"

  def getId: String = s"here is $name's ID $id"
}

class Instructor(val id: Int, name: String, surname: String) {
  def fullName = s"${name.toLowerCase.capitalize} ${surname.toLowerCase.capitalize}"
}

class Course(courseID: Int, title: String, releaseYear: String, instructor: Instructor) {
  def getID(): Int = (courseID.toString + instructor.id.toString).toInt

  def isTaughtBy(someInstructor: Instructor): Boolean = someInstructor.id == instructor.id

  def copyCourse(newReleaseYear: String) = new Course(courseID, title, newReleaseYear, instructor)
}