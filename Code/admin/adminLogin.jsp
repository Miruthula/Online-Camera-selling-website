<%-- 
    Document   : Login
    Created on : Nov 15, 2014, 12:49:36 PM
    Author     : Premkumar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "/header.jsp" %>
<%@ include file= "/user-navigation.jsp" %>
<%@ include file= "/site-navigation.jsp" %>
<div id="placeholder">
    <a href="/index.jsp">Home-></a>
    <a href="Login.jsp">Login</a>
</div>

<div id="sidebarcenter">
    <div id="place">
        <p>Welcome ${theuser.firstname}  </p>
    </div>
    <p>Please enter your Login Details</p>

<form action="j_security_check" method="post">
 <p>Username: <input type="text" required="required" name="j_username"><br><br>
    Password : <input type="password" required="required" name="j_password"><br><br></p>
<input type="submit" value="sign in"><br><br><p>
    
</form>
    </div>
</div>

<%@ include file= "/footer.jsp" %>
   


