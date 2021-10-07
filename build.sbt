name := "ds_scala"

version := "0.0.1"

scalaVersion := "2.12.12"

//libraryDependencies  ++= Seq(

  // Last stable release
  //"org.scalanlp" %% "breeze" % "1.2",

  // Native libraries are not included by default. add this if you want them
  // Native libraries greatly improve performance, but increase jar sizes.
  // It also packages various blas implementations, which have licenses that may or may not
  // be compatible with the Apache License. No GPL code, as best I know.
  //"org.scalanlp" %% "breeze-natives" % "1.1",

  // The visualization library is distributed separately as well.
  // It depends on LGPL code
  //"org.scalanlp" %% "breeze-viz" % "1.2",

//)

// https://mvnrepository.com/artifact/org.scalanlp/breeze
libraryDependencies += "org.scalanlp" %% "breeze" % "1.2"

// https://mvnrepository.com/artifact/org.scalanlp/breeze-viz

libraryDependencies += "org.scalanlp" %% "breeze-viz" % "1.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" %  "test"

//libraryDependencies += "au.com.bytecode" % "opencsv" % "5.0"
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.2.3"



// ===
