package com.ds_scala.chapter0

import breeze.linalg.DenseVector

object ScalaExp1 extends App{

  var vector  = DenseVector.zeros[Double](10)

  // collect all the even number in the
  // [0, 9) interval
  val seq = (0 until 9).map { n =>
    if(n % 2 == 0){
      n
    }
    else {
      0
    }
  }


  println(seq)


}
