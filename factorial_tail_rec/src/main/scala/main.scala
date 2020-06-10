import scala.annotation.tailrec

object main{

  def factorial(n:Int):Int=
    if(n==0)1 else n*factorial(n-1)

  @tailrec
  def factorial_tail_rec(n:Int,sum:Int):Int=
    if(n==0) sum else factorial_tail_rec(n-1,sum*n)

  def main(args: Array[String]): Unit = {
    println(factorial_tail_rec(5,1))
  }
}