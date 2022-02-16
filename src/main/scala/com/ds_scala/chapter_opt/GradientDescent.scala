package com.ds_scala.chapter_opt

import breeze.linalg.{DenseVector, norm}
import breeze.optimize.DiffFunction
import scala.util.control.Breaks._

object GradientDescent extends App{

  def solve(nItrs: Int, tolerance: Double, eta: Double, fn: DiffFunction[DenseVector[Double]]): DenseVector[Double] = {

    var coeffs = DenseVector.zeros[Double](2)
    var oldGrad = fn.gradientAt(coeffs)

    breakable {
      for (itr <- 1 to nItrs) {


        coeffs(0) -= eta * oldGrad(0)
        coeffs(1) -= eta * oldGrad(1)

        var gradVal = fn.gradientAt(coeffs)
        val residual = norm(gradVal - oldGrad)
        if ( residual < tolerance) {

          println(s"Converged at iteration ${itr} with residual ${residual}")
          break
        }
      }
    }






  }

}
