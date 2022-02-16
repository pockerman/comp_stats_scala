package train.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object RDDOps {

  def squarePlusOne(x: Int): Int = {
  
  	val y = x + 1
  	y
  }
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("Spark RDD Demo")
    val sc = new SparkContext(conf)
    
    val data = Array(1,2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7)
    val rdd = sc.parallelize(data)
    rdd.foreach(println)
    
    // collect only the distinct element
    val distinctRDD = rdd.distinct()
    
    // filter the element greater than 5
    val greater5RDD = distinctRDD.filter(element => element > 5)
    
    
    // map the greater elements to their cube
    val cubeRDD = greater5RDD.map(x => x*x*x)
    
    
    // apply a function
    val cubeRDDPlusOne = cubeRDD.map(squarePlusOne)
   
  }
}
