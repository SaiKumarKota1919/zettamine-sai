<%@page import="com.zm.ams.dto.Amc"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Search Results</title>
 <link rel="stylesheet" href="css/list-amc.css">
 <script src="sort.js"></script>
</head>
<style>
*{

font-size:14px;
font-family:sans-serif;
}

</style>
<body>
<%!  %>
  <h2 style="text-align:center;">Search Results</h2>
<a href="/appraiser-management-system/search-form.jsp" class="back-link">Back</a>
<a href="/appraiser-management-system/logout" class="logout-link">Logout</a> 
<a href="/appraiser-management-system/home.jsp" class="home-link">Home</a>
 <div class="sort-by">
    <label for="sort-options">Sort By:</label>
      
    <select id="sort-options" onchange="sortResults(this.value)">
    <option value="" selected disabled>Select sort option</option>
      <option value="name">Name</option>
      <option value="city">city</option>
      <option value="state">state</option>
      


    </select>
  </div>
  <table class="search-results">
    <thead>
      <tr>
        <th>Name</th>
        <th>State</th>
        <th>City</th>
      <!--  <th> Website </th> --> 
        <th>Status</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody id="resultsBody">
		<%session = request.getSession();
			List<Amc> amcList = (List<Amc>)session.getAttribute("amcList");
			//amcList.sort((Amc o1, Amc o2) -> {return o2.getAmcName().compareTo(o1.getAmcName());});%>
			<% for(Amc amc: amcList)
			{
			
			%>

			<tr>
				<td><%=amc.getAmcName() %></td>
				<td><%=amc.getState()%></td>
				<td><%=amc.getCity() %></td>
			<!-- <td><%=amc.getWebsite() %></td> -->	
				<td><%=amc.isActive()==true ? "Active" :"Inactive"%></td>
				<td class="action-links">
				<a class="view-projects" href="/appraiser-management-system/project?action=view&amcId=<%=amc.getAmcId() %>">View Project</a>
            <a class="add-project" href="/appraiser-management-system/add-project.jsp?amcId=<%=amc.getAmcId()%>">Add Project</a>
            <a class="edit-amc" href="/appraiser-management-system/project?action=edit&amcId=<%= amc.getAmcId() %>">Edit</a>
			</tr>
			<%
			}
			%>	
		   
   
     
   
    </tbody>
  </table>


</body>
</html>
