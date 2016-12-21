import spark.Spark

/**
 * Created by Daniel Szopa on 12/21/2016.
 */
fun main(args: Array<String>) {
    Spark.get("/hello") { req, res -> "Hello World!" }
    Spark.get("/stop") { request, response ->
        Spark.stop()
        "Server has been stopped"
    }
}