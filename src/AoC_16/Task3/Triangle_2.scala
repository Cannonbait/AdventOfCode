package AoC_16.Task3

import scala.::
import scala.io.Source
import scala.util.Using

object Triangle_2 extends App {
  val filename = "src/AoC_16/Task3/input"

  var possible = 0

  var firstColumn: List[Int] = List()
  var secondColumn: List[Int] = List()
  var thirdColumn: List[Int] = List()

  Using(Source.fromFile(filename)) { reader => {
    for (line <- reader.getLines) {
      val values = line.trim.split("\\s+").map(line => line.toInt)
      firstColumn = values(0) :: firstColumn
      secondColumn = values(1) :: secondColumn
      thirdColumn = values(2) :: thirdColumn
    }
  }
  }

  println(groupAndSum(firstColumn.reverse)+groupAndSum(secondColumn.reverse)+groupAndSum(thirdColumn.reverse))

  def groupAndSum(items: List[Int]): Int = {
    var possible = 0
    items.grouped(3).foreach(values => {
      val sorted = values.sorted
      if (sorted.head + sorted(1) > sorted(2)) {
        possible += 1
      }
    })
    possible
  }
}
