package oinos.scraper

class SbXmlParser {




    def fetchXmlFile() {
        def stream = getClass().getResourceAsStream("/sbsortiment.xml")
        def products = stream.text
        return new XmlSlurper().parseText(products)
    }

    def fetchAllWines() {
        def root = fetchXmlFile()
        def wines = root.artikel.findAll { it.Varugrupp.text() in ["Rött vin", "Vitt vin", "Mousserande vin"] }
        return wines
    }

}
