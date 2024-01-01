<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.zm.ams.dto.States"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Project</title>
  <link rel="stylesheet" href="css/form.css">
</head>
<body>
<a href="/appraiser-management-system/logout" class="logout-link">Logout</a> 
<a href="/appraiser-management-system/home.jsp" class="home-link">Home</a>
  <form id="add-project-form" action="project">
    <h2>Add Project</h2>
 	<label for="amcId">AMC ID:</label>
 	<input type="text" name="amcId" value="<%=request.getParameter("amcId")%>" readonly="readonly">
    <label for="project-type">Project Type:</label>
    <select id="project-type" name="project-type">
      <option value="" selected disabled>Select project type</option>
      <option value="type1">land-commercial</option>
      <option value="type2">land-residential</option>
   
    </select>

    <label for="project-client">Project Client:</label>
    <input type="text" id="project-client" name="project-client" placeholder="Enter project client">

    <label for="project-remarks">Project Remarks:</label>
    <textarea id="project-remarks" name="project-remarks" rows="4" placeholder="Enter project remarks"></textarea>

    <label for="client-remarks">Client Remarks:</label>
    <textarea id="client-remarks" name="client-remarks" rows="4" placeholder="Enter client remarks"></textarea>

    <label for="start-date">Start Date:</label>
    <input type="date" id="start-date" name="start-date">

    <label for="end-date">End Date:</label>
    <input type="date" id="end-date" name="end-date">
<br>

    <label for="state">State:</label>
    <select id="state" name="state">
      <option value="" selected disabled>Select state</option>
     <%for(States state: States.values())
    	 {
    	  %>
    	  <option value="<%= state.name()%>"><%=state.getStateName()%></option>
      <% }
      %>


    </select>
 

    <label for="city">City:</label>
    <select id="city" name="city">
      <option value="" selected disabled>Select city</option>
      

    </select>

    <label for="estimated-value">Estimated Value:</label>
    <input type="text" id="estimated-value" name="estimated-value" placeholder="Enter estimated value">

    <button type="submit" >Add Project</button>
<button type="button" class="cancel-button" onclick="window.location.href='list-amc.jsp'">Cancel</button>
  </form>
</body>
</html>
