package AoC_16.Task4

import scala.io.Source
import scala.util.Using

object Checksum extends App {
  val filename = "src/AoC_16/Task4/input"
  var sum = 0

  Using(Source.fromFile(filename)) { reader => {
    for (line <- reader.getLines) {
      var letterCounts: Map[String, Int] = Map.empty
      val checksum = (line.takeRight(7).substring(1, 6))
      val groups = line.dropRight(7).split("-")
      val id = groups.takeRight(1).head.toInt
      val letters = groups.dropRight(1).mkString("").sorted
      for (unique <- letters.distinct) {
        val count = letters.count(_ == unique)
        letterCounts += unique.toString -> count
      }
      val calcCheckSum = letterCounts.groupBy(_._2).map(x => (x._1, x._2.keys.mkString("").sorted)).toSeq.sortBy(_._1).reverse.map(_._2).mkString("").take(5)
      if (checksum == calcCheckSum) {
        sum += id
      }
    }
    println(sum)
  }
  }
}
