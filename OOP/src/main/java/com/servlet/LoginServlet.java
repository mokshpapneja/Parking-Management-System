package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

import com.entity.User;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/userdb?autoReconnect=true&useSSL=false";
   //  Database credentials
   static final String USER = "root";

static final String PASS = "pushpanjali";  
   Connection conn = null;
   PreparedStatement stmt = null;
public void doGet(HttpServletRequest request,HttpServletResponse response)
throws IOException,ServletException{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String uname=request.getParameter("uname");
String pword=request.getParameter("pword");
if("admin".equals(uname)&&"admin".equals(pword)) {
	response.sendRedirect("admin/home.jsp");
}
if(uname==null||uname.equals("")||pword==null||pword.equals("")){
out.println("Username and password cannot be empty");
return;
}
try{
      //STEP 2: Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);
stmt = conn.prepareStatement("select * from user where uname=? and pword=?");
stmt.setString(1,uname);
stmt.setString(2,pword);
ResultSet rs=stmt.executeQuery();
if(rs.next()){

out.println("Welcome "+uname);
HttpSession session = request.getSession();
session.setAttribute("uname", uname);
response.sendRedirect("index.jsp");

}
else{
out.println("Given username and password are wrong");
out.println("Please try again");
}
}catch(SQLException e){
System.out.println("There is an exception with the database");
e.printStackTrace();
}
catch(Exception e){e.printStackTrace();}
finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}



protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	String uname=req.getParameter("Name");
	String email=req.getParameter("email");
	try{
	      //STEP 2: Register JDBC driver
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
	stmt.setString(1,uname);
	stmt.setString(2,"gmail");
	stmt.setString(3,email);
	stmt.setString(4,uname.split(" ")[0]);
	stmt.setString(5,uname.split(" ")[1]);
	stmt.setString(6,"-");
	stmt.setString(7,"-");
	stmt.setString(8,"-");
	stmt.setInt(9, 0);
	stmt.executeUpdate();
	resp.sendRedirect("index.jsp?uname="+uname);
	}
	
	catch(SQLException e){
		System.out.println("There is an exception with the database");
		e.printStackTrace();
		}
		catch(Exception e){e.printStackTrace();}
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		}
}
