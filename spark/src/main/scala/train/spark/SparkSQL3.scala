package train.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object SparkSQL3{

 var spark: SparkSession = null
 val departuresDelaysFilePath = "/home/alex/qi3/ds_scala/data/databricks-datasets/learning-spark-v2/flights/departuredelays.csv"
 val airportsDataFilePath = "/home/alex/qi3/ds_scala/data/databricks-datasets/learning-spark-v2/flights/airport-codes-na.txt"
 
 def loadAirportsData(filename: String) : DataFrame  = {
 
    val df = spark.read.format("csv")
    .option("header", "true")
    .option("inferschema", "true")
    .option("delimiter", "\t")
    .load(filename)
     df
 }
 
 def loadDepartureDelaysData(filename: String) : DataFrame  = {
 
 	val df = spark.read
    .option("header", "true")
    .csv(filename)
    .withColumn("delay", expr("CAST(delay as INT) as delay"))
    .withColumn("distance", expr("CAST(distance as INT) as distance"))
    df
 }

 def main(args: Array[String]) {
  
    val csvFile = "/home/alex/qi3/spark_scala/data/spark/databricks-datasets/learning-spark-v2/flights/departuredelays.csv" 
    val appName: String = "SparkSQL Demo"
    
    // initialize the Spark session
    spark = SparkSession
    .builder()
    .enableHiveSupport()
    .appName(appName)
    .getOrCreate()
    
    val airports = loadAirportsData(airportsDataFilePath)
    airports.createOrReplaceTempView("airports_na")
    
    val delays = loadDepartureDelaysData(departuresDelaysFilePath)
    delays.createOrReplaceTempView("departureDelays")
    
    
    
    //spark.sql("DROP DATABASE IF EXISTS learn_spark_db CASCADE")
    //spark.sql("CREATE DATABASE learn_spark_db")
    //spark.sql("USE learn_spark_db")
    
    // create a table in the database we created above
    //spark.sql("CREATE TABLE managed_us_delay_flights_tbl (date STRING, delay INT, distance INT, origin STRING, destination STRING)")
    
    //val schema = "date STRING, delay INT, distance INT, origin STRING, destination STRING"
    
    //val df = spark.read.format("csv")
    //.option("header", "true")
    //.schema(schema)
    //.load(csvFile)
    
    
    
    // find all flights whose distance is greater than 1000 miles
    
    //spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE distance > 1000 ORDER BY distance DESC""").show(10)
    
    
    // find all flights between SFO and ORD with at least two hours delay
    //spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE delay > 120 AND origin = 'SFO' AND destination = 'ORD' ORDER BY distance DESC""").show(10)
}


}
