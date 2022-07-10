package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/otp")
public class OtpServlet extends HttpServlet{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/userdb?autoReconnect=true&useSSL=false";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "pushpanjali";  
	   Connection conn = null;
	   PreparedStatement stmt = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int OTP=Integer.parseInt(req.getParameter("OTP"));
		try{
				      //STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.prepareStatement("select * from user where otp=?");
				stmt.setInt(1,OTP);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()){
				resp.sendRedirect("index.jsp");
				System.out.println("Congratulations");
				}
				else {
					PrintWriter out=resp.getWriter();
					out.print("Invalid OTP");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
