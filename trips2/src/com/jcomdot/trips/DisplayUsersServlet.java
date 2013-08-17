package com.jcomdot.trips;

import java.io.IOException;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.*;

/**
 * Servlet implementation class DisplayUsersServlet
 */
@WebServlet("/displayUsers.html")
public class DisplayUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		Connection conn = null;
		StringBuffer sb = new StringBuffer("<html><body>");
		sb.append("<table>");
		sb.append("<tr><th>USER NAME</th></tr>");
		try {
			conn = getDbConnection();
			Statement statement = conn.createStatement();
			ResultSet users = statement.executeQuery("select first_name, last_name from customer");
			while (users.next()) {
				sb.append("<tr><td>");
				String username = users.getString("first_name") + " " + users.getString("last_name");
				sb.append(username);
				sb.append("</td></tr>");
			}
		} catch (Exception e) {
			System.err.println("Error Connection to database server.");
			System.err.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Database connection closed.");
				}
				catch (Exception e) {
					System.err.println("Error closing database connection.");
				}
			}
		}
		sb.append("</table>");
		sb.append("</body></html>");
		response.getOutputStream().write(sb.toString().getBytes());
	}
	
	private Connection getDbConnection() throws NamingException {
		Context initialContext = new InitialContext();
		Context envContext = (Context)initialContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/sakila");
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
