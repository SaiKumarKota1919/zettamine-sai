package com.zm.ams.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.zm.ams.dto.User;
import com.zm.ams.services.UserService;
import com.zm.ams.services.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userService;
    
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		
	}
	
    public LoginController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
		User user = new User(request.getParameter("userName").trim(),request.getParameter("password").trim());
		
		
		try {
			System.out.println(userService.getId(user));
			if(userService.getId(user)!=0)
			{
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("userName", "user");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
				requestDispatcher.forward(request, response);
				
			}
			else {
				request.setAttribute("error","Invalid credentials" );
				RequestDispatcher rd = request.getRequestDispatcher("login-page.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException, IOException {
		doGet(request, response);
	}

}
