name := "mednet-middleware"

version := "1.0.0-SNAPSHOT"


resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.5",
  "com.typesafe.akka" %% "akka-remote" % "2.3.5"
)
lazy val root = (project in file(".")).enablePlugins(PlayScala)
