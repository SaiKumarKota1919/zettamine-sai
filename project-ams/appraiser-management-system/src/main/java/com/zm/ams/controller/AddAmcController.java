package com.zm.ams.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import com.zm.ams.dto.Amc;

import com.zm.ams.dto.User;
import com.zm.ams.services.AmcService;
import com.zm.ams.services.UserService;
import com.zm.ams.services.impl.AmcServiceImpl;
import com.zm.ams.services.impl.UserServiceImpl;

@WebServlet("/addAmc")
public class AddAmcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private AmcService amcService;
       
    
    public AddAmcController() {
        super();
        userService = new UserServiceImpl();
        amcService = new AmcServiceImpl();
       
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		int userId=0;
		try {
			userId = userService.getId((User)session.getAttribute("user"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
			Amc amc = new Amc(request.getParameter("registerId")
								,request.getParameter("name")
								,request.getParameter("remarks")
								,request.getParameter("website")
								,request.getParameter("addressLine1")
								,request.getParameter("addressLine2")
								,request.getParameter("state")
								,request.getParameter("city")
								,request.getParameter("zipCode")
								,LocalDate.now()
								,userId
								,LocalDate.now()
								,userId
								,Boolean.parseBoolean(request.getParameter("active")));
			
			try {
				amcService.save(amc);
				response.sendRedirect("home.jsp");			
				} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
