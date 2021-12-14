package chapter5

import breeze.linalg.DenseVector
import breeze.stats._
import breeze.plot.{Figure, hist}

object SamplingDistribution extends App{

  // as the number of samples
  // approaches infinity the sampling
  // distribution should approach Gauss
  val N_SAMPLES = 1000
  val SAMPLE_SIZE = 30
  val gauss = breeze.stats.distributions.Gaussian(3.5, 1.25)

  val means = DenseVector.zeros[Double](N_SAMPLES)

  for(i  <- 0 until N_SAMPLES) {
    val data = gauss.sample(SAMPLE_SIZE)

    means(i) = mean(data)
  }

  // plot the distribution of the means
  // i.e. the sampling distribution

  val fig = Figure()

  //  Let's add a plot to our figure:
  val plt = fig.subplot(0)

  val g = breeze.stats.distributions.Gaussian(3.5, 1.25)

  plt += hist(means, 30)
  fig.refresh()

  val stdError = math.sqrt(variance(means) / means.size)
  println("Standard error is " + stdError)
}
