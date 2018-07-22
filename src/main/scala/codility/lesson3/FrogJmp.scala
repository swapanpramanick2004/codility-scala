package codility.lesson3

object FrogJmp extends App {

  def solution(x: Int, y: Int, d: Int) = Math.ceil((y - x)*1.0/d).toInt

  println(solution(1, 5, 2))
}
