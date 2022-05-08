package com.ds_scala.chapter8

import breeze.linalg.{DenseMatrix, DenseVector}
import breeze.optimize.{DiffFunction, minimize, LBFGS}

object MultipleLinearRegression extends App{


  // data set
  val x1 = breeze.linalg.linspace(0.0, 10.0, length = 100)
  val x2 = breeze.linalg.linspace(15.0, 20.0, length = 100)
  val y = DenseVector.zeros[Double](size = 100)

  for(i <- 0 until 100){

    y(i) = 1.0 + 2.0 * x1(i) + 0.5 * x2(i)
  }

  // the feature matrix
  val featureMatrix = DenseMatrix.horzcat(DenseMatrix.ones[Double](x1.size, 1),
    x1.toDenseMatrix.t, x2.toDenseMatrix.t )

  val model = new MultipleLinearRegressionModel
  model.train(matrix = featureMatrix, values = y)

  println(s"Model intercept=${model.polynomial(0)}")
  println(s"Model x1-slope=${model.polynomial(1)} ")
  println(s"Model x2-slope=${model.polynomial(2)} ")

}


object MultipleLinearRegressionModel
{

  def L(x: DenseMatrix[Double], y: DenseVector[Double], parameters: DenseVector[Double]): Double = {

    // predict what the model gives
    val yHat = x * parameters

    // compute the error metric
    var value = 0.0
    for( i <- 0 until yHat.size){
      val diff =  y(i) - yHat(i)
      value += diff * diff
    }
    value
  }


  def gradL(x: DenseMatrix[Double], y: DenseVector[Double], parameters: DenseVector[Double]): DenseVector[Double]={


    val yHat = x * parameters

    // we have as many components as columns
    val gradients = DenseVector.zeros[Double](x.cols)

    for( i <- 0 until yHat.size){
      var diff =  y(i) - yHat(i)

      for( c <- 0 until gradients.size){
        //diff *= x(i, c)
        gradients(c) += diff * x(i, c)
      }

    }
    -2.0 * gradients
  }
}

class MultipleLinearRegressionModel
{

  // one feature and one intercept term
  var polynomial: DenseVector[Double] = DenseVector.zeros[Double](3);

  def train(matrix: DenseMatrix[Double], values: DenseVector[Double]): Unit = {


    // set up the optimization
    val f = new DiffFunction[DenseVector[Double]] {
      def calculate(parameters: DenseVector[Double]) = (MultipleLinearRegressionModel.L(matrix, values, parameters=parameters),
        MultipleLinearRegressionModel.gradL(matrix, values, parameters = parameters))
    }

    val lbfgs = new LBFGS[DenseVector[Double]](maxIter=10000, m=3)

    val optimum = lbfgs.minimize(f, init = polynomial)

    //val opts = new OptimizationOption()
    //val parameters = minimize(fn = f, init = polynomial)
    polynomial = optimum
  }
}
