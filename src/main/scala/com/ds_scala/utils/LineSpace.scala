package com.ds_scala.utils

import breeze.linalg.DenseVector

object LineSpace {

  /**
   * Partition the interval [a, b] into n parts
   * @param a start of interval
   * @param b end of interval
   * @param n Number of parts
   * @return The discretized points
   */
  def partition(a: Double, b: Double, n: Int): DenseVector[Double] = {

    require(a < b)
    require( n > 2)
    val points: DenseVector[Double] = DenseVector.zeros[Double](n)

    val dx = (b - a)/n
    points(0) = a
    points(n-1) = b
    for(p <- 1 to n - 2){
      points(p) = a + p*dx
    }

    points
  }

  def partitionWithWhiteNoise(a: Double, b: Double, n: Int) : DenseVector[Double] = {

    require(a < b)
    require( n > 2)
    val points: DenseVector[Double] = DenseVector.zeros[Double](n)
    val g = breeze.stats.distributions.Gaussian(0,1)

    val dx = (b - a)/n
    points(0) = a
    points(n-1) = b
    for(p <- 1 to n - 2){
      points(p) = a + p*dx + g.sample()
    }

    points

  }
}
