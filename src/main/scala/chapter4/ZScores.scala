package chapter4

import breeze.integrate._
import breeze.linalg.{DenseVector}
import breeze.plot.{Figure, hist, plot}
import breeze.stats._

object ZScores extends App {

  // This creates an empty Java Swing window
  // (which may appear on your taskbar or equivalent).
  // A figure can contain one or more plots.
  val fig = Figure()

  //  Let's add a plot to our figure:
  val plt = fig.subplot(0)

  val g = breeze.stats.distributions.Gaussian(3.5, 1.25)
  val data = g.sample(1000)

  plt += hist(data, 100)

  // To view the changes, you need to refresh the figure
  fig.refresh()

  val vecData = DenseVector[Double](data.toArray)
  val standardize = Standardize.makeStandard(vecData)

  plt += hist(standardize, 100)

  // To view the changes, you need to refresh the figure
  fig.refresh()

  println(s"Percentae between z=0 and z=1 is ${trapezoid(Standardize.f, 0.0, 1.0, 1000)*100}")
  println(s"Percentae between z=0 and z=1 is ${trapezoid(Standardize.f, 0.0, 2.0, 1000)*100}")
  println(s"Percentae between z=0 and z=1 is ${trapezoid(Standardize.f, 0.0, 3.0, 1000)*100}")

}

object Standardize{

  def makeStandard(x: DenseVector[Double]): DenseVector[Double] = {

    val muAndVar = meanAndVariance(x)

    val mu = muAndVar.mean
    var std = math.sqrt(muAndVar.variance)

    val result = DenseVector.zeros[Double](x.length)
    for(i <- 0 until x.length){
      result(i) = (x(i) - mu) / std
    }

    result
  }

  def f(x: Double): Double = {
    ( 1.0 / math.sqrt(2.0 * math.Pi) ) * math.exp(-(x * x) * 0.5)
  }

}
