package chapter1

object SimulateTwoEvents extends App{

  val N_EXPERIMENTS = 100000

  val event_A_dist = breeze.stats.distributions.Binomial(1, 0.5)
  val event_B_dist = breeze.stats.distributions.Binomial(1, 0.5)

  var events = Vector[(Int, Int)]()

  for(exp <- 0 until N_EXPERIMENTS){

    val event_A = event_A_dist.sample()
    val event_B = event_B_dist.sample()

    events  = events  :+ (event_A, event_B)
  }

  var counter = 0.0
  // lets count 1s
  for( i <- 0 until events.size){

    if(events(i)._1 == 1  || events(i)._2 == 1){
      counter += 1.0
    }
  }

  // this should be almost equal to P(A | B) = P(A) + P(B) - P(A)P(B)
  println(s"Probability of Pr(A | B)=${counter / events.size}")
}
