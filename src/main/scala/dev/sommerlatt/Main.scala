package dev.sommerlatt

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.server.Router
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.syntax.kleisli._
import sttp.tapir._
import sttp.tapir.server.http4s._
import sttp.tapir.docs.openapi._
import sttp.tapir.openapi.circe.yaml._
import sttp.tapir.swagger.http4s.SwaggerHttp4s
import cats.implicits._

import scala.concurrent.ExecutionContext.global

object Main extends IOApp {

  val helloEndpoint: Endpoint[String, Unit, String, Nothing] =
    endpoint.get.in("hello").in(query[String]("name")).out(stringBody)

  val helloRoute: HttpRoutes[IO] =
    helloEndpoint.toRoutes(name => IO(s"Hello, $name!".asRight[Unit]))

  val docsRoute: HttpRoutes[IO] = new SwaggerHttp4s(
    helloEndpoint.toOpenAPI("hello world API", "0.1.0").toYaml
  ).routes

  val routes = Router[IO]() <+> helloRoute <+> docsRoute

  override def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(routes.orNotFound)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}
