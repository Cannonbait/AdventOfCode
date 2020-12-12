package AoC_16.Task1

import scala.io.Source
import scala.util.Using
import scala.util.control.Breaks.{break, breakable}

object AllDone extends Exception {}

object TheFirst_2 extends App {
  val filename = "src/AoC_16/Task1/input"
  var loc = (0, 0)
  var dir = Direction.NORTH
  var locations = Set((0, 0))

  breakable {
    Using(Source.fromFile(filename)) { reader => {
      for (line <- reader.getLines) {
        for (instruction <- line.split(", ")) {
          if (instruction.charAt(0) == 'R') {
            dir = Direction.turnRight(dir)
          } else if (instruction.charAt(0) == 'L') {
            dir = Direction.turnLeft(dir)
          }
          val stepSize = instruction.substring(1).toInt
          for (_ <- 1 to stepSize) {
            if (dir == Direction.NORTH) {
              loc = (loc._1, loc._2 + 1)
            } else if (dir == Direction.EAST) {
              loc = (loc._1 + 1, loc._2)
            } else if (dir == Direction.SOUTH) {
              loc = (loc._1, loc._2 - 1)
            } else {
              loc = (loc._1 - 1, loc._2)
            }
            if (locations.contains(loc)) {
              println(loc._1.abs + loc._2.abs)
              break
            }
            locations = locations + loc
          }
        }
      }
    }
    }
  }
}
