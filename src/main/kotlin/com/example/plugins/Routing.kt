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
            call.respond(FreeMarkerContent("searchRepo.ftl", model = null))
        }
        post {
            val formParameters = call.receiveParameters()
            val authorName = formParameters.getOrFail("authorName")
            val repoName = formParameters.getOrFail("repoName")
            try {
                val commitsList = repoLog(authorName, repoName)
                if (commitsList == null) {
                    call.respond(FreeMarkerContent("searchRepoError.ftl", model = null))
                } else {
                    call.respond(FreeMarkerContent("listOfCommits.ftl",mapOf("commitsList" to commitsList)))
                }
            } catch (e: Exception) {
                call.respond(FreeMarkerContent("searchRepoError.ftl", model = null))
            }

        }
    }
}
