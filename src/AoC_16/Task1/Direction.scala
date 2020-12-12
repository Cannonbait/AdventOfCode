package AoC_16.Task1

object Direction extends Enumeration {
  type Direction = Value
  val NORTH, EAST, SOUTH, WEST = Value


  def turnRight(dir: Direction): Direction = {
    if (dir == Direction.NORTH) {
      Direction.EAST
    } else if (dir == Direction.EAST) {
      Direction.SOUTH
    } else if (dir == Direction.SOUTH) {
      Direction.WEST
    } else {
      Direction.NORTH
    }
  }

  def turnLeft(dir: Direction): Direction = {
    if (dir == Direction.NORTH) {
      Direction.WEST
    } else if (dir == Direction.WEST) {
      Direction.SOUTH
    } else if (dir == Direction.SOUTH) {
      Direction.EAST
    } else {
      Direction.NORTH
    }
  }
}
