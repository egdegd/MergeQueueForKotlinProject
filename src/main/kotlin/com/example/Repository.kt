package com.example

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun repoLog(authorName: String, repoName: String): List<Pair<String, GitUser>>? {
    val client = OkHttpClient()
    val githubUrl = "https://api.github.com/repos/$authorName/$repoName/commits?per_page=100";
    val request = Request.Builder()
        .url(githubUrl)
        .build()

    client.newCall(request).execute().use { response ->
        if (response.isSuccessful) {
            val responseBody = response.body?.string()
            val gson = Gson()
            val commit: Commits = gson.fromJson("{\"commits\": $responseBody}", Commits::class.java)
            return commit.commits.map { Pair(it.commit.message, it.commit.author)}
        }
    }
    return null
}