package chapter2.basic

import breeze.linalg._
import breeze.plot._
import breeze.numerics._

object PlotSigmoid{

	def main(args: Array[String]){
	
		println("PlotSigmoid demo....")
		
		val x = linspace(-4.0, 4.0, 200)
		val fx = sigmoid(x)
	
		// This creates an empty Java Swing window 
		// (which may appear on your taskbar or equivalent). 
		// A figure can contain one or more plots.
		val fig = Figure()
		
		//  Let's add a plot to our figure:
		val plt = fig.subplot(0)
		
		// The plot function takes two arguments, 
		// corresponding to the x and y values of the data series to be plotted. 
		
		plt += plot(x, fx)
		
		// To view the changes, you need to refresh the figure
		fig.refresh()
		
		// You can also save the image programmatically as follows:
		fig.saveas("sigmoid.png")
	}


}
