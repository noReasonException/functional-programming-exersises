import cats.syntax.functor._
import cats.instances.int._

object main{
  def main(args: Array[String]): Unit = {

    val tree:Tree[Int] = Branch(Branch(Leaf(1),Leaf(2)),Leaf(12))

    println(tree.map(_+1))
  }
}


