package foss.app.dataextracter

/**
 * http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
 */


//def thePattern = /<a>[ .\d\D\s\S]+<\/a>/
//def theString = "<a>boo foo</a><a>sfsf</a>";
//def theMatcher = theString=~thePattern
//
//theMatcher.each{
//
//	println it;
//
//}
//
	
	


def thePattern = /<a>[^(<\/a>)]+<\/a>/
def theString = "<a>boo foo</a><a>sfsf</a>";
def theMatcher = theString=~thePattern

theMatcher.each{

	println it;

}


def f = [2,2,2]

