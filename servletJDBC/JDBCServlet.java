package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCServlet
 */
@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JDBCServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		try {
			Class.forName(context.getInitParameter("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		try {

			String url = context.getInitParameter("url");
			String uname = context.getInitParameter("username");
			String pwd = context.getInitParameter("password");
			Connection connection = DriverManager.getConnection(url, uname, pwd);
			String query = "select * from student";
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(query); // result set is a buffered one
			ResultSetMetaData rms = rs.getMetaData();
			int colCount = rms.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= colCount; i++) {
					out.println(rms.getColumnName(i) + " :  " + rs.getString(rms.getColumnName(i)));

				}
				out.println();
			}
			rs.close();
			connection.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
