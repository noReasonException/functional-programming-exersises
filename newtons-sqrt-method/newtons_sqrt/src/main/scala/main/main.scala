package main

object main {

  def isGoodEnough(guess:Double, number:Double,precision:Double):Boolean = Math.abs(guess-improve(guess,number)) < precision
  def improve(guess:Double, number:Double):Double = (guess + (number/guess))/2

  def sqrtIter(guess:Double, number:Double, precision:Double):Double=
    if(isGoodEnough(guess,number,precision))guess
    else sqrtIter(improve(guess,number),number,precision)

  def main(args: Array[String]): Unit = {
    println(sqrtIter(1,2,0.00001))
  }
}
