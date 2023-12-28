package com.example

import org.jsoup.Jsoup
import org.jsoup.select.Elements

fun repoLog(repoName: String): List<String> {
    val requestUrl = "$repoName/commits"
    val doc = Jsoup.connect(requestUrl).get()
    val sections: Elements = doc.getElementsByClass("Link--primary text-bold js-navigation-open markdown-title")
    return sections.map{
        it.childNodes().first().toString()
    }.toList()
}