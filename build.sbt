import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

name := "fp-in-scala-solution"

scalaVersion := "2.12.3"

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-encoding", "UTF-8",
  "-Ywarn-dead-code",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-numeric-widen",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-feature",
  "-Xlint:missing-interpolator"
)

fork in Test := true

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(RewriteArrowSymbols, true)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "3.0.3"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.13.5" % Test
)