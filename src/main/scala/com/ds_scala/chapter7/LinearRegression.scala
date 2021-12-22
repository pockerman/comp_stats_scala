package com.ds_scala.chapter7

import breeze.linalg.{DenseMatrix, DenseVector}
import breeze.optimize.{DiffFunction, minimize}


object LinearRegression extends App{

  // data set
  val x = breeze.linalg.linspace(0.0, 10.0, length = 100)
  val y = x.map(x => 1.0 + 2.0 *x)

  System.out.println("Number of training examples: " + x.size)

  // the feature matrix
  val featureMatrix = DenseMatrix.horzcat(DenseMatrix.ones[Double](x.size, 1), x.toDenseMatrix.t)

  val model = new LinearRegressionModel
  model.train(matrix = featureMatrix, values = y)

  println(s"Model intercept=${model.polynomial(0)} slope=${model.polynomial(1)}")
}



object LinearRegressionModel
{

  def L(x: DenseMatrix[Double], y: DenseVector[Double], parameters: DenseVector[Double]): Double = {
    val yHat = x * parameters
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
        diff *= x(i, c)
        gradients(c) += diff
      }
    }
    -2.0 * gradients
  }
}

class LinearRegressionModel
{

  // one feature and one intercept term
  var polynomial: DenseVector[Double] = DenseVector.zeros[Double](2);

  def train(matrix: DenseMatrix[Double], values: DenseVector[Double]): Unit = {


    // set up the optimization
    val f = new DiffFunction[DenseVector[Double]] {
      def calculate(parameters: DenseVector[Double]) = (LinearRegressionModel.L(matrix, values, parameters=parameters),
        LinearRegressionModel.gradL(matrix, values, parameters = parameters))
    }

    val parameters = minimize(f, polynomial)
    polynomial = parameters
  }
}


