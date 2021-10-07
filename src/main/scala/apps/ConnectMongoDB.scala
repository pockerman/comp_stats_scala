import org.mongodb.scala._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model._

import scala.collection.JavaConverters._

object ConnectMongoDB
{

	def main(args: Array[String]){
	
		// create a client that handles the connection for use
		println("Connecting to MongoDB client...")
		val mongoClient: MongoClient = MongoClient("mongodb+srv://alexGiavaras:da13div08pao@cluster0.akhvg.mongodb.net/mflix~?retryWrites=true&w=majority")
		
		// get the DB we want to work one
		println("Getting the DB...")
		val database: MongoDatabase = mongoClient.getDatabase("mflix")
		
		println("Listing Collection is DB...")
		val collections = database.listCollectionNames()
		collections.foreach(println)
		println("Accessing the collection...")
	
	}
}
