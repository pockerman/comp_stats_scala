package com.ds_scala.chapter0.breeze_intro

import breeze.linalg.{CSCMatrix, DenseMatrix}

object CreateMatrices extends App{

  val simpleMatrix=DenseMatrix((1,2,3),(11,12,13),(21,22,23))

  val sparseMatrix=CSCMatrix((1,0,0),(11,0,0),(0,0,23))

  val denseZeros=DenseMatrix.zeros[Double](5,4)
  val compressedSparseMatrix=CSCMatrix.zeros[Double](5,4)

  val identityMatrix=DenseMatrix.eye[Int](3)

  val randomMatrix=DenseMatrix.rand(4, 4)

  val vectFromArray=new DenseMatrix(2,2,Array(2,3,4,5))

  // Breeze also has an alternative element-by-element operation
  // that has the format of prefixing the operator with a colon, for example, :+,:-, :*, and so on.
  // Check out what happens when we do an element-wise multiplication of the identity matrix and the simple matrix:


  val elementWiseMulti = identityMatrix *:* simpleMatrix

  val vertConcatMatrix=DenseMatrix.vertcat(identityMatrix, simpleMatrix)
  val horzConcatMatrix=DenseMatrix.horzcat(identityMatrix, simpleMatrix)

  // The first column vector could be retrieved by passing in
  // the column parameter as 0 and using ::
  // in order to say that we are interested in all the rows.

  val firstVector=simpleMatrix(::,0)

  // Alternatively, you could explicitly pass in the columns to be extracted:

  val firstVectorByCols=simpleMatrix(0 to 1,0)
}
