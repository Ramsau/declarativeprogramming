ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

libraryDependencies += "org.scalatest" % "scalatest_2.13" % "3.2.15" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4" % "test"

lazy val root = (project in file("."))
  .settings(
    name := "FP4"
  )
