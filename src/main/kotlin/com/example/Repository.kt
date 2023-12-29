package com.example

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

fun commitTextFromMB1(elem: Element): String {
    return elem.childNodes().filter { it.childNodeSize() > 0 }
        .joinToString(separator = "") { it.childNodes().first().toString() }
}
fun repoLog(repoName: String): List<String> {
    val requestUrl = "$repoName/commits"
    val doc = Jsoup.connect(requestUrl).get()
    val sections: Elements = doc.getElementsByClass("mb-1")
    return sections.map{
        commitTextFromMB1(it)
    }.toList().reversed()
}