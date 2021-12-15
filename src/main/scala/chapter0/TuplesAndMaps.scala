package chapter0

object TuplesAndMaps extends App{

  val aTuple = new Tuple2(2, "Hell Scala")
  println(aTuple._1)

  val anotherTuple = (2, "Hello World")

  println(anotherTuple.copy(_2 = "Goodbye Java"))

  // Maps = key -> values

  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  println(phoneBook)
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))

  // will prin the default value as Mary not in the
  // phone book
  println(phoneBook("Mary"))

  // add Mary to the phone book
  val maryNumber = ("Mary", 999)

  // new phone book because maps are immutable
  val newPhoneBook = phoneBook + maryNumber

  // functionals: map, flatMap, filter
  println(phoneBook.map( item => item._1.toLowerCase -> item._2))

  // filter only get Jim -> 555
  println(phoneBook.filterKeys(_.startsWith("J")))

  // mapValues
  println(phoneBook.mapValues(number => number * 10))

  // conversions

  // toList
  println(phoneBook.toList)

  // toMap
  println(List(("Daniel", 555)).toMap)

  // groupBy
  val names = List("Bob", "Angela", "Alex", "James", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
