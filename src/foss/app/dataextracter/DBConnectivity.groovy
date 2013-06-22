package foss.app.dataextracter


import java.sql.Connection
import java.sql.DriverManager
import javax.sql.DataSource
import groovy.sql.Sql


class DBConnectivity{
	
	
	def static insertToTable = {
		
	    def param ->
		
				
		def sql = Sql.newInstance('jdbc:mysql://localhost:3306/MMDB', 'root', '', 'com.mysql.jdbc.Driver')
		
		
		
		def sqlInsert = """INSERT INTO MOVIES (RANK, RATING, ID, TITLE, YEAR) VALUES (?, ?, NULL, ?, ?)"""

      

        sql.execute(sqlInsert,param);
		
//	
//		sql.eachRow('select * from table1'){ row ->
//			println row[0]
//		}
		
		
		
		
		
	}
	
	
}



