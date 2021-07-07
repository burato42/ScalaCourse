package exercises

class Logger(val msgNum: Int = 0) {
  def info: Logger = {
    println("INFO New Message")
    new Logger(msgNum + 1)
  }

  def info(cnt: Int): Logger = {
      if (cnt <= 0) this
      else info.info(cnt - 1)
  }

  def print(): Unit = println(msgNum)
}

object LogSystem extends App{
  val logger = new Logger
  logger.info.print
  logger.info.info.info.print
  logger.info.info.info.print
}
