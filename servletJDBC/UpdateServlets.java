package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlets
 */
@WebServlet("/UpdateServlets")
public class UpdateServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlets() {
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
			int idNum = Integer.parseInt(id);
			String query = "update student set name = ?  where id = ?";
			PreparedStatement stat = connection.prepareStatement(query);
			stat.setString(1, name);
			stat.setInt(2, idNum);
			stat.executeUpdate();
			out.println("updated name");
			connection.close();
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
