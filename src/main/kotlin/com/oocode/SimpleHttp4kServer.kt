package com.oocode

import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Method.GET
import org.http4k.core.Method.POST
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

val app: HttpHandler = routes(
    "/" bind GET to {
        val queries = it.queries("q")
        Response(OK).body(queries.firstOrNull()?.let { question ->
            println("question = ${question}")
            Answerer().answerFor(question) } ?: HomePage.HTML)
    }
)

fun main() {
    val server = SimpleHttp4kServer.http4kServer.start()
    println("Server started on " + server.port())
}

object SimpleHttp4kServer {
    val http4kServer = app.asServer(SunHttp(8124))
}

private object HomePage {
    val HTML = """
<html>
    <head><script src="https://unpkg.com/htmx.org@2.0.4"></script></head>
    <body>
        <h1>Simple http4k web service</h1>
        <p>This is a minimal web app using http4k</p>
        <ul>
            Try these questions:
            <li>What is your name?</li>
            <li>What is 2 + 2?</li>
        </ul>
        <input class="form-control" 
               style="width: 50%"
               type="search"
               name="q" 
               placeholder="Ask a question ..."
               hx-get="/"
               hx-params="*"
               hx-trigger="input changed delay:500ms, keyup[key=='Enter'], load"
               hx-target="#search-results">
        <div>Result of your query is: <span id="search-results"/></div>
    </body>
</html>""".trim()
}
