package AoC_16.Task5

object md5password extends App {
  val doorId = "ugkcyxxp"
  var index = 0
  var password = ""

  while (password.length < 8) {
    val testValue = doorId + index
    val hash = md5HashString(testValue).reverse.padTo(32, '0').reverse
    if (hash.take(5) == "00000") {
      println(hash)
      password = password + hash(5)
      println(password)
    }
    index += 1
  }
  println(password)

  def md5HashString(s: String): String = {
    import java.security.MessageDigest
    import java.math.BigInteger
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(s.getBytes)
    val bigInt = new BigInteger(1, digest)
    val hashedString = bigInt.toString(16)
    hashedString
  }

}
