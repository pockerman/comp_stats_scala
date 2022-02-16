/**
 * Using Spark to find the most popular movie
 * User ID, Movie ID, Rating, Timestamp
*/
package train.spark

import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, LongType, StringType, StructType}

object MostPopularMoview{

  // case class so that we can get a column name
  // for the movie ID
  final case class Movie(movieID: Int)
  def main(args: Array[String]): Unit ={

    val spark = SparkSession
      .builder()
      .appName("Popular Movies")
      .master("local[*]")
      .getOrCreate()

    // create a schema
    val moviesSchema = new StructType()
      .add("userID", IntegerType, nullable=true)
      .add("movieID", IntegerType, nullable=true)
      .add("rating", IntegerType, nullable=true)
      .add("timestamp", LongType, nullable=true)

    import spark.implicits._

    val moviesDS = spark.read
      .option("sep", "\t")
      .schema(moviesSchema)
      .csv(path = "data/ml-100k/u.data")
      .as[Movie]

    // sort movies by popularity
    val topMovieIDs = moviesDS.groupBy(col1 = "movieID").count().orderBy(desc(columnName = "count"))

    // grab the top 10
    topMovieIDs.show(numRows = 10)

    spark.stop()



  }

}
