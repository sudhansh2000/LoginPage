package com.acts.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Taskbar.State;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		Connection con=null;
		PreparedStatement pst=null;
		
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_b2","root","cdac");
			pst=con.prepareStatement("insert into users values(?,?,?,?,?)");
			pst.setString(1, request.getParameter("user_name"));
			pst.setString(2, request.getParameter("pass"));
			pst.setString(3, request.getParameter("name"));
			pst.setString(4, request.getParameter("email"));
			pst.setString(5, request.getParameter("city"));
			
			pst.executeUpdate();
				
			
			out.println("<h2>user added sucesfully<h2>");
			out.println("<a href='login.html'>please click here to login </a>");
			System.out.println("user inserted sucessfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
