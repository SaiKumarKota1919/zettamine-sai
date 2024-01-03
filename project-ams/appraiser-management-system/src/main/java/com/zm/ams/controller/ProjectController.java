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
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.zm.ams.dto.AppraisalLoc;
import com.zm.ams.dto.Project;
import com.zm.ams.services.ProjectService;
import com.zm.ams.services.impl.AppraisalLocationServiceImpl;
import com.zm.ams.services.impl.ProjectServiceImpl;

@WebServlet("/project")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectService projectService = new ProjectServiceImpl();

       
    public ProjectController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("add"))
		{
			int amcId = Integer.parseInt(request.getParameter("amcId"));
			int propertyTypeId = Integer.parseInt(request.getParameter("projectType"));
			String projectClient = request.getParameter("projectClient");
			String projectRemarks = request.getParameter("projectRemarks");
			String clientRemarks =  request.getParameter("clientRemarks");
			String sDate = request.getParameter("startDate");
			String eDate = request.getParameter("endDate");
			int locId = Integer.parseInt(request.getParameter("location"));
			LocalDate startDate = null;
			LocalDate endDate =  null;
			if(sDate!=null && eDate!=null)
			{
				startDate = LocalDate.parse(sDate);
	    				
						

				endDate = LocalDate.parse(eDate);
   

			}
			
			Double estimatedVal = Double.parseDouble(request.getParameter("estimatedValue"));
			
			try {
			
				Project project = new Project(amcId, propertyTypeId, projectClient
											, projectRemarks, clientRemarks, startDate
												, endDate, estimatedVal, locId);
				projectService.addProject(project);
				response.sendRedirect("list-amc.jsp");
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		if(request.getParameter("action").equals("view"))
		{
			try {
				List<Project> projectsList = projectService
											.getAllProjectsByAmc(Integer.parseInt(
													request.getParameter("amcId")));
				HttpSession session = request.getSession();
				session.setAttribute("projectsList", projectsList);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("view-projects.jsp");
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
