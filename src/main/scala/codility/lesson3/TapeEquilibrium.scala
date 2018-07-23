package codility.lesson3

import scala.annotation.tailrec

object TapeEquilibrium extends App {

  def solution(a: Array[Int]): Int = {

    // internal method for calculating sum
    @tailrec
    def sumN(cur:Int, sum:Double):Double = if (cur < 0) sum else sumN(cur - 1, sum + a(cur))

    // internal recursive method for the solution
    @tailrec
    def solve(p:Int, leftSum:Double, rightSum:Double, min:Double):Double = {
      if (p == 0) min
      else {
        val newleftSum = leftSum - a(p)
        val newRightSum = rightSum + a(p)
        val diff = Math.abs(newleftSum - newRightSum)
        println(s"[${p}] LeftSum: ${newleftSum}; RightSum: ${newRightSum}; min: ${min}; diff: ${diff}")
        if (diff < min)
            solve(p - 1, newleftSum, newRightSum, diff)
        else
            solve(p - 1, newleftSum, newRightSum, min)
      }
    }

    val last = a.length - 1
    val sum = sumN(last, 0)
    // putting sum as initial value of min as that can be maximum diff possible
    val rightSum = a(last)
    val leftSum = sum - a(last)
    solve(last - 1, leftSum, rightSum, Math.abs(leftSum - rightSum)).intValue()
  }

  //Example test:
  val data1 = Array(3, 1, 2, 4, 3)
  println(s"Min sum is ${solution(data1)}")

  //Double
  val data2 = Array(-26789, 9512)
  println(s"Min sum is ${solution(data2)}")

  //Negative values
  val data3 = Array(3, -1, 2, -4, 3)
  println(s"Min sum is ${solution(data3)}")
}
