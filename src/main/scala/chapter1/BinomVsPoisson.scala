package chapter1

import breeze.linalg.DenseVector
import breeze.plot.{Figure, hist}

object BinomVsPoisson extends App{

  val N_EXPERIMENTS = 100000

  // create a figure
  val f = Figure()

  val binom_X = breeze.stats.distributions.Binomial(1000, 1.0/1000)
  val poisson_y = breeze.stats.distributions.Poisson(1.0)

  val X = DenseVector.zeros[Double](N_EXPERIMENTS)
  val Y = DenseVector.zeros[Double](N_EXPERIMENTS)
  for(i <- 0 until N_EXPERIMENTS){

    val sample_x = binom_X.sample()
    X(i) = sample_x

    val sample_y = poisson_y.sample()
    Y(i) = sample_y
  }

  val p = f.subplot(0)

  p += hist(X,20)
  p += hist(Y,20)

  f.refresh()

}
