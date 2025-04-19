package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		
		
		// declaring globally
		Connection conn = null;
		
		try {
	//Step1 : load / register the database driver
		Driver driverreference = new Driver();
		DriverManager.registerDriver(driverreference);
		
		//registerdriver() will take care of loading the jdbc drive
		
		//step 2: connect to database
		
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("=====Done======");
		
		//Step 3 : create sql statement 
		Statement stat = conn.createStatement();
		
		//step 4 :  execute query and fetch result
		ResultSet resultset =	stat.executeQuery("select * from project");
		while (resultset.next()) {
//			System.out.println(resultset.getString(1));
			
			//to print multiple columns
			
			System.out.println(resultset.getString(1) + "\t" + resultset.getString(2)+
					"\t"+ resultset.getString(3) + "\t"+ resultset.getString(4) 
					+"\t"+ resultset.getString(5) +"\t"+ resultset.getString(6));
			
		}}
		catch (Exception e) {
			System.out.println("handle exception");
		}
		
		finally {
		// step 5 : close the connection
		
		conn.close();
		System.out.println("connection terminated");
		}
		
		
		
	}
}
