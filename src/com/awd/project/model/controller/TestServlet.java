package com.awd.project.model.controller;

import javax.servlet.annotation.WebServlet;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.sql.*;
import java.io.*;

@WebServlet("/ts")
public class TestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for Resource Injection
	@Resource(name="jdbc/admin")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		// Step 1:  Set up the print writer
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Step 2:  Get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try 
		{
			myConn = dataSource.getConnection();
			
			////////////////////////////////////////////// I USE THIS TO TEST CONNECTION WITH A PARTICULAR TABLE ///////////////////////////////////////////
			// Step 3:  Create a SQL statements
			String sql = "select * from company";
			myStmt = myConn.createStatement();
			
			// Step 4:  Execute SQL query
			myRs = myStmt.executeQuery(sql);
			
			// Step 5:  Process the result set
			while (myRs.next()) 
			{
				String email = myRs.getString("email");
				out.println(email);
			}
		}
		catch (Exception exc) 
		{
			exc.printStackTrace();
		}
	}

}
