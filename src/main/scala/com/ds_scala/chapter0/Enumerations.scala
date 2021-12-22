package com.ds_scala.chapter0

object Enumerations extends App{



}

object WeekDay extends Enumeration {
  type WeekDay = Value

  val Sun = Value("Sunday")
  val Mon = Value("Monday")
  val Tue =  Value("Tuesday")
  val Wed =  Value("Wednesday")
  val Thu =  Value("Thursday")
  val Fri =  Value("Friday")

}


