package lectures.week3fp

object Patterns extends App {
  val nameBindingMatch = List(6, 2) match {
    case nonEmptyList@List(1, _, _, _) => s"нашли $nonEmptyList"
    case someList@List(6, _*) => s"нашли список $someList"
  }

  println(nameBindingMatch) // нашли список List(6, 2)

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of integers"
    case _ => "default case"
  }
//  val numbersMatch = numbers match {
//    case listOfStrings: List => "a list of strings"
//    case listOfNumbers: List => "a list of integers"
//    case _ => "default case"
//  }
  println(numbersMatch)

  def guard(data: Any, maxLength: Int): String = {
//    Задан список List допустимой длины
//    Длина списка больше максимально допустимого значения
//      Длина строки не превышает максимально допустимого значения
//    Получена строка недопустимой длины
//      Что это? Это не строка и не список
    data match {
      case list: List[Any] if list.length <= maxLength => "Задан список List допустимой длины"
      case list: List[Any] if list.length > maxLength => "Длина списка больше максимально допустимого значения"
      case str: String if str.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
      case str: String if str.length > maxLength => "Получена строка недопустимой длины"
      case _ => "Что это? Это не строка и не список"
    }
  }
}
