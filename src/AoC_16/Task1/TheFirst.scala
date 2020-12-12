package AoC_16.Task1

import scala.io.Source
import scala.util.Using


object TheFirst extends App {
  val filename = "src/AoC_16/Task1/input"
  var loc = (0, 0)
  var dir = Direction.NORTH

  Using(Source.fromFile(filename)) { reader => {
    for (line <- reader.getLines) {
      for (instruction <- line.split(", ")) {
        if (instruction.charAt(0) == 'R') {
          dir = Direction.turnRight(dir)
        } else if (instruction.charAt(0) == 'L') {
          dir = Direction.turnLeft(dir)
        }
        val stepSize = instruction.substring(1).toInt
        if (dir == Direction.NORTH) {
          loc = (loc._1, loc._2 + stepSize)
        } else if (dir == Direction.EAST) {
          loc = (loc._1 + stepSize, loc._2)
        } else if (dir == Direction.SOUTH) {
          loc = (loc._1, loc._2 - stepSize)
        } else {
          loc = (loc._1 - stepSize, loc._2)
        }
      }
    }
    println(loc._1.abs + loc._2.abs)
  }
  }
}