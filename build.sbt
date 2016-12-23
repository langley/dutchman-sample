name := "scratch"

version := "1.0"
cancelable in Global := true
connectInput in run := true
outputStrategy := Some(StdoutOutput)
fork in run := true
scalaVersion := "2.12.1"

resolvers += "LinkTargeting Repo" at "https://s3-us-west-2.amazonaws.com/repo.linktargeting.io/release"

libraryDependencies ++= Seq("core", "akka", "aws", "circe"
) map (x ⇒ "com.linktargeting.elasticsearch" %% s"elasticsearch-$x" % "0.5.64")

libraryDependencies ++= Seq("ch.qos.logback" % "logback-classic" % "1.1.7")