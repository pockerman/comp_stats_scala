package com.ds_scala.chapter0

object ForLoops extends App{

  // print integers [0, 5)
  for(i <- 0 until 5)
    println(i)

  println("\n")

  // print integers [0, 5]
  for(i <- 0 to 5)
    println(i)

  println("\n")
  // Generators
  // The left arrow <- is used to iterate through any
  // instance that supports iterative access to elements
  // e.g. Seq, Vecto

  for( i <- Set(0, 2, 1, 2, 3, 4, 5, 5))
    println(i)


  println("\n")

  // using yield
  // We can turn the for expressions into for comprehensions

  val evens = for(i <- 0 to 10 if i%2 ==0)  yield i //if(i % 2 == 0) yield i

  println(evens)

  println()

  // define an enumeration
 // val dayOps = Seq(Some(WeekDay.Mon), None, Some(WeekDay.Tue), Some(WeekDay.Wed),
 //   None, Some(WeekDay.Thu), Some(WeekDay.Fri), Some(WeekDay.Sun))

  // filter the day ops so that we don't
  // have None The syntax below requires Scala 3.0
  //val goodDays = for(case Some(day) <- dayOps)
  // fn = day.fullName
  // yield fn

}

/*object WeekDay extends Enumeration {
  //type WeekDay = Value

  val Sun = Value("Sunday")
  val Mon = Value("Monday")
  val Tue =  Value("Tuesday")
  val Wed =  Value("Wednesday")
  val Thu =  Value("Thursday")
  val Fri =  Value("Friday")

}*/
