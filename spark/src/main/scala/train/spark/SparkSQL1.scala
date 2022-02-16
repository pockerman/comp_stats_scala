package train.spark

/*

Explore the DataFrame Column API

*/

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._


object SparkSQL1 {

  
  def main(args: Array[String]) {
  
    val csvFile = "/home/alex/qi3/spark_scala/data/spark/databricks-datasets/learning-spark-v2/flights/departuredelays.csv" 
    val appName: String = "SparkSQL Demo"
    
    val spark = SparkSession
    .builder()
    .appName(appName)
    .getOrCreate()
    
    val df = spark.read.format("csv")
    .option("inferSchema", "true")
    .option("header", "true")
    .load(csvFile)
    
    
    // create a temporary view 
    df.createOrReplaceTempView("us_delay_flights_tbl")
    
    // find all flights whose distance is greater than 1000 miles
    
    spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE distance > 1000 ORDER BY distance DESC""").show(10)
    
    
    // find all flights between SFO and ORD with at least two hours delay
    spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE delay > 120 AND origin = 'SFO' AND destination = 'ORD' ORDER BY distance DESC""").show(10)
}

}
