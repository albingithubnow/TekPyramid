package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		
		// load and regiser the databsae
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		// create a sql statement
		Statement stat = conn.createStatement();
		
		// execute select query and get result
		int result = stat.executeUpdate(" insert into project (project_id,created_by,created_on,project_name,status,team_size) values ('7','Kumar',CURRENT_TIMESTAMP,'FB','On Hold','15');");
		System.out.println(result);
		
		//close the connection
		conn.close();
		
	}
	
}
