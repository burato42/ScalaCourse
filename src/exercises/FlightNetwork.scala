package exercises

import scala.annotation.tailrec


object FlightNetwork {
  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    //    if (network contains location) network
    //    else network updated (location, Set.empty)
    network + (location -> Set())
  }

  def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    @tailrec
    def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (destinations.isEmpty) acc
      else loop(destinations.tail, disconnect(acc, location, destinations.head))

    val disconnected = loop(network(location), network)
    disconnected - location
  } /

  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)
    network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
  }

  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)
    network + (pointA -> (routesForA - pointB)) + (pointB -> (routesForB - pointA))
  }

  def nFlights(network: Map[String, Set[String]], location: String): Int = network(location).size

  def mostFlights(network: Map[String, Set[String]]): String = network.maxBy(_._2.size)._1

  def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = network.count(_._2.isEmpty)

  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {
    @tailrec
    def bfs(target: String, considered: Set[String], discovered: Set[String]): Boolean = {
      if (discovered.isEmpty) false
      else {
        val point = discovered.head
        if (point == target) true
        else if (considered.contains(point))
          bfs(target, considered, discovered.tail)
        else bfs(target, considered + point, discovered.tail ++ network(point))
      }
    }

    bfs(pointB, Set(), network(pointA) + pointA)
  }
}
