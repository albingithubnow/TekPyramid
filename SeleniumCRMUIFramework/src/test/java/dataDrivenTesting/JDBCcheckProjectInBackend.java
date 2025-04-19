package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class JDBCcheckProjectInBackend {

	@Test
	public void projetCheck() throws SQLException {
		
		String expectedProject =  "FB";
		boolean flag =false;
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("connection established");
		
		Statement stat = conn.createStatement();
		
		ResultSet resultset = stat.executeQuery("select * from project");
		while (resultset.next()) {
			String actProjectName = resultset.getString(4);
			if(expectedProject.equals(actProjectName)) {
				flag = true;
				System.out.println(expectedProject+ " is available ==== pass");
			}
				
			}
		if(flag == false) {
			System.out.println(expectedProject + "is not available ==== fail");
			Assert.fail();
		}
		
		conn.close();
	}
}
