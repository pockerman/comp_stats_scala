package chapter1

import breeze.linalg.DenseVector
import breeze.plot.{Figure, hist}
import breeze.stats.{mean, variance}

object AddRandomVars extends App {

  val N_EXPERIMENTS = 100000

  // create a figure
  val f = Figure()

  val binom_X = breeze.stats.distributions.Binomial(10, 0.5)
  val binom_Y = breeze.stats.distributions.Binomial(100, 0.2)

  val X = DenseVector.zeros[Double](N_EXPERIMENTS)
  val Y = DenseVector.zeros[Double](N_EXPERIMENTS)

  for(i <- 0 until N_EXPERIMENTS){

    val sample_x = binom_X.sample()
    X(i) = sample_x

    val sample_y = binom_Y.sample()
    Y(i) = sample_y

  }

  // this should be close to 5 i.e E[X] = size * p = 10 * 0.5
  println(s"Average of X ${mean(X)}")

  // Var[X] = size * p * (1-p)
  println(s"Variance of X ${variance(X)}")


  val p = f.subplot(0)

  p += hist(X,20)


  // this should be close to 5 i.e E[X] = size * p = 10 * 0.5
  println(s"Average of Y ${mean(Y)}")

  // Var[X] = size * p * (1-p)
  println(s"Variance of Y ${variance(Y)}")

  p += hist(Y,20)

  // define a new random variable
  val Z =  X + Y

  // this should be close to 5 i.e E[X] = size * p = 10 * 0.5
  println(s"Average of Z ${mean(Z)}")

  // Var[X] = size * p * (1-p)
  println(s"Variance of Z ${variance(Z)}")

  p += hist(Z,20)

  f.refresh()

}
