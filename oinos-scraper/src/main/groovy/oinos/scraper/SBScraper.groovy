/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package oinos.scraper

import org.jsoup.Jsoup

class SBScraper {


    def fetchWinePage(String url) {
        def doc = Jsoup.connect(url).get()

    }

}
