package chapter3

import breeze.linalg._
import breeze.stats._


object CentralTendency {

  def main(args: Array[String]) = {


    // create a vector of size 5
    val data = DenseVector[Double](5.0, 3.5, 6.0, 20.3, 1.5, 7.8, 9.5, 8.4, 5.0)

    println("\n")
    println("Computing central tendency measures....")
    println(s"Vector mean is ${mean(data)}")
    println(s"Vector median is ${median(data)}")

    val mode_result = mode(data)
    println(s"Vector mode is ${mode_result.mode}")
    println(s"Vector mode frequency is ${mode_result.frequency}")

    println("\n")
    println("Computing variability measures....")

    println(s"Vector range is ${max(data) - min(data)}")

    val IQR = DescriptiveStats.percentile(data.toArray, 0.75) - DescriptiveStats.percentile(data.toArray, 0.25)
    println(s"Vector IQR is ${IQR}")

    println(s"Vector variance ${variance(data)}")
    println(s"Vector standard deviation ${stddev(data)}")


  }

}
