package chapter1

import breeze.linalg.DenseVector
import breeze.plot.{Figure, hist}

object SimulateWaitingForHeads extends App {

  val N_EXPERIMENTS = 100
  val binom_X = breeze.stats.distributions.Binomial(1, 0.1)

  val X = DenseVector.zeros[Double](N_EXPERIMENTS)

  for(i <- 0 until N_EXPERIMENTS){

    val sample_x = binom_X.sample()
    X(i) = sample_x
  }

  println(X)

  // get the positions where X is head
  println(X.findAll(x => x == 1.0))

  // we can use the Geometric distribution

  val geom_Y = breeze.stats.distributions.Geometric( 0.1)

  val Y = DenseVector.zeros[Double](N_EXPERIMENTS)

  for(i <- 0 until N_EXPERIMENTS){

    val sample_y = geom_Y.sample()
    Y(i) = sample_y
  }

  // create a figure
  val f = Figure()
  val p = f.subplot(0)

  p += hist(Y,20)

  f.refresh()
}
