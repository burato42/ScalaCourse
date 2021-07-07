package exercises

abstract class GenericList[+A] {
  def last: A // возвращает последнее поступившее сообщение (иначе говоря - head списка)
  def previous: GenericList[A]// возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
  def isEmpty: Boolean // проверяет, если ли в нашем списке сообщения
  def all: String // предоставляет нам содержимое нашего списка в виде строки
  def add[B >: A](msg: B): GenericList[B] // добавляет сообщение в список
}

class Log[+A](head: A, tail: GenericList[A]) extends GenericList[A] {
  override def last: A = head

  override def previous: GenericList[A] = tail

  override def isEmpty: Boolean = false

  override def all: String = head.toString + " " + tail.all

  override def add[B >: A](msg: B): GenericList[B] = new Log(msg, this)
}

object Empty extends GenericList[Nothing] {
  override def last: Nothing = throw new NoSuchElementException

  override def previous: Nothing = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def all: String = ""

  override def add[B >: Nothing](msg: B): GenericList[B] = new Log(msg, Empty)
}


object GenericList extends App {
  val log = new Log("m1", new Log("m2", new Log("m3", Empty)))
  println(log.all)
  val log1 = new Log(1, new Log(2, new Log(3, Empty)))
  println(log1.all)
}