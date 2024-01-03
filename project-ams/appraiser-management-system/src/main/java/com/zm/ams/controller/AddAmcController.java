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

import org.postgresql.util.PSQLException;

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
			Amc amc = new Amc(request.getParameter("registerId").trim()
								,request.getParameter("name").trim()
								,request.getParameter("remarks").trim()
								,request.getParameter("website").trim()
								,request.getParameter("addressLine1").trim()
								,request.getParameter("addressLine2").trim()
								,request.getParameter("state").trim()
								,request.getParameter("city").trim()
								,request.getParameter("zipCode").trim()
								,LocalDate.now()
								,userId
								,LocalDate.now()
								,userId
								,Boolean.parseBoolean(request.getParameter("active")));
			
			try {
				amcService.save(amc);
				response.sendRedirect("home.jsp");			
				}
			catch (PSQLException duplicateException) {
				    String duplicateErrorMessage = "Duplicate entry. This name already exists";
				    request.setAttribute("errorMessage", duplicateErrorMessage);
				    request.getRequestDispatcher("/add-amc.jsp").forward(request, response);
				}
			
			catch (SQLException e) {
				
				e.printStackTrace();
				response.sendRedirect("add-appraisal-loc.jsp");
			}
			
			
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
