package main

object main{
  def main (args: Array[String] ): Unit = {
    import Printable._
    import PrintableInstances._
    print(Box("12").format())
  }

}
trait Printable[A]{
  self=>
  def format(value:A):String

  def contramap[B](func: B => A): Printable[B] = {
    new Printable[B] {
      override def format(value: B): String =self.format(func(value))
    }
  }
}

final case class Box[A](value:A)

object PrintableInstances{
  implicit val StringPrintable:Printable[String]={
    new Printable[String] {
      override def format(value: String): String = value
    }
  }
  implicit val BooleanPrintable:Printable[Boolean]={
    new Printable[Boolean] {
      override def format(value: Boolean): String = if(value)"yes" else "No"
    }
  }
  implicit def BoxedPrintable[A](implicit printable: Printable[A]):Printable[Box[A]]={
    printable.contramap(_.value)
  }

}
object Printable{
  implicit class Ops[A](v:A){
    def format()(implicit printable: Printable[A]):String=printable.format(v)
  }
}