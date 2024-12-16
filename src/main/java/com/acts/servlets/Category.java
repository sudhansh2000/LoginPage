package com.acts.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		
	
		
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_b2","root","cdac");
		
			PreparedStatement pst=con.prepareStatement("select * from category");
			
			ResultSet rs=pst.executeQuery();
			
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th>Category Name </th>");
			out.print("<th>Description </th>");
			out.print("<th>Category Image </th>");
			out.print("</tr>");
			
			while(rs.next()) {
				out.print("<tr>");
				
				out.print("<td> <a href='Products?categoryId="+rs.getString("categoryId")+"'>" +rs.getString("categoryName") +"</a></td>");
				out.print("<td>"+rs.getString("categoryDesc") +"</td>");
				out.print("<td>"+rs.getString("categoryImgUrl") +"</td>");
				out.print("</tr>");
				
			}
			out.print("</table>");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			  
		}
		
		
		
	}
	

}
