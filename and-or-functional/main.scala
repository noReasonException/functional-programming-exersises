




object main{
  def and(x:Boolean,y:Boolean):Boolean= if(x) y else false
  def or(x:Boolean,y:Boolean):Boolean= if(x) true else y

  def main(args: Array[String]): Unit = {
    /*if(and(true,true))println("true true OK")
    if(and(true,false))println("true false FAIL")
    if(and(false,true))println("false true FAIL")
    if(and(false,false))println("false false FAIL")*/

    if(or(true,true))println("true true OK")
    if(or(true,false))println("true false OK")
    if(or(false,true))println("false true OK")
    if(or(false,false))println("false false FAIL")

  }


}