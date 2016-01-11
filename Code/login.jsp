<%-- 
    Document   : Login
    Created on : Nov 15, 2014, 12:49:36 PM
    Author     : Premkumar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "user-navigation.jsp" %>
<%@ include file= "site-navigation.jsp" %>
<div id="placeholder">
    <a href="index.jsp">Home-></a>
    <a href="Login.jsp">Login</a>
</div>

<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
 <c:choose>
        <c:when test="${theuser.firstname==null}">
    <br><br>
<p>Please enter your Login Details</p>

<form action="LoginController" method="post">
 <p>Username: <input type="text" required="required" name="email"><br><br>
    Password : <input type="password" required="required" name="password"><br><br></p>
<input type="submit"><br><br><p> Not an User
    <a href="Register.jsp">Sign up here</a></p>
</form>
</c:when> 
<c:otherwise>
    <p> Already Logged </p>
</c:otherwise>
 </c:choose>
</div>
</div>

<%@ include file= "footer.jsp" %>
