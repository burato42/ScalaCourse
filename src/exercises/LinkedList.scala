package exercises

abstract class LogListStr {
  def last: String // возвращает последнее поступившее сообщение (иначе говоря - head списка)
  def previous: LogListStr// возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
  def isEmpty: Boolean // проверяет, если ли в нашем списке сообщения
  def all: String // предоставляет нам содержимое нашего списка в виде строки
  def add(msg: String): LogListStr // добавляет сообщение в список
}

class LogStr(head: String, tail: LogListStr) extends LogListStr {
  override def last: String = head

  override def previous: LogListStr = tail

  override def isEmpty: Boolean = false

  override def all: String = head + " " + tail.all

  override def add(msg: String): LogListStr = new LogStr(msg, this)
}

object EmptyStr extends LogListStr {
  override def last: Nothing = throw new NoSuchElementException

  override def previous: Nothing = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def all: String = ""

  override def add(msg: String): LogListStr = new LogStr(msg, EmptyStr)
}


object LinkedList extends App {
  val log = new LogStr("m1", new LogStr("m2", new LogStr("m3", EmptyStr)))
  println(log.all)
}