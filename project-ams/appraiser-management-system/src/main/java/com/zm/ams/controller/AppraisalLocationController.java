package com.zm.ams.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.impl.AppraisalLocationDao;
import com.zm.ams.dto.Amc;
import com.zm.ams.dto.AmcAppraisalLoc;
import com.zm.ams.dto.AmcSearchCriteria;
import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.marker.SearchCriteria;
import com.zm.ams.services.AmcAppraisalLocationService;
import com.zm.ams.services.AppraisalLocationService;
import com.zm.ams.services.impl.AmcAppraisalLocServiceImpl;
import com.zm.ams.services.impl.AmcServiceImpl;
import com.zm.ams.services.impl.AppraisalLocationServiceImpl;

@WebServlet("/add-location")
public class AppraisalLocationController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private AppraisalLocationService appraisalLocationService;
	private AmcAppraisalLocationService amcAppraisalLocationService;
       
  
    public AppraisalLocationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
			appraisalLocationService = new AppraisalLocationServiceImpl();
			amcAppraisalLocationService = new AmcAppraisalLocServiceImpl();
			Amc amc = new Amc();
			amc.setAmcName(request.getParameter("amcName"));
			try {
				
				
			AppraisalLoc appraisalLoc =	new AppraisalLoc(request.getParameter("state")
													,request.getParameter("city"));
				
				if(!appraisalLocationService.isExist(appraisalLoc))
				{
					appraisalLocationService.save(appraisalLoc);
				}
				int amcId= new AmcServiceImpl().getAmcId(amc);
				System.out.println(amcId);
				int locId= new AppraisalLocationServiceImpl()
						.getId(appraisalLoc);
				System.out.println(locId);
				
				AmcAppraisalLoc amcAppraisalLoc = new AmcAppraisalLoc( amcId,locId);
				
				if(!amcAppraisalLocationService.isExist(amcAppraisalLoc))
				{
					amcAppraisalLocationService.save(amcAppraisalLoc);
					response.sendRedirect("home.jsp");
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("amcExist","true");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-appraisal-loc.jsp");
					requestDispatcher.forward(request, response);
					
					
				}
				
				
			} catch (SQLException e) {
				
				
				
				e.printStackTrace();
			}
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		doGet(request, response);
	}

}
