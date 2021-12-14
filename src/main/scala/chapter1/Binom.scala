package chapter1

import breeze.linalg.DenseVector
import breeze.stats._
import scala.collection.mutable

object Binom {

  def main(args: Array[String]) = {
    val N_EXPERIMENTS = 100000

    val binomial = breeze.stats.distributions.Binomial(10, 0.5)


    // The simulation should agree with this
    println(s"Pr(X=5)=${binomial.probabilityOf(5)}")

    val cumProb = binomial.probabilityOf(4) + binomial.probabilityOf(3) + binomial.probabilityOf(2) + binomial.probabilityOf(1) + binomial.probabilityOf(0)
    println(s"Pr(X<=4)=${cumProb}")
    println(s"Pr(X=3)=${binomial.probabilityOf(3)}")
    println(s"Pr(X=2)=${binomial.probabilityOf(2)}")
    println(s"Pr(X=1)=${binomial.probabilityOf(1)}")
    println(s"Pr(X=0)=${binomial.probabilityOf(0)}")

    val flips = DenseVector.zeros[Double](N_EXPERIMENTS)
    val flipValues = new mutable.HashMap[Int, Int]()

    for(i <- 0 until N_EXPERIMENTS){

      val sample = binomial.sample()
      flips(i) = sample
    }

    // this should be close to 5 i.e E[X] = size * p = 10 * 0.5
    println(s"Average of flips ${mean(flips)}")

    // Var[X] = size * p * (1-p)
    println(s"Variance of flips ${variance(flips)}")



  }

}
