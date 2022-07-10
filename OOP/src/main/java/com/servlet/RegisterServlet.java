package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
String pass=request.getParameter("pword");
String email=request.getParameter("email");
String first=request.getParameter("first");
String last=request.getParameter("last");
String phone=request.getParameter("phone");
String car=request.getParameter("car");
String adress=request.getParameter("adress");
int otp=(int) Math.rint(Math.random()*100000);

try{
      //STEP 2: Register JDBC driver
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);
stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
stmt.setString(1,uname);
stmt.setString(2,pass);
stmt.setString(3,email);
stmt.setString(4,first);
stmt.setString(5,last);
stmt.setString(6,phone);
stmt.setString(7,car);
stmt.setString(8,adress);
stmt.setInt(9, otp);
stmt.executeUpdate();
SendSms.sendSms("OTP: "+otp,phone);


out.println("<body><form method='GET' action='otp'><h2>Enter OTP sent to your phone:</h2>  "
		+ " <input type= 'number' name='OTP'>  "
		+ "<input type=\"submit\" value=\"Submit\"></form>  "
		+ "</body>  "
		+ "<style>  "
		+ "    body{  "
		+ "        height: 100%;  "
		+ "        width: 100%;  "
		+ "        background:linear-gradient(to top, rgba(19, 206, 219, 0.52), rgba(55, 64, 145, 0.73));  "
		+ "    }  "
		+ "    form{  "
		+ "        position: absolute;  "
		+ "        top: 50%;  "
		+ "    left: 50%;  "
		+ "	transform: translate(-50%, -50%);  "
		+ "    color: whitesmoke;  "
		+ "    font-family: monospace;  "
		+ "    }  "
		+ "      "
		+ "</style>");
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
}