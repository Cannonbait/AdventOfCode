package AoC_16.Task2

import scala.io.Source
import scala.util.Using

object Keypad_2 extends App {
  val filename = "src/AoC_16/Task2/input"
  val keypad = List(List("N", "N", 1, "N", "N"), List("N", 2, 3, 4, "N"), List(5, 6, 7, 8, 9), List("N", "A", "B", "C", "N"), List("N", "N", "D", "N", "N"))
  var index = (0, 2)

  Using(Source.fromFile(filename)) { reader => {
    for (line <- reader.getLines) {
      for (i <- 0 until line.length) {
        val dir = line(i)
        if (dir == 'U' && index._2 > 0 && keypad(index._2 - 1)(index._1) != "N") {
          index = (index._1, index._2 - 1)
        } else if (dir == 'D' && index._2 < 4 && keypad(index._2 + 1)(index._1) != "N") {
          index = (index._1, index._2 + 1)
        } else if (dir == 'L' && index._1 > 0 && keypad(index._2)(index._1 - 1) != "N") {
          index = (index._1 - 1, index._2)
        } else if (dir == 'R' && index._1 < 4 && keypad(index._2)(index._1 + 1) != "N") {
          index = (index._1 + 1, index._2)
        }
      }
      print(keypad(index._2)(index._1))
    }
  }
  }
}
