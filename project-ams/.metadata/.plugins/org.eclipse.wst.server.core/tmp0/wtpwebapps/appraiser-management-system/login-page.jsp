<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>User Login</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f0f0f0;
    }

    .login-container {
      background-color: #fff;
      padding: 40px;
      border-radius: 10px;
      box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.1);
      text-align: center;
      width: 350px;
    }

    h2 {
      margin-bottom: 30px;
      color: #333;
    }

    .input-group {
      margin-bottom: 20px;
      text-align: left;
    }

    label {
      display: block;
      margin-bottom: 5px;
      color: #555;
    }

    input[type="text"],
    input[type="password"] {
      width: calc(100% - 22px);
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      background-color: #f9f9f9;
    }

    button {
      padding: 12px 24px;
      border: none;
      border-radius: 5px;
      background-color: #3498db;
      color: #fff;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    button:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>User Login</h2>
    <form id="login-form" action="login" method="post">
      <div class="input-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="userName" required placeholder="Enter user name">
      </div>
      <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required placeholder="Enter password">
      </div>
       <c:if test="${error!= null}">
      <span style=color:red>Invalid credentials try again!!!</span>
      </c:if><br><br>
      <button type="submit">Login</button>
     
    </form>
  </div>
</body>
</html>
 