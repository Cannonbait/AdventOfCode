package AoC_16.Task7

import scala.io.Source
import scala.util.Using

object abba extends App {

  val filename = "src/AoC_16/Task7/testInput"

  val sum = 0

  Using(Source.fromFile(filename)) { reader =>
    {
      println(
        reader
          .getLines()
          .map(line =>
            line
              .split("\\[|\\]")
              .zipWithIndex
              .map(x => (x._2 % 2, containsAbba(x._1) == (x._2 % 2 == 0)))
              .groupBy(_._1)
              .map(x => {
                if (x._1 == 0) {
                  x._2.exists(x => x._2)
                } else {
                  x._2.forall(x => x._2)
                }
              })
          )
      )
    }
  }

  def containsAbba(s: String): Boolean = {
    s.iterator
      .sliding(4)
      .exists(seq =>
        seq.head == seq(3) && seq(1) == seq(2) && seq.head != seq(1)
      )
  }
}
