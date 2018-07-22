import scala.annotation.tailrec

object OddOccurrencesInArray extends App {

  def solution(a:Array[Int]):Int = {
    @tailrec
    def solve(cur:Int, odd:Int):Int = if (cur < 0) odd else solve(cur - 1, odd ^ a(cur))

    solve(a.length - 1, 0)
  }

  println(s"Odd Element: ${solution(Array(9, 7, 9, 8, 3, 9, 9, 7, 3))}")
}
