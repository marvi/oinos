import groovy.util.XmlSlurper

def file = new File("./sbsortiment.xml")

def root = new XmlSlurper().parseText(file.text)

//println root.artikel.Varugrupp.text().every { println it}

def winesXml = root.artikel.findAll { it.Varugrupp.text() in ["Rött vin", "Vitt vin"] }

def wines = []

winesXml.each {
  //println counter++ + " " + it.Namn.text() + "  " + it.Ursprung.text() + ", " + it.Ursprunglandnamn
  def w = new Wine(varunummer: it.Varnummer.text(),
                   name: it.Namn.text(),
                   region: it.Ursprung.text(),
                   country: it.Ursprunglandnamn.text(),
                   type: it.Varugrupp.text())
    wines.add(w)
}


def json = new groovy.json.JsonBuilder( wines )
def jsonStr = json.toPrettyString()

def jsonFile = new File("sortiment.json") << groovy.json.StringEscapeUtils.unescapeJavaScript(jsonStr)




class Wine {

    String varunummer
    String name
    String country
    String region
    String type

}