package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
//  class Multiplication {
//    def multiply(x: Int): Int = x * 2
//  }
  trait Multiplication[A, B] {
    def apply(x: A): B
  }
  val res = new Multiplication[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }
  println(res(2))

  val product = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }
  println(product(3, 4) ) // выводит 12

  val product1: (Int, Int) => Int = _ * _
  println(product1(3, 5))

//  val strlen: String => Int = x => x.length
  val strlen = (x: String) => x.length
  println(strlen("Hello World"))

  @tailrec
  def nTimes(f: Int => Int, x: Int,  n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }
  val increment = (x: Int) => x + 1
  println(nTimes(increment, 0, 3))

//  def add(x: Int) = (y: Int) => x + y
  def add(x: Int)(y: Int) = x + y
  println(add(1)(2))

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n-1)(f(x))
  }
  println(curryingNTimes(increment, 3)(0))

//  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
//    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
//      override def apply(y: Int): Int = x + y
//    }
//  }
  def someFunc = (x: Int) => (y: Int) => x + y

  println(someFunc(1))
}
