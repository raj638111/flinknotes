name := "b25_DataStream"

scalaVersion := "2.12.8"

scalaSource in Compile := baseDirectory.value / "a10_src"

libraryDependencies ++= Seq(
  "org.apache.flink" %% "flink-scala" % "1.11.2",
  "org.apache.flink" %% "flink-streaming-scala" % "1.11.2",
  "org.apache.flink" %% "flink-streaming-java" % "1.11.2",
  "org.apache.flink" %% "flink-clients" % "1.11.2"
)

