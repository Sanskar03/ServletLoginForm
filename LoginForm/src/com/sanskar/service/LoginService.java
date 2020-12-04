package com.sanskar.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sanskar.database.DBConfig;
import com.sanskar.entity.LoginDetails;

public class LoginService {

	private Connection conn;
	
	public LoginService() throws ClassNotFoundException, SQLException
	{
		conn = DBConfig.connectMySQL();
	}
	
	public List<LoginDetails> getDetails() throws SQLException
	{
		String query = "SELECT * FROM viewlogin";
		Statement stmt = conn.createStatement();
		ResultSet R = stmt.executeQuery(query);
		
		List<LoginDetails> list = new ArrayList<LoginDetails>();
		
		while(R.next()!=false)
		{
			LoginDetails LD = new LoginDetails(R.getString("username"),R.getString("password"));
			
			list.add(LD);
		}
		
		return list;
	}
	
}
