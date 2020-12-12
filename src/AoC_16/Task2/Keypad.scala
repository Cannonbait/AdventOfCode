package AoC_16.Task2

import scala.io.Source
import scala.util.Using

object Keypad extends App {
  val filename = "src/AoC_16/Task2/input"
  val keypad = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
  var index = (1, 1)

  Using(Source.fromFile(filename)) { reader => {
    for (line <- reader.getLines) {
      for (i <- 0 until line.length) {
        val dir = line(i)
        if (dir == 'U' && index._2 > 0) {
          index = (index._1, index._2 - 1)
        } else if (dir == 'D' && index._2 < 2) {
          index = (index._1, index._2 + 1)
        } else if (dir == 'L' && index._1 > 0) {
          index = (index._1 - 1, index._2)
        } else if (dir == 'R' && index._1 < 2) {
          index = (index._1 + 1, index._2)
        }
      }
      print(keypad(index._2)(index._1))
    }
  }
  }
}
