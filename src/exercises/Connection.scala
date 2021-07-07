package exercises

class Connection {
  def connect(host: String, port: String) = ???
}

object Connection {
  def apply(host: String, port: String): Option[Connection] = ???
}