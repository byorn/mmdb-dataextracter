package foss.app.dataextracter

import java.sql.Connection
import java.sql.DriverManager
import javax.sql.DataSource
import groovy.sql.Sql





def year = '2010-2019'
def filename = 'groovy.html'

def readfile = new File(filename)



def process = {
	
	tabledata ->
	
		
	XmlSlurper slurper = new XmlSlurper()
	
	def htmlParser = slurper.parseText(tabledata)
	
	int i = 1;
	
	htmlParser.tr.each{
		
		println htmlParser.tr[i].td[0].text()
		
		rank = htmlParser.tr[i].td[0].text()
		
		if(!"".equals(rank) && rank!=null){
		
				rating = htmlParser.tr[i].td[1].text()
			title = htmlParser.tr[i].td[2].text()
			
			vals = [rank, rating, title,year]
		
			DBConnectivity.insertToTable(vals)
		}
			
		i++;
	}

	println "finished succesfully"
}


def strXML = new StringBuilder();


readfile.each {

	 if (it.contains("<h2>Top Rated")){

		String line =  it
        strXML.append(line)
	   
	}
}


def myPattern = /<table[ \d\D\s\S\w\W]*table>/

def m = strXML=~myPattern


m.each{

	String s = it;

	tabledata = s.substring(s.indexOf("<table"),s.indexOf("/table>")+7)

	process(tabledata);
   
}



