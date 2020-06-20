val tapirVersion = "0.15.4"

lazy val `tapir-assembly-npe-minification` =
  project
    .in(file("."))
    .settings(
      Seq(
        scalaVersion := "2.13.2",
        organization := "dev.sommerlatt",
        scalafmtOnCompile := true,
        logLevel in assembly := Level.Debug
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
