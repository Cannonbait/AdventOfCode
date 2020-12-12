package AoC_16.Task3

import scala.io.Source
import scala.util.Using

object Triangle extends App {
  val filename = "src/AoC_16/Task3/input"
  var possible = 0

  Using(Source.fromFile(filename)) { reader => {
    for (line <- reader.getLines) {
      val values = line.trim.split("\\s+").map(line => line.toInt).sorted
      if (values(0) + values(1) > values(2)) {
        possible += 1
      }
    }
  }
  }
  println(possible)
}
