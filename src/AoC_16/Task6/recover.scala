package AoC_16.Task6

import scala.io.Source
import scala.util.Using

object recover extends App {

  val filename = "src/AoC_16/Task6/input"

  val columnLetters: List[StringBuilder] = List.fill(8)(new StringBuilder())

  Using(Source.fromFile(filename)) { reader =>
    {
      reader
        .getLines()
        .foreach(line =>
          line.zipWithIndex
            .foreach(letter => columnLetters(letter._2).addOne(letter._1))
        )
    }
  }
  println(
    columnLetters
      .map(col => col.result())
      .flatMap(str =>
        str.distinct
          .map(unique => (unique, str.count(_ == unique)))
          .sortBy(_._2)
          .reverse
          .take(1)
          .map(_._1)
      )
      .mkString("")
  )
  println(
    columnLetters
      .map(col => col.result())
      .flatMap(str =>
        str.distinct
          .map(unique => (unique, str.count(_ == unique)))
          .sortBy(_._2)
          .take(1)
          .map(_._1)
      )
      .mkString("")
  )
}
