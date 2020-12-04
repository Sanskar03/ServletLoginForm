package com.sanskar.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanskar.entity.LoginDetails;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check_user = request.getParameter("username");
		String check_password = request.getParameter("password");
		
		PrintWriter pw = response.getWriter();
		
		boolean status = false;
		
		LoginService service;
		
		try {
			
			service = new LoginService();
			
			List<LoginDetails> list = service.getDetails();
			
			for(LoginDetails l:list)
			{
				if(check_user.equals(l.getUsername()))
				{
					if(check_password.equals(l.getPassword()))
					{
						status = true;
						break;
					}
				}
			}
			
			if(status==true)
			{
				pw.println("<html><h1 style=\"color:green\">Login Successfull</h1><br><br><h2 style=\"color:orange\"> Hello "+ check_user +" Welcome to Login Page </h2></html>");
			}
			else
			{
				pw.println("<html><h1 style=\"color:red\">Login Failed</h1></html>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
