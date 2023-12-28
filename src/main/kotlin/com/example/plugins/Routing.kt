package com.example.plugins

import com.example.repoLog
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(FreeMarkerContent("searchrepo.ftl", model = null))
        }
        post {
            val formParameters = call.receiveParameters()
            val reponame = formParameters.getOrFail("reponame")
            try {
                val commitsList = repoLog(reponame)
                call.respond(FreeMarkerContent("listOfCommits.ftl",mapOf("commitsList" to commitsList)))
            } catch (e: Exception) {
                call.respond(FreeMarkerContent("searchrepoerror.ftl", model = null))
            }

        }
    }
}
