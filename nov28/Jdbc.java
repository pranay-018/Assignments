package com.nov_28.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class Jdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Driver loaded");
//		String uname = "root";
//		String pwd = "root@39";
//		String url = "jdbc:mysql://localhost:3306/power_consumption_tracker";
//		// establish connection and assign to Connnection object
//		Connection connection = DriverManager.getConnection(url, uname, pwd); // throws SQL exception (checked
//																				// exception)
//		System.out.println("connection exstablished");

//		// 3 statements
//		String query = "select * from customers";
//		// create statement
//		Statement stat = connection.createStatement();
//		ResultSet result = stat.executeQuery(query); // result set is a buffered one
//		// result set act as the iterator
//		while (result.next()) {
//			System.out.println("customer id : " + result.getInt(1) + "  --> customer Name : " + result.getString(2)
//					+ "  -->  customer email : " + result.getString(5));
//		}

//		ResultSetMetaData rsmd = result.getMetaData(); // note this metadata don't have autocloseble so don't write in
//														// try with resourse
//		int colCount = rsmd.getColumnCount();
//		for (int i = 1; i <= colCount; i++) {
//			System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnClassName(i));
//			System.out.println();
//		}
//		System.out.println();
//		while (result.next()) {
//			for (int i = 1; i <= colCount; i++) {
//				System.out.println(rsmd.getColumnName(i) + "  :  " + result.getString(rsmd.getColumnName(i)));
//
//			}
//			System.out.println();
//		}
//
//		// DataBase meta data for only related to database not for table related
//		DatabaseMetaData dbmd = connection.getMetaData();
//		System.out.println(dbmd.getDatabaseProductName()); // return type od database server ex: MySQl , oracle
//		ResultSet rs2 = dbmd.getTables("power_consumption_tracker", null, "%", new String[] {"TABLE"});
//		while(rs2.next()) {
//			
//			System.out.println(rs2.getString("TABLE_NAME"));
//		
//		}
		// insertion
//		String q = "insert into customers values (?,?,?,?,?)";
//		PreparedStatement preparedStatement = connection.prepareStatement(q); // here the statement is compiled (check
//																				// query syntax)
//		preparedStatement.setInt(1, 152);
//		preparedStatement.setString(2, "raju reddy");
//		preparedStatement.setString(3, "hyderabad");
//		preparedStatement.setString(4, "6532987416");
//		preparedStatement.setString(5, "raju@gmail.com"); // set the values in query
//		System.out.println(preparedStatement.executeUpdate()); // return the how many rows effecteed
//		System.out.println("row inserted successfully");
//		result.close();
//		stat.close();
//		connection.close();
//		String updateQuery = "update customers set customerAddress = ? where customerId = ?"; // we can alter the table
//																								// also using
//																								// updateeQuery
//		PreparedStatement ps = connection.prepareStatement(updateQuery);
//		ps.setString(1, "Hyderabad");
//		ps.setInt(2, 152);
//		ps.executeUpdate();
//		System.out.println("row updated successfully");
//		String updateQuery = "delete from  customers where customerId = ?"; // we can alter the table
//		// also using
//		// updateeQuery
//		PreparedStatement ps = connection.prepareStatement(updateQuery);
//		ps.setInt(1, 152);
//		ps.executeUpdate();
//		System.out.println("row deleted successfully");
		// callable

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		String uname = "root";
		String pwd = "root@39";
		String url = "jdbc:mysql://localhost:3306/demo";
		// establish connection and assign to Connnection object
		Connection connection = DriverManager.getConnection(url, uname, pwd); // throws SQL exception (checked
																				// exception)
		System.out.println("connection exstablished");
		CallableStatement cs = connection.prepareCall("{call gradeStatus(7)}"); // we can place holder so we can pass the
																				// parameter to the procedures and use
																				// cs.setInt or setString () passing
																				// values to the cs
		ResultSet rs = cs.executeQuery(); // note executeUpdate return int value but executeQuery return resultSet
		ResultSetMetaData rms = rs.getMetaData();
		int colCount = rms.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= colCount; i++) {
				System.out.println(rms.getColumnName(i) + " :  " + rs.getString(rms.getColumnName(i)));

			}
			System.out.println();
		}

	}
}
