package com.example.stocknews.data

import com.example.stocknews.module.News
import kotlinx.coroutines.Dispatchers
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream
import kotlinx.coroutines.withContext

class RSSParser {
    suspend fun get(xml: InputStream):List<News> = withContext(Dispatchers.IO) {
        val items = mutableListOf<News>()
        val factory = XmlPullParserFactory.newInstance()
        factory.isNamespaceAware = true
        val parser = factory.newPullParser()
        parser.setInput(xml.bufferedReader())

        var eventType = parser.eventType
        var currentTitle = ""
        var currentLink = ""
        var currentImage = ""

        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    when (parser.name) {
                        "item" -> {
                            currentTitle = ""
                            currentLink = ""
                            currentImage = ""
                        }
                        "title" -> currentTitle = parser.nextText()
                        "link" -> currentLink = parser.nextText()
                        "media" -> {
                            val url = parser.getAttributeValue("http://search.yahoo.com/mrss/", "url")
                            if (url != null) {
                                currentImage = url
                            }
                        }
                        else -> {
                            val url = parser.getAttributeValue(null, "url")
                            if (url != null) {
                                currentImage = url
                            }
                        }
                    }
                }
                XmlPullParser.END_TAG -> {
                    if (parser.name == "item") {
                        items.add(News(currentTitle, currentLink, currentImage))
                    }
                }
            }
            eventType = parser.next()
        }
        return@withContext items
    }
}