/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package oinos.scraper

import spock.lang.Specification

class LibraryTest extends Specification {
    def "someLibraryMethod returns true"() {
        setup:
        def lib = new SBScraper()

        when:
        def result = lib.someLibraryMethod()

        then:
        result == true
    }
}
