package codility.lesson4

import scala.annotation.tailrec
import scala.collection.immutable.{HashSet => ImmutableSet}

object FrogRiverOne extends App {

  def solution(x:Int, a:Array[Int]):Int = {
    val len = a.length
    val xSum = (x/2.0)*(x+1)
    @tailrec
    def solve(cur:Int, xRest:Double, positions:ImmutableSet[Int]):Int = {
      if (cur >= len)
        -1
      else if (positions.contains(a(cur)))
        solve(cur + 1, xRest, positions)
      else if (xRest - a(cur) > 0)
        solve(cur + 1, xRest - a(cur), positions + a(cur))
      else
        cur
    }

    solve(0, xSum, new ImmutableSet[Int]())

  }

  println(solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)))
  println(solution(2, Array(1, 2)))
  println(solution(5, Array(1, 3, 1, 4, 2, 3, 3, 4)))
}
