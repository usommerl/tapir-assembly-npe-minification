val tapirVersion  = "0.15.4"
val http4sVersion = "0.21.4"

lazy val `tapir-assembly-npe-minification` =
  project
    .in(file("."))
    .settings(
      Seq(
        scalaVersion := "2.13.2",
        organization := "dev.sommerlatt",
        scalafmtOnCompile := true
      )
    )
    .settings(
      libraryDependencies ++= Seq(
          "ch.qos.logback"               % "logback-classic"          % "1.2.3",
          "com.softwaremill.sttp.tapir" %% "tapir-core"               % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-http4s-server"      % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-json-circe"         % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs"       % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-openapi-circe-yaml" % tapirVersion,
          "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-http4s"  % tapirVersion,
          "org.http4s"                  %% "http4s-blaze-server"      % http4sVersion,
          "org.http4s"                  %% "http4s-circe"             % http4sVersion,
          "org.http4s"                  %% "http4s-dsl"               % http4sVersion
        )
    )
