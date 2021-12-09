package chapter2.basic

import breeze.plot._


object PlotGaussian {

  def main(args: Array[String]):Unit={

    // create a figure
    val f = Figure()

    val p = f.subplot(0)
    val g = breeze.stats.distributions.Gaussian(0,1)

    p += hist(g.sample(100000),100)
    p.title = "A normal distribution"
    f.saveas("subplots.png")
  }

}
