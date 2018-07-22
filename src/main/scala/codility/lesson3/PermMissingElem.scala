package codility.lesson3

import scala.annotation.tailrec
import scala.util.Random

object PermMissingElem extends App {

  def solution(a: Array[Int]): Int = {
    @tailrec
    def sumN(cur:Int, sum:Double):Double = if (cur < 0) sum else sumN(cur - 1, sum + a(cur))
    val n = a.length
    val sumExpected = ((n+1)/2.0)*(n+2)
    val sumActual = sumN(n - 1, 0)
    //println(sumExpected)
    //println(sumActual)
    (sumExpected - sumActual).toInt
  }

  // Small test case
  println(solution(Array(1, 3, 2, 7, 6, 8, 5)))

  // To create large test case
  val n = 1000001
  val r = new Random().nextInt(n)
  @tailrec
  def generate(n:Int, list:List[Int]):List[Int] = if ( n == r) generate(n - 1, list) else if (n >= 0) generate(n - 1, n::list) else list

  val list = generate(n, Nil)
  println(solution(list.toArray))
}
