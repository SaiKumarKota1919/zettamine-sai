package com.zm.ams.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.zm.ams.dto.Amc;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.services.AmcService;
import com.zm.ams.services.impl.AmcServiceImpl;

@WebServlet("/search")
public class SearchAmcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AmcService amcService = new AmcServiceImpl();
    
    public SearchAmcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		AmcSearchCriteria amcSearchCriteria = new AmcSearchCriteria(request.getParameter("companyName")
												,request.getParameter("state"),request.getParameter("city"));
		
		try {
			
			List<Amc> amcList  = amcService.getBySearchCriteria(amcSearchCriteria);
			HttpSession session = request.getSession();
			session.setAttribute("amcList", amcList);
			System.out.println(amcList);
			response.sendRedirect("list-amc.jsp");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("error","invalid");
			response.sendRedirect("search-form.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
																throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
