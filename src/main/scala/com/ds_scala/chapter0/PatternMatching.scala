package com.ds_scala.chapter0

object PatternMatching extends App{

  val seq = Seq(1, 2, 3.14, 5.5F, "one", "four", true, (6, 7))

  val result = seq.map{
    case 1 => "int 1"
    case i: Int => s"other int $i"
    case d: Double  => s"a double: $d"
    case f: Float  => s"a float: $f"
    case  "one" => "string one"
    case s: String => s"other string $s"
    case (x, y) => s"tuple: ($x, $y)"
    case unexpected => s"unexpected value $unexpected"
  }

  println(result)

}
