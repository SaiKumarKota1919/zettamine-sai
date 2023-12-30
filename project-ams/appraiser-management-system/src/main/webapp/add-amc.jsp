<%@page import="com.zm.ams.dto.States"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add AMC</title>
 <link rel="stylesheet" href="css/form.css">
</head>
<body>
  <form id="add-amc-form" action="addAmc">
<a href="/appraiser-management-system/logout" class="logout-link">Logout</a> 
<a href="/appraiser-management-system/home.jsp" class="home-link">Home</a>

    <h2>Add AMC Details</h2>
     <label for="register-id">Register ID:</label>
    <input type="text" id="register-id" name="registerId" required placeholder="Enter Register ID">

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required placeholder="Enter Name">

    <label for="remarks">Remarks:</label>
    <textarea id="remarks" name="remarks" rows="4" placeholder="Enter Remarks"></textarea>

    <label for="website">Website:</label>
    <input type="text" id="website" name="website" placeholder="Enter Website" required>

    <label for="address-line-1">Address Line 1:</label>
    <input type="text" id="address-line-1" name="addressLine1" placeholder="Enter Address Line 1" required>

    <label for="address-line-2">Address Line 2:</label>
    <input type="text" id="address-line-2" name="addressLine2" placeholder="Enter Address Line 2">


    <label for="state">State:</label>
    <select id="state" name="state" required>
      <option value="" selected disabled>Select a state</option>
      <%for(States state: States.values())
    	 {
    	  %>
    	  <option value="<%=state.getStateName()%>"><%=state.getStateName()%></option>
      <% }
      %>
     
    </select>

    <label for="city">City:</label>
    <input type="text" id="city" name="city" placeholder="Enter City" required>

    <label for="zip-code">Zip Code:</label>
 <!--   <input type="number" id="zip-code" name="zipCode" placeholder="Enter Zip Code" maxlength="6" min="6"  max="6" required> -->
 <input type="text" name="zipCode" placeholder="Enter Zip Code (6 digits)" id="myKadA" pattern="[0-9]{6}" maxlength="6" title="Please enter a 6-digit zip code" required>
 
    <label for="active">Active:</label>
    <input type="radio" id="active" name="active" value="true" required>
	Yes
	<input type="radio" id="active" name="active" value="flase" required>
	No<br><br>
    <button type="submit">Add AMC</button>
 <button type="button" class="cancel-button" onclick="window.location.href='home.jsp'">Cancel</button>


  </form>

</body>
</html>
