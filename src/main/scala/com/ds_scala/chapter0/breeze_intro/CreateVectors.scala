package com.ds_scala.chapter0.breeze_intro
import breeze.linalg.{DenseVector, SparseVector}


object CreateVectors extends App{

  val dense=DenseVector(1,2,3,4,5)
  val sparse=SparseVector(0.0, 1.0, 0.0, 2.0, 0.0)

  val denseZeros=DenseVector.zeros[Double](size = 5)
  val sparseZeros=SparseVector.zeros[Double](size = 5)

  val denseTabulate=DenseVector.tabulate[Double](size =5)(index=>index*index)

  val spaceVector=breeze.linalg.linspace(2, 10, length = 5)

  val allNosTill10=DenseVector.range(0, 10)

  val evenNosTill20=DenseVector.range(0, 20, 2)

  val rangeD=DenseVector.rangeD(0.5, 20, 2.5)

  val denseJust2s=DenseVector.fill(10, 2)



  val fourThroughSevenIndexVector= allNosTill10.slice(4, 7)

  val twoThroughNineSkip2IndexVector= allNosTill10.slice(2, 9, 2)

  val vectFromArray=DenseVector(collection.immutable.Vector(1,2,3,4))

}
