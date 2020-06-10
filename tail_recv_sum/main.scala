object main {
  /*
def sum(f:Int=>Int,a:Int,b:Int):Int=
  if(a>b)0
  else f(a)+sum(f,a+1,b)*/


  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }

    loop(a, 0)
  }


  def sumInts(a: Int, b: Int): Int = sum(id)(a, b)


  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def main(args: Array[String]): Unit = {
    println(sumInts(0, 10000))
  }
}
