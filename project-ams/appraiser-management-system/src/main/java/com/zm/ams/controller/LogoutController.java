package com.zm.ams.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")

public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache"); 
		response.setDateHeader("Expires", 0); 
		response.sendRedirect("login-page.jsp");
		
	}
    
	
}
