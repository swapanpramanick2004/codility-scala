package codility.lesson4

import scala.annotation.tailrec
import scala.collection.mutable.HashSet

object PermCheck extends App {

  def solution(a:Array[Int]):Int = {
    @tailrec
    def sumNUnique(cur:Int, sum:Double, unique:HashSet[Int]):Double = if (cur < 0) sum else sumNUnique(cur - 1, sum + a(cur), unique+=a(cur))

    val n = a.length
    val unique = new HashSet[Int]
    val sum = sumNUnique(n - 1, 0, unique)
    if (unique.size == n && ((n / 2.0)*(n + 1) - sum).intValue() == 0) 1 else 0
  }

  println(solution(Array(4, 2, 2, 2)))
}
