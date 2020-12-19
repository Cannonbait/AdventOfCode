package AoC_16.Task5

import AoC_16.Task5.md5password.md5HashString

object md5password_2 extends App {
  val doorId = "ugkcyxxp"
  var index = 0
  var password: List[Char] = List.fill(8)('x')
  while (password.contains('x')) {
    val testValue = doorId + index
    val hash = md5HashString(testValue).reverse.padTo(32, '0').reverse
    val hashIndex = hash(5)
    if (
      hash.take(
        5
      ) == "00000" && hashIndex.isDigit && hashIndex.toString.toInt < 8 && password(
        hashIndex.toString.toInt
      ) == 'x'
    ) {
      password = password.updated(hash(5).toString.toInt, hash(6))
    }
    index += 1
  }
  println(password.mkString(""))

}
