# tapir-assembly-npe-minimisation #

* The application is working fine if you start it via `sbt run`
* Create a fat jar via the `sbt assembly` task
* Run the fat jar with the following command: `java -jar target/scala-2.13/tapir-assembly-npe-minification-assembly*.jar`

```
Exception in thread "main" java.lang.ExceptionInInitializerError
	at dev.sommerlatt.Main.main(Main.scala)
Caused by: java.lang.NullPointerException
	at sttp.tapir.swagger.http4s.SwaggerHttp4s.<init>(SwaggerHttp4s.scala:36)
```

#### Solution ####

To avoid this issue, you need to modify the default merge strategy of the assembly task:

```scala
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "maven", "org.webjars", "swagger-ui", "pom.properties") =>
    MergeStrategy.singleOrError
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

```
