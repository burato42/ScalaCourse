package lectures.week3fp

import scala.io.StdIn.readLine

object Person {
//  def main(args: Array[String]): Unit = {
//    val input: String = readLine()
//    if (input != null && input.nonEmpty) {
//      val person = unapply(input)
//      println(person.getOrElse("Oops, something is wrong"))
//    } else {
//      println("Oops, something is wrong")
//    }
//  }

  def apply(firstName: String, lastName: String): String = s"$firstName $lastName"

  def unapply(str: String): Option[String] = {
    val parts = str.split("\\s")

    parts match {
      case Array(x, y) => Some(s"${x(0).toUpper}. ${y(0).toUpper}.")
      case _ => None
    }
  }

}

object Initials extends App {
  val input: String = readLine()
  try {
    val Person(name) = input
    println(name)
  } catch {
    case _: MatchError => println("Oops, something is wrong")
  }

}