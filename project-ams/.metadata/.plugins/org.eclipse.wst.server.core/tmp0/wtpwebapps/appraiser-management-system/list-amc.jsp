<%@page import="com.zm.ams.dto.Amc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Search Results</title>
 <link rel="stylesheet" href="list-amc.css">
</head>
<body>

  <h2 style="text-align:center;">Search Results</h2>
<a href="search.html" class="back-link">Back</a>
<a href="login.html" class="logout-link">Logout</a> 
<a href="home.html" class="home-link">Home</a>
 <div class="sort-by">
    <label for="sort-options">Sort By:</label>
    <select id="sort-options" onchange="sortResults(this.value)">
      <option value="name">Name</option>
      <option value="location">Location</option>
      


    </select>
  </div>
  <table class="search-results">
    <thead>
      <tr>
        <th>Name</th>
        <th>State</th>
        <th>City</th>
        <th>Website</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
		<%session = request.getSession();
			List<Amc> amcList = (List<Amc>)session.getAttribute("amcList");
			for(Amc amc: amcList)
			{
			
		%>

			<tr>
				<td><%=amc.getAmcName() %></td>
				<td><%=amc.getState()%></td>
				<td><%=amc.getCity() %></td>
				<td><%=amc.getWebsite() %></td>
				<td><%=amc.isActive()==true ? "Active" :"Inactive"%>
				<td></td>
				<td class="action-links"><a href="view-project.html">View
						Project</a> <a href="add-project.html">Add Project</a> <a
					href="add_amc.html">Edit</a></td>
			</tr>
			<%
			}
			%>	
		   
   
      
   
    </tbody>
  </table>

  

  <
</body>
</html>
