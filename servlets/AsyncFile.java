package com.async_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncFile
 */
@WebServlet(urlPatterns = "/AsyncFile", asyncSupported = true)
public class AsyncFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AsyncFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AsyncContext asyncContext = request.startAsync();
		PrintWriter out = response.getWriter();

		String text = request.getParameter("text");
		Future<String> upperCase = EXECUTOR_SERVICE.submit(() -> {
			Thread.sleep(1000);
			return "String to UPPERCASE " + text.toUpperCase();
		});
		Future<String> reverseStr = EXECUTOR_SERVICE.submit(() -> {
			Thread.sleep(1000);
			return "String to reverse :  " + new StringBuffer(text).reverse().toString();
		});
		Future<String> strLen = EXECUTOR_SERVICE.submit(() -> {
			Thread.sleep(1000);
			return " String length : " + text.length();
		});
		EXECUTOR_SERVICE.submit(() -> {
			try {
				out.println(upperCase.get());
				out.println(reverseStr.get());
				out.println(strLen.get());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				asyncContext.complete();
			}
		});
	}

}
