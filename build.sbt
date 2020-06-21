val tapirVersion = "0.15.4"

lazy val `tapir-assembly-npe-minification` =
  project
    .in(file("."))
    .settings(
      Seq(
        scalaVersion := "2.13.2",
        organization := "dev.sommerlatt",
        scalafmtOnCompile := true
        // Fix: Use the following merge strategy to include the required file

        /*
         *assemblyMergeStrategy in assembly := {
         *  case PathList("META-INF", "maven", "org.webjars", "swagger-ui", "pom.properties") =>
         *    MergeStrategy.singleOrError
         *  case x =>
         *    val oldStrategy = (assemblyMergeStrategy in assembly).value
         *    oldStrategy(x)
         *}
         */
      )
    )
    .settings(
      libraryDependencies ++= Seq(
          "ch.qos.logback"               % "logback-classic"          % "1.2.3",
          "com.softwaremill.sttp.tapir" %% "tapir-core"               % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-http4s-server"      % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs"       % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-openapi-circe-yaml" % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-http4s"  % tapirVersion,
          "org.http4s"                  %% "http4s-blaze-server"      % "0.21.4"
        )
    )
