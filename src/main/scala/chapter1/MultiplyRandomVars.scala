package chapter1

import breeze.linalg.DenseVector
import breeze.stats.{mean, variance}


object MultiplyRandomVars extends App{

  val N_EXPERIMENTS = 100000

  val binomial = breeze.stats.distributions.Binomial(10, 0.5)

  // The simulation should agree with this
  println(s"Pr(X=5)=${binomial.probabilityOf(5)}")

  val X = DenseVector.zeros[Double](N_EXPERIMENTS)

  for(i <- 0 until N_EXPERIMENTS){

    val sample = binomial.sample()
    X(i) = sample
  }

  // this should be close to 5 i.e E[X] = size * p = 10 * 0.5
  println(s"Average of flips ${mean(X)}")

  // Var[X] = size * p * (1-p)
  println(s"Variance of flips ${variance(X)}")

  // define a new random variable
  val Y = 3.0 * X

  // this should be close to 5 i.e E[X] = size * p = 10 * 0.5
  println(s"Average of Y ${mean(Y)}")

  // Var[X] = size * p * (1-p)
  println(s"Variance of Y ${variance(Y)}")

}
