package lectures.week3fp

object PartialFunctions extends App {
  val whatToDo = (d: String) => d match {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }

  val aPartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }
  println(aPartialFunction.isDefinedAt("tue")) // false

  val pfChain: PartialFunction[String, String] = aPartialFunction.orElse[String, String] {
    case "sat" => "It's just Saturday"
  }

  val lifted = aPartialFunction.lift // теперь на выходе имеем тип Option[String]

  println(lifted("fri")) // Some(Party Time)
  println(lifted("thu")) // None

  val chatFunction: PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }
  val chatbot = chatFunction.lift

  println(chatbot("hello"))
//  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
  def compare(v1: String, v2: String): Int = {

    v1.split("\\.").zipAll(v2.split("\\."), "0", "0")
      .find {case(a, b) => a != b }
      .fold(0) { case (a, b) => a.toInt - b.toInt }
  }
  println(compare("1.0.2.03", "1.1.0"))
}
