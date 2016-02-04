name := "cingulata"

version := "1.0"

lazy val `cingulata` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

herokuAppName in Compile := "cingulata"

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(jdbc, cache, ws, filters, specs2 % Test)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "1.1.0"

libraryDependencies += "com.github.t3hnar" % "scala-bcrypt_2.11" % "2.5"

//casbah
libraryDependencies += "org.mongodb" %% "casbah" % "3.1.0"
