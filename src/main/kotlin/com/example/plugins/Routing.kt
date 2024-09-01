package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
private data class Get(val message: String)

fun Application.configureRouting() {
    routing {
        get {
            val who = context.request.queryParameters["who"] ?: "World"
            context.respond(Get(message = "Hello, $who"))
        }
    }
}
