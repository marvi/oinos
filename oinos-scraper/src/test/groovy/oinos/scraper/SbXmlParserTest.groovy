package oinos.scraper

import spock.lang.Specification

class SbXmlParserTest extends Specification {
    def "find all wines"() {
        setup:
        def parser = new SbXmlParser()

        when:
        def result = parser.fetchAllWines()

        then:
        result.size() == 200
    }
}
