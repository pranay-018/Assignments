package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
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
			String id = request.getParameter("idnum");
			String name = request.getParameter("name");
			String marksStr = request.getParameter("marks");
			int idNum = Integer.parseInt(id);
			int marks = Integer.parseInt(marksStr);
			String query = "insert into student values (?,?,?)";
			PreparedStatement stat = connection.prepareStatement(query);
			stat.setInt(1, idNum);
			stat.setString(2, name);
			stat.setInt(3, marks);
			int i = stat.executeUpdate();
			out.println("inserted");
			connection.close();
			request.getRequestDispatcher("index.jsp").forward(request, response);
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

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
