import cats.Functor

sealed trait Tree[+A]

final case class Branch[A](left:Tree[A],right: Tree[A]) extends Tree[A]{
  override def toString: String = "Left("+left.toString+"),Right("+right.toString+")"
}

final case class Leaf[A](value:A)extends Tree[A]{
  override def toString: String = value.toString
}


object Tree{
  implicit val treeFunctor:Functor[Tree]={
    new Functor[Tree] {
      override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] =
        fa match {
          case Branch(left, right) => Branch(treeFunctor.map(left)(f),treeFunctor.map(right)(f))
          case Leaf(value) =>Leaf(f(value))
        }
    }
  }
}