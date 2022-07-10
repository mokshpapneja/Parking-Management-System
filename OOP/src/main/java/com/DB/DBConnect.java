package com.DB;

import java.sql.Connection;

import java.sql.DriverManager;
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

public class DBConnect {

	private static Connection conn;
	public static Connection getConn()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/userdb?autoReconnect=true&useSSL=false","root","pushpanjali");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
