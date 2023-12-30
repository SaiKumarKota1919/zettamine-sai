<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Home Page</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
  <header>
    <h1>Welcome to Appraiser Management System</h1>
  </header>
  
  <nav>

    <a href="home.html">Home</a>
	<a href="/appraiser-management-system/add-appraisal-loc.jsp">Add Appraisal location</a>
    <a href="/appraiser-management-system/add-amc.jsp">Add AMC</a>
    <a href="search.html">Search</a>
    
    <a href="/appraiser-management-system/logout">Logout </a> 
   
  </nav>

  <div class="content">
    <h2>Appraiser Management System</h2>
    <p>Welcome to the Appraiser Management System. This system allows you to efficiently manage and track appraisers, their assignments, and related tasks. You can add new AMC (Appraisal Management Company) details, perform searches based on specific criteria, and manage your workflow effectively.</p>
    <p>Use the navigation options above to explore the system functionalities and manage your appraiser-related tasks effortlessly.</p>
  </div>
</body>
</html>
