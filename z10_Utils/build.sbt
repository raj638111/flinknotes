
name := "z10_utils"
version := "0.0.2"

scalaSource in Compile := baseDirectory.value / "a10_src"
scalaSource in Test := baseDirectory.value / "a10_test"

libraryDependencies ++= Seq(
	"log4j" % "log4j" % "1.2.17"
)

